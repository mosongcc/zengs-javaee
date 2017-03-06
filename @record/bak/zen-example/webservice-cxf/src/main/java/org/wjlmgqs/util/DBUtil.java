package org.wjlmgqs.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import org.apache.commons.lang.ArrayUtils;

public class DBUtil {

	private static String url = null;
	private static String driverClass = null;
	private static String userName = null;
	private static String password = null;
	private static int initPoolsSize = 2;
	private static int poolIndex = 0;//��ǰ��ʹ�õ���������
	private static Object locked = new Object();//lock����
	private static List<Connection> connPools = new ArrayList<Connection>();
	
	/**
	 * ��̬��ʼ��
	 */
	static {
		InputStream in = DBUtil.class.getClassLoader().getResourceAsStream("db.properties");
		Properties p = new Properties();
		try {
			p.load(in);
			url = p.getProperty("jdbc.url");
			driverClass = p.getProperty("jdbc.driverClass");
			userName = p.getProperty("jdbc.userName");
			password = p.getProperty("jdbc.password");
			initPoolsSize = Integer.parseInt(p.getProperty("jdbc.initPoolsSize"));
		} catch (IOException e) {
			WebLogger.showWarning("���ݿ����������ļ���ȡʧ��:"+e.getCause());
		}
		try {
			Class.forName(driverClass);
		} catch (ClassNotFoundException e) {
			WebLogger.showWarning("��������ʧ��:"+e.getCause());
		}
		initConnPools(initPoolsSize);
	}
	
	/**
	 * ��ʼ�����ݿ����ӳ�
	 */
	private static boolean initConnPools(int poolSize){
		boolean flag = false;
		try {
			for(int i=0;i<poolSize;i++){
				connPools.add(DriverManager.getConnection(url,userName,password));
			}
			flag = true;
		} catch (SQLException e) {
			WebLogger.showWarning("��ʼ�������ݿ����ӳ�ʧ��:"+e.getCause());
		}
		return flag;
	}
	
	/**
	 * ��ȡ���ݿ����ӳ��е�����
	 * @return
	 */
	public static Connection getConnection(){
		Connection conn = null;
		synchronized(locked){
			if(poolIndex==connPools.size()){
				initConnPools(1);
			}
			conn = connPools.get(poolIndex++);
		}
		return conn;
	}
	
	/**
	 * �ͷ�����
	 * @param conn
	 * @param stat
	 * @param rs
	 */
	public static void closeConnection(Connection conn,Statement stat,ResultSet rs){
		if(conn!=null){
			synchronized (locked) {
				poolIndex--;//ռ�õ�������������
			}
		}
		if(stat!=null){
			try {
				stat.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}finally{
				if(rs!=null){
					try {
						rs.close();
					} catch (SQLException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	/**
	 * ��ѯ���߷���
	 * @param <T>
	 * @param <T>
	 * @param conn
	 * @param sql
	 * @param params
	 */
	public static <T> T query(QueryBuilder<T> qb){
		T obj = null;
		Connection conn = getConnection();
		if(conn==null){
			return obj;
		}
		try {
			PreparedStatement ps = conn.prepareStatement(qb.getPrepareSQL());
			Object[] params = qb.getPrepareParams();
			if(params.length>0){
				qb.setParams(ps,params);
			}
			ResultSet rs = ps.executeQuery();
			obj = qb.execute(rs);
			String sqlMsg = "ִ��SQL��["+qb.getPrepareSQL();
			if(params.length>0){
				sqlMsg += ArrayUtils.toString(params);
			}
			sqlMsg += "]";
			WebLogger.showInfo(sqlMsg);
			closeConnection(conn,ps,rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
}

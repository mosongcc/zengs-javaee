package com.ul.dbutils;

import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * 根据实体类对象做数据库操作
 */
public class QueryRunner extends org.apache.commons.dbutils.QueryRunner {


    public static QueryRunner getInstance(){
        return new QueryRunner();
    }
    public static QueryRunner getInstance(Connection conn){
        return new QueryRunner(conn);
    }

    private Connection conn;

    public Connection getConnection(){
        return conn;
    }

    public QueryRunner(){
        this.conn = ConnectionFactory.getCurrentConnection();
    }

    public QueryRunner(Connection conn){
        this.conn = conn;
    }

    public void setConnection(Connection conn){
        this.conn = conn;
    }

    public void beginTransaction() throws SQLException {
        conn.setAutoCommit(false);
    }

    public void commit() throws SQLException {
         conn.commit();
    }

    public void rollback(){
        try {
            conn.rollback();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            ConnectionFactory.close();
        }
    }

    public void close(){
        ConnectionFactory.close();
    }

    public <T> List<T> query(Class<T> tClass ) throws SQLException {
        return super.query(getConnection(), "", new MapperBeanListHandler<T>(tClass), "");
    }

    /**
     * 字段映射BeanList实现
     * @param <T>
     */
    private class MapperBeanListHandler<T> implements ResultSetHandler<List<T>>{

        private final Class<T> type;

        public MapperBeanListHandler(Class<T> type){
            this.type = type;
        }

        @Override
        public List<T> handle(ResultSet rs) throws SQLException {
            List<T> list = new ArrayList<T>();
            while (rs.next()){
                list.add(resultSetToObject(type,rs));
            }
            return list;
        }
    }

    /**
     * ResultSet返回单个实体类对象
     * @param clazz
     * @param rs
     * @return
     * @throws SQLException
     */
    private <T> T resultSetToObject(Class<T> clazz,ResultSet rs) throws SQLException {
        try {
            ResultSetMetaData md = rs.getMetaData();    //得到结果集(rs)的结构信息，字段数、字段名等
            int columnCount = md.getColumnCount();      //返回此 ResultSet 对象中的列数

            //返回Map集合
            if(clazz==Map.class){
                Map<String,Object> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    Object v = rs.getObject(i);
                    v = v!=null?(v instanceof String?((String) v).trim():v):"";
                    rowMap.put(md.getColumnName(i),v);
                }
                return (T)rowMap;
            }

            //返回实体类对象
            T obj = clazz.newInstance();
            for (int i = 1; i <= columnCount; i++) {
                Object value;
                //获取实体类属性名
                String columnName = MapperEnum.get(clazz,md.getColumnName(i));
                //数字母转大写
                columnName = toUpperCaseFirstOne(columnName);
                try {
                    Class type = clazz.getMethod("get"+columnName).getReturnType();
                    if(type == String.class){
                        value = rs.getString(i);
                        value = value!=null?value.toString().trim():null;
                    }else{
                        value = rs.getObject(i);
                    }
                    clazz.getMethod("set"+columnName,type).invoke(obj,value);
                } catch (NoSuchMethodException e) {
                    //log.warn("实体对象属性[{}]不存在",columnName);
                }
            }
            return obj;
        }catch (Exception e) {
            e.printStackTrace();
            throw new SQLException(e.getMessage());
        }
    }

    //首字母转小写
    private static String toLowerCaseFirstOne(String s) {
        return new StringBuilder().append(Character.toLowerCase(s.charAt(0))).append(s.substring(1)).toString();
    }
    //首字母转大写
    private static String toUpperCaseFirstOne(String s) {
        return new StringBuilder().append(Character.toUpperCase(s.charAt(0))).append(s.substring(1)).toString();
    }

}

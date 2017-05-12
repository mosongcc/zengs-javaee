package com.zingson.jfain.jdbc;

import com.zingson.jfain.jdbc.dialect.Criteria;
import com.zingson.jfain.jdbc.dialect.Dialect;
import com.zingson.jfain.jdbc.dialect.ICallback;
import com.zingson.jfain.jdbc.tx.ITransaction;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JFJdbc {

    private final DbConfig config;
    private final Dialect dialect;

    static JFJdbc MAIN = null;
    private static final Map<String,JFJdbc> jfMap = new HashMap<>();

    public JFJdbc(DbConfig config){
        this.config = config;
        this.dialect = config.getDialect();
    }

    static void set(DbConfig config){
        jfMap.put(config.getName(), new JFJdbc(config));
        if(MAIN==null){
            MAIN = use(config.getName());
        }
    }

    static JFJdbc use(String configName){
        return jfMap.get(configName);
    }

    public int insert(Object obj) throws SQLException {
        final StringBuffer sql = new StringBuffer();
        final List<Object> values = new ArrayList<>();
        dialect.insert(sql,values,obj);
        return ex((conn)->dialect.executeUpdate(conn,sql,values.toArray()));
    }

    public int update(Object obj,Criteria...criterias) throws SQLException {
        final StringBuffer sql = new StringBuffer();
        final List<Object> values = new ArrayList<>();
        dialect.update(sql,values,obj,criterias);
        return ex((conn)->dialect.executeUpdate(conn,sql,values.toArray()));
    }

    public int delete(Class clazz,Criteria...criterias) throws SQLException {
        final StringBuffer sql = new StringBuffer();
        final List<Object> values = new ArrayList<>();
        dialect.delete(sql,values,clazz,criterias);
        return ex((conn)->dialect.executeUpdate(conn,sql,values.toArray()));
    }

    public <T>T ex(ICallback<T> callback) throws SQLException {
        Connection conn = null;
        try {
            conn = config.getConnection();
            return callback.call(conn);
        } catch (SQLException e) {
            throw e;
        } finally {
            if(conn!=null&&conn.getAutoCommit()){
                conn.close();
            }
        }
    }

    public <T>T tx(ITransaction<T> tran) throws SQLException {
        Connection conn = null;
        try {
            conn = config.getConnection();
            config.setThreadLocalConnection(conn);
            conn.setAutoCommit(false);
            T m = tran.transaction(this);
            conn.commit();
            return m;
        } catch (SQLException e) {
            conn.rollback();
            throw e;
        } finally {
            if(conn!=null){
                conn.close();
            }
            config.removeThreadLocalConnection();
        }
    }

    private <T>List<T> queryForList(Class<T> tClass,Class<T> returnClass, Criteria...criteria) throws SQLException {
        final StringBuffer sql = new StringBuffer();
        final List<Object> values = new ArrayList<>();
        dialect.queryModelList(sql,values,tClass,criteria);
        /*return ex((conn)->dialect.executeQuery(conn,(rs)->{
            List<T> rsList = new ArrayList<>();
            while (rs.next()){
                rsList.add(dialect.resultSetToObject(returnClass==null?tClass:returnClass,rs));
            }
            return rsList;
        },sql,values.toArray()));*/
        return rsList(sql,values,returnClass);
    }

    public List<Map<String,?>>  queryForListMap(Class tClass, Criteria...criteria) throws SQLException {
        return queryForList(tClass,(Class)Map.class,criteria);
    }

    public <T>List<T> queryForList(Class<T> tClass, Criteria...criteria) throws SQLException {
        return queryForList(tClass,null,criteria);
    }

    public <T>Page<T> paginate(int pageNumber,int pageSize,Class<T> tClass,Criteria...criteria) throws SQLException{
        StringBuffer sql = new StringBuffer();
        List<Object> values = new ArrayList<>();
        dialect.queryModelList(sql,values,tClass,criteria);
        StringBuffer sql1 = sql;
        dialect.paginate(pageNumber,pageSize,sql,values,tClass,criteria);
        return new Page<T>(rsList(sql,values,tClass),pageNumber,pageSize,rsCount(sql1,values));
    }

    public <T>List<T> rsList(final StringBuffer sql,final List<Object> values,Class<T> returnClass) throws SQLException {
        return ex((conn)->dialect.executeQuery(conn,(rs)->{
            List<T> rsList = new ArrayList<>();
            while (rs.next()){ rsList.add(dialect.resultSetToObject(returnClass,rs)); }
            return rsList;
        },sql,values.toArray()));
    }

    public Integer rsCount(final StringBuffer sql,final List<Object> values) throws SQLException {
        dialect.paginateCount(sql);
        return ((Map<String,Integer>)rsList(sql,values, Map.class).get(0)).entrySet().iterator().next().getValue();
    }
}

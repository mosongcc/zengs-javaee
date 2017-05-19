package com.zingson.jfain.jdbc;

import com.zingson.jfain.jdbc.dialect.Criteria;
import com.zingson.jfain.jdbc.dialect.Dialect;
import com.zingson.jfain.jdbc.tx.ITransaction;

import java.sql.Connection;
import java.sql.SQLException;
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

    private interface IUpdate<T>{
        T call(Connection conn) throws SQLException;
    }

    public <T>T update(IUpdate<T> update) throws SQLException {
        Connection conn = null;
        try {
            conn = config.getConnection();
            return update.call(conn);
        } catch (SQLException e) {
            throw e;
        } finally {
            if(conn!=null&&conn.getAutoCommit()){
                conn.close();
            }
        }
    }

    public int insert(Object obj) throws SQLException {
        return update((conn)-> dialect.insert(conn,obj));
    }

    public int update(Object obj,Criteria...criteria) throws SQLException {
        return update((conn)-> dialect.update(conn,obj,criteria));
    }

    public int delete(Class clazz,Criteria...criteria) throws SQLException {
        return update((conn)-> dialect.delete(conn,clazz,criteria));
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

    private interface IQuery<T>{
        List<T> call(Connection conn) throws SQLException;
    }

    public <T>List<T> query(IQuery<T> query) throws SQLException {
        Connection conn = null;
        try {
            conn = config.getConnection();
            return query.call(conn);
        } catch (SQLException e) {
            throw e;
        } finally {
            if(conn!=null&&conn.getAutoCommit()){
                conn.close();
            }
        }
    }

    public int count(IQuery query) throws SQLException{
        return (int)(((Map<String,Long>)query(query).get(0)).entrySet().iterator().next().getValue()/1);
    }


    public List<Map<String,?>>  queryForListMap(Class tClass, Criteria...criteria) throws SQLException {
        return query((conn) -> dialect.queryForListMap(conn, tClass, criteria));
    }

    public <T>List<T> queryForList(Class<T> tClass, Criteria...criteria) throws SQLException {
        return query((conn) -> dialect.queryForList(conn, tClass, criteria));
    }

    public <T>Page<T> paginate(Class<T> tClass,int pageNumber,int pageSize,Criteria...criteria) throws SQLException{
        List<T> list = query((conn)-> dialect.queryForListPage(conn,tClass,tClass,pageNumber,pageSize,criteria));
        int count = count((conn)->dialect.queryForCount(conn,tClass,criteria));
        return new Page<T>(list,pageNumber,pageSize,count);
    }

    /*public <T>List<T> rsList(final StringBuffer sql,final List<Object> values,Class<T> returnClass) throws SQLException {
        return query((conn)-> dialect.executeQuery(conn,(rs)->{

        },sql,values.toArray()));
        return ex((conn)->dialect.executeQuery(conn,(rs)->{
            List<T> rsList = new ArrayList<>();
            while (rs.next()){ rsList.add(dialect.resultSetToObject(returnClass,rs)); }
            return rsList;
        },sql,values.toArray()));
    }
*/
    /*public Integer rsCount(final StringBuffer sql,final List<Object> values) throws SQLException {
        dialect.paginateCount(sql);
        return ((Map<String,Integer>)rsList(sql,values, Map.class).get(0)).entrySet().iterator().next().getValue();
    }*/
}

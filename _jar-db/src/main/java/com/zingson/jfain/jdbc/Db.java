package com.zingson.jfain.jdbc;

import com.zingson.jfain.jdbc.dialect.Criteria;
import com.zingson.jfain.jdbc.tx.ITransaction;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 数据库操作类，可全局使用
 */
public class Db {

    /**
     * 加载数据源
     * @param configs
     */
    public static void init(DbConfig...configs){
        for (DbConfig config : configs) {
            JFJdbc.set(config);
        }
    }

    public static JFJdbc use(String configName) throws SQLException {
        return JFJdbc.use(configName);
    }

    public static int insert(Object obj) throws SQLException {
        return  JFJdbc.MAIN.insert(obj);
    }

    public static int update(Object obj, Criteria...criteria) throws SQLException {
        return  JFJdbc.MAIN.update(obj,criteria);
    }

    public static int updateByPrimaryKey(Object obj) throws SQLException {
        return 0;
    }

    public static int delete(Class tClass, Criteria...criteria) throws SQLException {
        return  JFJdbc.MAIN.delete(tClass,criteria);
    }

    public static int deleteByPrimaryKey(Object obj) throws SQLException {
        return 0;
    }

    public static <T>T tx(ITransaction<T> transaction) throws SQLException {
        return  JFJdbc.MAIN.tx(transaction);
    }

    public static  <T>List<T> queryForList(Class<T> tClass, Criteria...criteria) throws SQLException {
        return JFJdbc.MAIN.queryForList(tClass,criteria);
    }

    public static List<Map<String,?>> queryForListMap(Class tClass, Criteria...criteria) throws SQLException {
        return JFJdbc.MAIN.queryForListMap(tClass,criteria);
    }

    public static <T>Page<T> paginate(Class<T> tClass,int pageNumber,int pageSize,Criteria...criteria) throws SQLException{
        return JFJdbc.MAIN.paginate(tClass,pageNumber,pageSize,criteria);
    }

    public static <T>T queryForModel(Class<T> tClass,Criteria...criteria) throws SQLException {
        return JFJdbc.MAIN.queryForList(tClass,criteria).get(0);
    }

    public static <T>T queryForModelByPrimaryKey(Object obj) throws SQLException {

        return (T) obj;
    }

    public static int executeUpdate(String sql,Object...args) throws SQLException {
        return 0;
    }

    public static <T>List<T> executeQuery(Class<T> returnClass,String sql,Object...args) throws SQLException {
        return null;
    }

    public static int sqlUpdate(String id,Object...args) throws SQLException {
        return 0;
    }

    public static <T>List<T> sqlQuery(String id,Object args) throws SQLException {
        return null;
    }

}

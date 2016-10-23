package com.zengs.jdbc;

import javax.sql.DataSource;
import java.util.List;
import java.util.Map;

/**
 * jdbc 操作实例
 */
public abstract class JdbcInstence {

    protected DataSource dataSource;

    public JdbcInstence(){
        dataSource = new DruidPoolInstence().getDataSource();
    }

    abstract Integer insert(Object args); //Object为实体类

    abstract void update(Object args,String primaryKey); //Object实体类

    abstract void update(Object args,Criteria criteria); //args待修改的对象

    abstract void delete(Object args,String primaryKey); //实体类，指定主键

    abstract void delete(Class clazz,Criteria criteria);

    abstract <T> List<T>  selectList(Class<T> clazz);

    abstract List<Map<String,Object>>  selectListMap(Class clazz); //指定T为Map.class

    abstract <T> List<T>  selectList(Class<T> clazz,Criteria criteria);

    abstract List<Map<String,Object>>  selectListMap(Class clazz,Criteria criteria);

    abstract <T> T selectObject(Class<T> clazz,String primaryKey,Object value); //指定主键字段，返回一个对象

    abstract Map<String,Object> selectMap(Class clazz,String primaryKey,Object value);//指定返回类型map

    abstract <T> T selectField(Class clazz,Criteria criteria,Class<T> T); //确定返回字段一个

    // 指定sql
    abstract <T> List<T> query(String sql,Class<T> T,Object...args);//返回指定实体类类型

    abstract List<Map<String,Object>> query(String sql,Object...args); //不指定返回类型，默认Map

    abstract <T> T queryObject(String sql,Class<T> T,Object...args);

    abstract Map<String,Object> queryMap(String sql,Object...args); //不指定返回类型，默认Map

    abstract <T> T queryField(String sql,Class<T> T,Object...args);

    /**
     *
     * @param id         xml文件中配置的sql对应ID
     * @param clazz      返回类型，实体类
     * @param args       参数，实体类对象或者Map
     * @param <T>
     * @return
     */
    abstract <T> List<T>  criteriaQuery(String id,Class<T> clazz,Object args);

    abstract <K,V> List<Map<K,V>>  criteriaQuery(String id,Object args);




}

package com.zingson.jfain.jdbc.dialect;

import com.zingson.jfain.jdbc.annotation.JFMap;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @author jfain
 */
public abstract class Dialect {

    protected ConcurrentMap<String,Method> methodMap = new ConcurrentHashMap<>();

    public int executeUpdate(Connection conn,StringBuffer sql, Object...params) throws SQLException{
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql.toString());
            for (int i=0; i<params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            return pst.executeUpdate();
        } finally {
            if(pst!=null){
                pst.close();
            }
        }
    }

    public <T>List<T> executeQuery(Connection conn,RowMapper<T> rowMapper,StringBuffer sql, Object...params)throws SQLException{
        PreparedStatement pst = null;
        try {
            pst = conn.prepareStatement(sql.toString());
            for (int i=0; i<params.length; i++) {
                pst.setObject(i + 1, params[i]);
            }
            return rowMapper.call(pst.executeQuery());
        } catch (Exception e){
            throw new SQLException(e.getMessage());
        }finally {
            if(pst!=null){
                pst.close();
            }
        }
    }

    /*public void fillStatement(PreparedStatement pst, Object... paras) throws SQLException {
        for (int i=0; i<paras.length; i++) {
            pst.setObject(i + 1, paras[i]);
        }
    }*/

    public int insert(Connection conn,Object obj) throws SQLException {
        final StringBuffer sql = new StringBuffer();
        final List<Object> values = new ArrayList<>();
        Map<String,Object> map = getJFMap(obj);
        StringBuffer column = new StringBuffer();
        StringBuffer placeholder = new StringBuffer();
        map.forEach((k,v)->{
            column.append(k).append(",");
            placeholder.append("?,");
            values.add(v);
        });
        sql.append("INSERT INTO ").append(getTableName(obj.getClass()))
                .append(" ( ").append(column.substring(0,column.length()-1)).append(" ) values ( ")
                .append(placeholder.substring(0,placeholder.length()-1)).append(" ) ");
        return executeUpdate(conn,sql,values.toArray());
    }

    public int delete(Connection conn,Class clazz,Criteria...criterias) throws SQLException {
        final StringBuffer sql = new StringBuffer();
        final List<Object> values = new ArrayList<>();
        sql.append("DELETE FROM ").append(getTableName(clazz));
        where(sql,values,criterias);
        return executeUpdate(conn,sql,values.toArray());
    }

    public int update(Connection conn,Object obj,Criteria...criterias) throws SQLException {
        final StringBuffer sql = new StringBuffer();
        final List<Object> values = new ArrayList<>();
        sql.append("UPDATE ").append(getTableName(obj.getClass())).append(" SET ");
        Map<String,Object> map = getJFMap(obj);
        boolean b = false;
        for (Map.Entry<String,Object> entry:map.entrySet()){
            if(b){sql.append(",");}
            b=true;
            sql.append(entry.getKey()).append(" = ? ");
            values.add(entry.getValue());
        }
        where(sql,values,criterias);
        return executeUpdate(conn,sql,values.toArray());
    }

    public ResultSet queryModelById(Connection conn,Object obj) throws SQLException {
        final StringBuffer sql = new StringBuffer("SELECT * FROM ").append(getTableName(obj.getClass()));
        Map<String,Object> map = getJFMap(obj);
        List<Object> values = new ArrayList<>();
        Criteria criteria = new Criteria();
        map.forEach((k,v)->{
            criteria.andEqualTo(k,v);
        });
        where(sql,values,new Criteria[]{criteria});
        //ResultSet rs = executeQuery(conn,sql,values.toArray());
        return null;
    }
    public void queryModelList(final StringBuffer sql,final List<Object> values,Class clazz,Criteria...criterias) throws SQLException {
        sql.append("SELECT * FROM ").append(getTableName(clazz));
        where(sql,values,criterias);
    }

    /**
     * 单表条件查询
     * @param conn
     * @param clazz
     * @param criterias
     * @param <T>
     * @return
     * @throws SQLException
     */
    public <T>List<T> queryForList(Connection conn,Class<T> clazz,Criteria...criterias) throws SQLException {
        return queryForList(conn,clazz,clazz,criterias);
    }

    public <T>List<T> queryForListMap(Connection conn,Class<T> clazz,Criteria...criterias) throws SQLException {
        return queryForList(conn,clazz, (Class<T>) Map.class,criterias);
    }

    public <T>List<T> queryForList(Connection conn,Class<T> clazz,Class<T> returnClass,Criteria...criterias) throws SQLException {
        final StringBuffer sql = new StringBuffer("SELECT * FROM ").append(getTableName(clazz));
        final List<Object> values = new ArrayList<>();
        where(sql,values,criterias);
        return rsList(conn,sql,values,returnClass);
    }

    public <T>List<T> queryForListPage(Connection conn,Class<T> clazz,Class<T> returnClass,int pageNumber,int pageSize,Criteria...criterias) throws SQLException {
        throw new RuntimeException("You should implements this method in " + getClass().getName());
    }

    public List<Map> queryForCount(Connection conn, Class clazz, Criteria...criterias) throws SQLException {
        StringBuffer sql = new StringBuffer("SELECT * FROM ").append(getTableName(clazz));
        List<Object> values = new ArrayList<>();
        where(sql,values,criterias);
        sql = new StringBuffer("SELECT COUNT(*) FROM ( ").append(sql).append(" ) t_count_0");
        return rsList(conn,sql,values,Map.class);
    }

    public <T>List<T> rsList(Connection conn,final StringBuffer sql,final List<Object> values,Class<T> returnClass) throws SQLException {
        return executeQuery(conn,(rs)->rsToObject(rs,returnClass),sql,values.toArray());
    }

    private <T>List<T> rsToObject(ResultSet rs,Class<T> tClass) throws SQLException {
        List<T> rsList = new ArrayList<>();
        while (rs.next()){ rsList.add(resultSetToObject(tClass,rs)); }
        return rsList;
    }

    protected void where(final StringBuffer sql,final List<Object> values,final Criteria...criterias){
        if(criterias==null||criterias.length==0){
            return;
        }
        sql.append(" WHERE ");
        if(criterias.length==1){
            Criteria criteria = criterias[0];
            sql.append(criteria.getWhereSql());
            values.addAll(criteria.getValues());
            return;
        }
        int i = 0;
        for (Criteria criteria : criterias) {
            if(i!=0){
                sql.append(criteria.getJoin());
            }
            sql.append(" ( ").append(criteria.getWhereSql()).append(" ) ");
            values.addAll(criteria.getValues());
            i++;
        }
    }

    protected String getTableName(Class clazz){
        JFMap jfMap = (JFMap) clazz.getAnnotation(JFMap.class);
        return jfMap.value();
    }

    protected Map<String,Object> getJFMap(Object obj) {
        return getJFMap(obj,false);
    }

    protected Map<String,Object> getJFMap(Object obj,boolean isKey){
        Class clazz = obj.getClass();
        StringBuffer errMsg = new StringBuffer("Error entity JFMap ").append(clazz.getName());
        Map<String ,Object> map = new LinkedHashMap<>();
        try {
            Method[] methods = clazz.getDeclaredMethods();
            for (Method method : methods) {
                errMsg.append(method.getName());
                JFMap jfMap = method.getAnnotation(JFMap.class);
                if(jfMap==null||"".equals(jfMap.value())||jfMap.exclude()){ continue; }
                //只返回主键，支持联合主键
                if(isKey){
                    if(jfMap.isPrimaryKey()){
                        map.put(jfMap.value(),method.invoke(obj));
                    }
                }else {
                    map.put(jfMap.value(),method.invoke(obj));
                }
            }
            return map;
        } catch (SecurityException e) {
            errMsg.append(e.getMessage());
        } catch (IllegalAccessException e) {
            errMsg.append(e.getMessage());
        } catch (IllegalArgumentException e) {
            errMsg.append(e.getMessage());
        } catch (InvocationTargetException e) {
            errMsg.append(e.getMessage());
        }
        throw new RuntimeException(errMsg.toString());
    }

    //Cache set Method
    protected void setMethodMap(Class tClass) throws NoSuchMethodException {
        Annotation annotation = tClass.getAnnotation(JFMap.class);
        if(annotation==null){ return; }
        String className = tClass.getName();
        Method[] methods = tClass.getDeclaredMethods();
        for(Method method : methods){
            JFMap jfMap = method.getAnnotation(JFMap.class);
            if(jfMap==null){ continue; }
            if(methodMap.get(className+jfMap.value())!=null){break;}
            methodMap.put(className+jfMap.value(),tClass.getMethod(method.getName().replaceFirst("g","s"),method.getReturnType()));
        }

    }

    public <T> T resultSetToObject(Class<T> clazz,ResultSet rs) throws SQLException {
        String errMsg = null;
        try {
            ResultSetMetaData md = rs.getMetaData();    //得到结果集(rs)的结构信息，字段数、字段名等
            int columnCount = md.getColumnCount();      //返回此 ResultSet 对象中的列数

            //返回Map集合
            if(clazz==Map.class){
                Map<String, Object> rowMap = new LinkedHashMap<>();
                for (int i = 1; i <= columnCount; i++) {
                    rowMap.put(md.getColumnName(i), rs.getObject(i));
                }
                return (T) rowMap;
            }

            setMethodMap(clazz);
            Method method;
            //返回实体类对象
            T obj = clazz.newInstance();
            for (int i = 1; i <= columnCount; i++) {
                method = methodMap.get(clazz.getName()+md.getColumnName(i));
                if(method!=null){
                    method.invoke(obj,rs.getObject(i));
                }
            }
            return obj;
        } catch (NoSuchMethodException e) {
            errMsg = e.getMessage();
        } catch (InstantiationException e) {
            errMsg = e.getMessage();
        } catch (IllegalAccessException e) {
            errMsg = e.getMessage();
        } catch (InvocationTargetException e) {
            errMsg = e.getMessage();
        }
        throw new RuntimeException(errMsg);
    }


}

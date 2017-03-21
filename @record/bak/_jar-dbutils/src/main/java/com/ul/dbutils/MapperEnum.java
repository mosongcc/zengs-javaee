package com.ul.dbutils;

import entity.mapper.EMember;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * 表映射枚举类
 */
public class MapperEnum {

    private static final ConcurrentMap<String,String> mapperMap = new ConcurrentHashMap<>();

    public static String get(Class clazz,String k){
        String v = mapperMap.get(k);
        if(v==null){
            setMapper(clazz);
            v = mapperMap.get(k);
        }
        return v;
    }

    private static void set(String k,String v){
        mapperMap.put(k,v);
    }

    private static void setMapper(Class clazz){
        //获取当前Class所在包
        String currentPackage = clazz.getPackage().getName();
        String eMapper = currentPackage+".mapper.E"+clazz.getSimpleName();
        try {
            Class em = Class.forName(eMapper);
            if(em.isEnum()){
                Object[] objects = em.getEnumConstants();
                for (Object object : objects) {
                    //实体类属性名
                    String attribute = em.getDeclaredMethod("getAttribute").invoke(object).toString();
                    //数据库表字段名
                    String column = em.getDeclaredMethod("getColumn").invoke(object).toString();

                    set(attribute,column);
                    set(column,attribute);
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }

}

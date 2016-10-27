package com.zengs.util;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.LinkedHashMap;
import java.util.Map;

import static javafx.scene.input.KeyCode.T;


/**
 * Bean 操作工具类
 */
public class BeanUtil {

    /**
     * Bean 转 Map
     * @param obj
     * @return
     */
    public static Map<String,Object> toMap(Object obj){
        if(obj == null){ return null;}
        Map<String, Object> map = new LinkedHashMap<>();
        try {
            Field[] fields = obj.getClass().getDeclaredFields();
            for (Field field:fields) {
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(obj);
                if(!(Modifier.isFinal(field.getModifiers())||Modifier.isStatic(field.getModifiers()))){
                    map.put(name,value);
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }

    /**
     * Map 转 Bean
     * @param map
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T toBean(Map<String,Object> map,Class<T> clazz){
        T obj = null;
        try {
            obj = clazz.newInstance();

            //获取声明的字段
            Field[] fields = clazz.getDeclaredFields();
            for (Field field:fields) {
                field.setAccessible(true);
                String name = field.getName();
                Class type = field.getType();
                if (map.containsKey(name)) {
                    Object value = map.get(name);
                    //排除 final static 等修饰符的属性
                    if(Modifier.isFinal(field.getModifiers())||Modifier.isStatic(field.getModifiers())){
                        continue;
                    }
                    //int类型做转换
                    if((type.equals(int.class)||type.equals(Integer.class)) && !(value instanceof Integer)){
                        field.set(obj, Integer.parseInt(String.valueOf(value)));
                        continue;
                    }
                    field.set(obj,value);
                }
            }
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return obj;
    }

    /**
     * 复制对象属性
     * @param source
     * @param target
     * @return
     * @throws Exception
     */
    public static Object copyProperties(Object source,Object target){

        try {
            Field[] fieldsSource = source.getClass().getDeclaredFields();
            Field[] fieldsTarget = target.getClass().getDeclaredFields();

            for(Field s : fieldsSource) {
                if(Modifier.isFinal(s.getModifiers())||Modifier.isStatic(s.getModifiers())){
                    continue;
                }
                s.setAccessible(true);
                Object svalue = s.get(source);
                for(Field t:fieldsTarget){
                    if(Modifier.isFinal(t.getModifiers())||Modifier.isStatic(t.getModifiers())){
                        continue;
                    }
                    t.setAccessible(true);
                    if(s.getName().equals(t.getName())&&s.getType().equals(t.getType())){
                        t.set(target,svalue);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }

    public static Object copyProperties2(Object source,Object target){

        try {
            Method[] methodSource = source.getClass().getMethods();
            Method[] methodTarget = target.getClass().getMethods();

            for(Method methods:methodSource){

            }


            Field[] fieldsSource = source.getClass().getDeclaredFields();
            Field[] fieldsTarget = target.getClass().getDeclaredFields();

            for(Field s : fieldsSource) {
                if(Modifier.isFinal(s.getModifiers())||Modifier.isStatic(s.getModifiers())){
                    continue;
                }
                s.setAccessible(true);
                Object svalue = s.get(source);
                for(Field t:fieldsTarget){
                    if(Modifier.isFinal(t.getModifiers())||Modifier.isStatic(t.getModifiers())){
                        continue;
                    }
                    t.setAccessible(true);
                    if(s.getName().equals(t.getName())&&s.getType().equals(t.getType())){
                        t.set(target,svalue);
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return target;
    }



}

package com.zengs.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;



/**
 * Bean 操作工具类
 */
public class BeanUtil {

    /**
     * Bean 转 Map
     * @param obj
     * @return
     */
    public static Map<String,Object> toMap(Object obj) throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        if(obj == null){ return null;}
        Map<String, Object> map = new LinkedHashMap<>();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (!key.equals("class")) {
                Method setter = property.getReadMethod();
                Object value = setter.invoke(obj);
                map.put(key,value);
            }
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
    public static <T> T toBean(Map<String,Object> map,Class<T> clazz) throws NumberFormatException,IntrospectionException, IllegalAccessException, InstantiationException, InvocationTargetException {
        T obj = clazz.newInstance();
        BeanInfo beanInfo = Introspector.getBeanInfo(obj.getClass());
        PropertyDescriptor[] propertyDescriptors = beanInfo.getPropertyDescriptors();
        for (PropertyDescriptor property : propertyDescriptors) {
            String key = property.getName();
            if (map.containsKey(key)) {
                Object value = map.get(key);
                Class type = property.getPropertyType();
                Method setter = property.getWriteMethod();
                //类型是int，值非Int类型，尝试做转换
                if((type.equals(int.class)||type.equals(Integer.class)) && !(value instanceof Integer)){
                    setter.invoke(obj, Integer.parseInt(String.valueOf(value)));
                    continue;
                }
                //类型是String，值非String，尝试做转换
                if(type.equals(String.class)&&!(value instanceof String)){
                    setter.invoke(obj, String.valueOf(value));
                    continue;
                }
                setter.invoke(obj, value);
            }
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
    public static <T> T copyProperties(Object source,Class<T> target){
        try {
            return toBean(toMap(source),target);
        } catch (IntrospectionException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 驼峰命名法 格式
     * @param str    待转字符串
     * @param lower  true首字母小写
     * @return
     */
    public static String camelCase(String str,boolean lower){
        char[] charArr = str.toLowerCase().toCharArray();
        //首字母大写
        if ((!lower) && charArr[0] >= 'a' && charArr[0] <= 'z') {
            charArr[0] = (char) (charArr[0]-32);
        }
        //下划线后一位字母变大写
        for (int i = 1;i<charArr.length;i++) {
            if('_'==charArr[i]){
                charArr[i+1] = (char)(charArr[i+1]-32);
            }
        }
        return new String(charArr).replace("_","");
    }
    public static String camelCase(String str){
        return camelCase(str,true);
    }

}

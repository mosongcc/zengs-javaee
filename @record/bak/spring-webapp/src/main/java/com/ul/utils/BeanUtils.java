package com.ul.utils;

import java.beans.BeanInfo;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Bean操作工具类
 */
public class BeanUtils{



    /**
     * Bean to Map  Bean属性必须有get方法
     * @param bean
     * @return
     */
    public static Map<String,Object> bean2map(Object bean){
        try {
            Map<String,Object> returnMap = new LinkedHashMap<>();
            Class type = bean.getClass();
            BeanInfo beanInfo = Introspector.getBeanInfo(type);
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor:propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (!propertyName.equals("class")) {
                    Method readMethod = descriptor.getReadMethod();
                    Object result = readMethod.invoke(bean);
                    returnMap.put(propertyName, result);
                }
            }
            return returnMap;
        } catch (Exception e){
            System.out.println("ERROR bean2map fail ! "+ e.getMessage());
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Map to Bean  Bean属性必须有set方法
     * @param map
     * @param type
     * @return
     */
    public static <T> T map2bean(Map<String,Object> map,Class<T> type) {
        try {
            BeanInfo beanInfo = Introspector.getBeanInfo(type); // 获取类属性信息
            T obj = type.newInstance(); // 创建JavaBean 对象实例
            // 给 JavaBean 对象的属性赋值
            PropertyDescriptor[] propertyDescriptors =  beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor descriptor:propertyDescriptors) {
                String propertyName = descriptor.getName();
                if (map.containsKey(propertyName)) {
                    Object value = map.get(propertyName);
                    descriptor.getWriteMethod().invoke(obj, new Object[]{value});
                }
            }
            return obj;
        }  catch (Exception e){
            System.out.println("ERROR map2bean fail ! " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }




}

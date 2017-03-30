package com.ul.utils;


/**
 * String 字符串工具类
 */
public class Strings {


    public static String valueOf(Object obj){
        return obj==null?null:obj.toString();
    }

    public static String valueOfStr(Object obj){
        return obj==null?"":obj.toString();
    }

    public static boolean isEmpty(Object v){
        return v==null||"".equals(v instanceof String ?v.toString().trim():v);
    }

    public static boolean isEmpty(Object...obj){
        for (Object v:obj){
            if(v==null||"".equals(v))
            return true;
        }
        return false;
    }

}

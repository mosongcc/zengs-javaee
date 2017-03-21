package com.unionlive.util;

import java.util.List;

/**
 * 数组集合工具类
 */
public class Array {

    /**
     * List转为指定字符拼接字符串
     * @param list
     * @return
     */
    public static String listToString(List list,String c) {
        StringBuilder sb = new StringBuilder();
        for (Object s:list){
            sb.append(c).append(s);
        }
        return sb.toString().replaceFirst(c,"");
    }

    public static String[] stringToArray(Object s,String c){
        return String.valueOf(s).split(c);
    }

}

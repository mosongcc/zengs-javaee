package com.ul.utils;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Map操作工具类
 */
public class MapUtil {


    /**
     * 清理Map中value为空的选项
     * @param map
     * @return
     */
    public static Map<String,Object> clearEmptyItem(Map<String,Object> map){
        Map<String,Object> newMap = new LinkedHashMap<>();
        map.forEach((k,v)->{
            if(v!=null&&!"".equals(v)){ newMap.put(k,v); }
        });
        return newMap;
    }

    public static Map<String,String> getParameterMap(Map<String,String[]> params){
        Map<String,String> newMap = new LinkedHashMap<>();
        if(params==null||params.size()==0){ return newMap; }
        params.forEach((k,v)->{
            String s = "";
            for (String s1 : v) {
                s+=s1+",";
            }
            newMap.put(k, s.substring(0,s.length()-1));
        });
        return newMap;
    }

}

package com.unionlive.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.util.*;

/**
 * Json工具类
 * 提供 json xml map object 互相转换
 */
public class JsonUtil {


    private static ObjectMapper objectMapper = new ObjectMapper();


    /**
     * 利用TreeMap对map排序
     * @param obj  对Json转成的Map或者List排序
     * @return 返回排序后的参数  升序
     */
    public static <T> T ascMap(T obj){
        if(obj instanceof Map){
            Map<String, Object> tree = new TreeMap<>(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.compareTo(o2);
                }
            });
            ((Map<String,Object>) obj).forEach((k,v)->{
                if(v instanceof Map || v instanceof List){
                    tree.put(k,ascMap(v));
                }else{
                    tree.put(k,v);
                }
            });
            return (T)tree;
        }
        if(obj instanceof  List){
            List<Object> list = new ArrayList<>();
            ((List) obj).forEach((o)->{
                if(o instanceof Map || o instanceof List){
                    list.add(ascMap(o));
                }else{
                    list.add(o);
                }
            });
            return (T)list;
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static String obj2json(Object obj){
        try {
            return  objectMapper.writeValueAsString(obj);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    @SuppressWarnings("unchecked")
    public static Object json2obj(String json,Class obj){
        try {
            return objectMapper.readValue(json,obj);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Map集合转换成Json字符串
     * @param map
     * @return json
     * @throws JsonProcessingException
     */
    @SuppressWarnings("unchecked")
    public static String map2json(Map<String,?> map){
        if(map==null|| !(map instanceof Map)){ return ""; }
        try {
            return objectMapper.writeValueAsString(map).replaceAll("\"null\"","\"\"").replaceAll("null","\"\"");
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将Map集合排序后转换成Json字符串
     * @param map
     * @return json
     */
    public static String mapasc2json(Map<String,Object> map){
        return map2json((Map<String, ?>) ascMap(map));
    }

    /**
     * 将Map集合排序后转换成Json字符串
     * @param map
     * @return json
     */
    /*public static String mapdesc2json(Map<String,Object> map){
        Map<String, Object> sortMap = new TreeMap<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        return map2json(sortMap(sortMap,map));
    }*/

    /**
     * json转Map
     * @param json
     * @return json
     */
    @SuppressWarnings("unchecked")
    public static Map<String,?> json2map(String json){
        try {
            return objectMapper.readValue(json, Map.class);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
            System.out.println("Error 非法JSON字符串转Map出现异常："+json);
        }
        return new LinkedHashMap<>();
    }
    @SuppressWarnings("unchecked")
    public static Map<String,Object> json2objectmap(String json){
        return (Map<String,Object>)json2map(json);
    }
    @SuppressWarnings("unchecked")
    public static Map<String,String> json2stringmap(String json){
        return (Map<String,String>)json2map(json);
    }


    public static List<Object> json2list(String json){
        try {
            return objectMapper.readValue(json,ArrayList.class);
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓");
            System.out.println("Error 非法JSON字符串转List出现异常："+json);
        }
        return new ArrayList<>();
    }


}

package com.zingson.api.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.LinkedMap;
import org.junit.Test;
import org.omg.CORBA.Object;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 2017/5/11.
 */
public class APP {

    static ObjectMapper mapper = new ObjectMapper();

    static String query = "{\n" +
            "\t\"appid\": \"2323\",\n" +
            "\t\"sig\": \"123123ewerwefwfwefwef\",\n" +
            "\t\"biz\": {\n" +
            "\t\t\"users\": [{\n" +
            "\t\t\t\"params\": {\n" +
            "\t\t\t\t\"uid\": 123\n" +
            "\t\t\t},\n" +
            "\t\t\t\"filed\": \"uid,name,age,blogs\",\n" +
            "\t\t\t\"blogs\": {\n" +
            "\t\t\t\t\"params\": {\n" +
            "\t\t\t\t\t\"id\": \"#uid\"\n" +
            "\t\t\t\t},\n" +
            "\t\t\t\t\"filed\": \"id,title,content,commons\"\n" +
            "\t\t\t}\n" +
            "\t\t}]\n" +
            "\t}\n" +
            "}";

    public static void main(String[] args) {
        try {
            Map<String,Object> queryMap = mapper.readValue(query, LinkedMap.class);
            System.out.println(queryMap);

            Map<String,Object> bizMap = (Map<String, Object>) queryMap.get("biz");
            System.out.println(bizMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    @Test
    public void test(){


    }

    Map<String,Object> handle = new HashMap<>();

    public void usersModel(){

        Map<String,DefineField> map = new HashMap<>();
        //handle.put("users",map);


    }



    class DefineField<T>{

        private String name;
        private T type;
        private T value;
        private String explain;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public T getType() {
            return type;
        }

        public void setType(T type) {
            this.type = type;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public String getExplain() {
            return explain;
        }

        public void setExplain(String explain) {
            this.explain = explain;
        }
    }


}

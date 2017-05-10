package com.zingson.api.test;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.collections.map.LinkedMap;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by song on 2017/5/11.
 */
public class APP {

    ObjectMapper mapper = new ObjectMapper();

    @Test
    public void test(){
        String query = "{\n" +
                "    \"appid\":\"2323\",\n" +
                "    \"sig\":\"123123ewerwefwfwefwef\",\n" +
                "    \"biz\":{\n" +
                "        \"users\":[{\n" +
                "            \"params\":{ \"k\":\"v\"},\n" +
                "            \"filed\":\"uid,name,age,blogs\"\n" +
                "        }]\n" +
                "    }\n" +
                "}\n" +
                "\n";
        try {
            Map<String,Object> queryMap = mapper.readValue(query, LinkedMap.class);

            System.out.println(queryMap);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    Map<String,Object> handle = new HashMap<>();

    public void usersModel(){

        Map<String,DefineField> map = new HashMap<>();
        handle.put("users",map);


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

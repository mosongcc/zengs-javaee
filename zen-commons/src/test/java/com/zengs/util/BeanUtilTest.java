package com.zengs.util;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.*;

public class BeanUtilTest {

    @Test
    public void toMap() throws Exception {
        Person person = new Person();
        //person.setId(11);
        person.setName("张三");
        person.setCdate(new Date());

        System.out.println(BeanUtil.toMap(person));
    }

    @Test
    public void toBean() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id","11");
        map.put("name","张三");
        map.put("cdate",new Date());
        Person person = BeanUtil.toBean(map,Person.class);
        System.out.println(person.getName());
    }

}
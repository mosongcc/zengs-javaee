package com.zengs.commons.util;

import org.junit.Test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class BeanUtilTest {

    @Test
    public void toMap() throws Exception {
        Person person = new Person();
        //person.setId(11);
        person.setName("旺财");
        person.setCdate(new Date());
        person.setAge(111);

        System.out.println("-----------------");
        System.out.println(BeanUtil.toMap(person));
    }

    @Test
    public void toBean() throws Exception {
        Map<String,Object> map = new HashMap<>();
        map.put("id","11");
        map.put("age","11");
        map.put("name","旺财");
        map.put("cdate",new Date());
        Person person = BeanUtil.toBean(map,Person.class);

        Map<String,Object> map2 = BeanUtil.toMap(person);
        System.out.println(map2);
    }

}
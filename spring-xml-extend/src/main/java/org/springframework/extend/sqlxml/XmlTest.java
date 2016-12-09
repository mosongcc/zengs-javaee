package org.springframework.extend.sqlxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;


public class XmlTest {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        SqlMapperHandle ds = (SqlMapperHandle) context.getBean("sqlMapperHandle");
        System.out.println(ds.getSqlMapper());
    }
}

/**
spring.xml demo
 ----------------------------
 <?xml version="1.0" encoding="UTF-8"?>
 <beans xmlns="http://www.springframework.org/schema/beans"
 xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
 xmlns:sql="http://extend.spring.xml/schema/sql"
 xsi:schemaLocation="
 http://www.springframework.org/schema/beans
 http://www.springframework.org/schema/beans/spring-beans.xsd
 http://extend.spring.xml/schema/sql
 http://extend.spring.xml/schema/sql/sql.xsd">


 <sql:select id="merchant">
 select * from ULTAB_WM_CATE
 where 1=1
 </sql:select>

 <sql:select id="merchant2">
 select * from ULTAB_WM_CATE  where 1=1
 </sql:select>


 </beans>

*/

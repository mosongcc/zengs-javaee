package com.unionlive.generate;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class XmlTest {

    public static void main(String[] args)
    {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(
                "spring.xml");
        SqlMapper ds = (SqlMapper) context.getBean("merchant");
        System.out.println(ds.getId());
        System.out.println(ds.getValue());

        ds = (SqlMapper) context.getBean("merchant2");
        System.out.println(ds.getId());
        System.out.println(ds.getValue());
    }
}

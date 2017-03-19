package com.ul.dbutils;

import entity.mapper.EMember;
import org.apache.commons.dbutils.QueryRunner;

import javax.sql.DataSource;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 *
 */
public class DBManage {

    public static Connection getConnection(){
        return null;
    }
    public static Connection getConnection(DataSource dataSource) throws SQLException {
        return dataSource.getConnection();
    }

    public static void main(String[] args) {

        QueryRunner runner = new QueryRunner();



        Class clazz = null;// Member.class;

        Class clazz1 = EMember.class;

        String currentPackage = clazz.getPackage().getName();

        String eMapper = currentPackage+".mapper.E"+clazz.getSimpleName();
        System.out.println(eMapper);

        try {
            Class em = Class.forName(eMapper);
            if(em.isEnum()){
                Object[] objects = em.getEnumConstants();
                for (Object object : objects) {
                    Method attrMethod = em.getDeclaredMethod("getAttribute");
                    Object v = attrMethod.invoke(object);
                    System.out.println(v);
                }
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

}

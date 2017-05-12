package com.zingson.jfain.jdbc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.sql.Connection;

/**
 * SQL语句执行日志记录
 */
public class SqlReporter implements InvocationHandler {

    Logger log = LoggerFactory.getLogger(this.getClass());

    private Connection conn;

    SqlReporter(Connection conn) {
        this.conn = conn;
    }

    Connection getConnection() {
        Class clazz = conn.getClass();
        return (Connection) Proxy.newProxyInstance(clazz.getClassLoader(), new Class[]{Connection.class}, this);
    }

    //代理Connection，日志输出prepareStatement()方法参数
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        try {
            if (method.getName().equals("prepareStatement")) {
                log.debug("SQL:{}",args[0]);
            }
            return method.invoke(conn, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }
}

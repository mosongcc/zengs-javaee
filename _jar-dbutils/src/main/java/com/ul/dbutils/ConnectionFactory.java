package com.ul.dbutils;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionFactory {

    private static ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    public static Connection getCurrentConnection(){
        Connection conn = threadLocal.get();
        if(conn==null){
            //获取链接
            conn = DBManage.getConnection();
            threadLocal.set(conn);
        }
        return conn;
    }

    public static void close(){
        try {
            Connection conn = threadLocal.get();
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            threadLocal.remove();
        }
    }


}

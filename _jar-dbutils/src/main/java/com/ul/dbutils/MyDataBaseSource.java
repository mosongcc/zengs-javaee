package com.ul.dbutils;

/**
 * Created by song on 2017/3/18.
 */
public enum MyDataBaseSource {
    DATASOURCE;

    //private ComboPooledDataSource cpds = null;

    private MyDataBaseSource() {
        /*try {

            *//*--------获取properties文件内容------------*//*
            // 方法一:
            *//*
             * InputStream is =
             * MyDBSource.class.getClassLoader().getResourceAsStream("jdbc.properties");
             * Properties p = new Properties(); p.load(is);
             * System.out.println(p.getProperty("driverClass") );
             *//*

            // 方法二：(不需要properties的后缀)
            *//*
             * ResourceBundle rb = PropertyResourceBundle.getBundle("jdbc") ;
             * System.out.println(rb.getString("driverClass"));
             *//*

            // 方法三：(不需要properties的后缀)
            ResourceBundle rs = ResourceBundle.getBundle("jdbc");
            cpds = new ComboPooledDataSource();
            cpds = new ComboPooledDataSource();
            cpds.setDriverClass(rs.getString("driverClass"));
            cpds.setJdbcUrl(rs.getString("jdbcUrl"));
            cpds.setUser(rs.getString("user"));
            cpds.setPassword(rs.getString("password"));
            cpds.setMaxPoolSize(Integer.parseInt(rs.getString("maxPoolSize")));
            cpds.setMinPoolSize(Integer.parseInt(rs.getString("minPoolSize")));
            System.out.println("-----调用了构造方法------");
            ;
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    /*public Connection getConnection() {
        try {
            return cpds.getConnection();
        } catch (SQLException e) {
            return null;
        }
    }*/

}

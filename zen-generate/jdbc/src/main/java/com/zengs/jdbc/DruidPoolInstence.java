package com.zengs.jdbc;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;

/**
 * @date 2016-10-23
 * @author zengs
 * @descript   Druid 连接池实例
 *
 */

public class DruidPoolInstence extends AbstractPoolInstence  {

    private DruidDataSource dataSource = null;

    @Override
    protected DataSource getDataSource() {
        if (dataSource == null) {
            dataSource = new DruidDataSource();
            dataSource.setMaxActive(100);
            dataSource.setMinIdle(2);
            dataSource.setInitialSize(1);
            dataSource.setPoolPreparedStatements(true);
            dataSource.setTestOnBorrow(false);
            dataSource.setTestOnReturn(false);
            dataSource.setMinEvictableIdleTimeMillis(30);
            dataSource.setMaxWaitThreadCount(1000);
            dataSource.setDriverClassName("com.mysql.jdbc.Driver");
            dataSource.setUrl("jdbc:mysql://localhost:3306/lottery");
            dataSource.setUsername("root");
            dataSource.setPassword("root");
        }
        return dataSource;
    }
}

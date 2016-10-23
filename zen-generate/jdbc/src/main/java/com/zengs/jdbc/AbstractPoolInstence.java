package com.zengs.jdbc;


import javax.sql.DataSource;

/**
 * DB连接池实例抽象类
 */
public abstract class AbstractPoolInstence {

    private DataSource dataSource = null;


    protected abstract DataSource getDataSource();


}

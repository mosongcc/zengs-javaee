package com.zengs.jdbc;


import javax.sql.DataSource;

/**
 * DB连接池抽象实例
 */
public abstract class PoolInstence {


    protected abstract DataSource getDataSource();


}

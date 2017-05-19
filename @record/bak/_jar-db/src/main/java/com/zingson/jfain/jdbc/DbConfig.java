package com.zingson.jfain.jdbc;

import com.zingson.jfain.jdbc.dialect.Dialect;
import com.zingson.jfain.jdbc.dialect.MysqlDialect;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DbConfig {

    private final ThreadLocal<Connection> threadLocal = new ThreadLocal<>();

    String name = "db1";
    DataSource dataSource;
    Dialect dialect = new MysqlDialect();
    boolean showSql = true;
    boolean devMode = true;
    int transactionLevel = Connection.TRANSACTION_REPEATABLE_READ;

    public DbConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public DbConfig(DataSource dataSource, Dialect dialect) {
        this.dataSource = dataSource;
        this.dialect = dialect;
    }

    public DbConfig(String name,DataSource dataSource, Dialect dialect) {
        this.name = name;
        this.dataSource = dataSource;
        this.dialect = dialect;
    }

    public void init(String name, DataSource dataSource, Dialect dialect, boolean showSql, boolean devMode, int transactionLevel) {
        this.name = name;
        this.dataSource = dataSource;
        this.dialect = dialect;
        this.showSql = showSql;
        this.devMode = devMode;
        this.transactionLevel = transactionLevel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DataSource getDataSource() {
        return dataSource;
    }

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public Dialect getDialect() {
        return dialect;
    }

    public void setDialect(Dialect dialect) {
        this.dialect = dialect;
    }

    public boolean isShowSql() {
        return showSql;
    }

    public void setShowSql(boolean showSql) {
        this.showSql = showSql;
    }

    public boolean isDevMode() {
        return devMode;
    }

    public void setDevMode(boolean devMode) {
        this.devMode = devMode;
    }

    public int getTransactionLevel() {
        return transactionLevel;
    }

    public void setTransactionLevel(int transactionLevel) {
        this.transactionLevel = transactionLevel;
    }

    public final void setThreadLocalConnection(Connection connection) {
        threadLocal.set(connection);
    }

    public final void removeThreadLocalConnection() {
        threadLocal.remove();
    }


    public final Connection getConnection() throws SQLException {
        Connection conn = threadLocal.get();
        if (conn != null){
            return conn;
        }
        return showSql ? new SqlReporter(dataSource.getConnection()).getConnection() : dataSource.getConnection();
    }

    /**
     * Helps to implement nested transaction.
     * Tx.intercept(...) and Db.tx(...) need this method to detected if it in nested transaction.
     */
    public final Connection getThreadLocalConnection() {
        return threadLocal.get();
    }

}

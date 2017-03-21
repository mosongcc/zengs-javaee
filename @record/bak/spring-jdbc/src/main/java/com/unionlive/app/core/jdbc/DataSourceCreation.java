package com.unionlive.app.core.jdbc;

import org.springframework.stereotype.Component;

/**
 * 数据源配置
 */
@Component
public class DataSourceCreation {

    /**
     * Oracle数据源配置
     * Bean名称为方法名
     * @return
     */
    /*@Bean(initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(SysConfig.DB_URL);
        dataSource.setUsername(SysConfig.DB_USERNAME);
        dataSource.setPassword(SysConfig.DB_PASSWORD);
        dataSource.setInitialSize(2);                          //加载连接数
        dataSource.setMaxActive(600);                          //最大连接数
        dataSource.setMinIdle(3);                              //最小空闲
        dataSource.setMaxWait(30*1000);                        //获取链接最大等待时间，毫秒
        dataSource.setMinEvictableIdleTimeMillis(300*1000);    //连接在池中最小生存的时间，单位是毫秒
        dataSource.setTestOnBorrow(false);                     //申请连接时不检测
        dataSource.setTestOnReturn(false);                     //归还连接时不检测
        dataSource.setTestWhileIdle(true);                     //检查池中空闲连接状态
        dataSource.setPoolPreparedStatements(true);            //打开PSCache
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(200);  //最大PS链接数
        dataSource.setValidationQuery("SELECT 1 FROM DUAL");   //连接检查测试SQL
        dataSource.setOracle(true);
        return dataSource;
    }*/


}

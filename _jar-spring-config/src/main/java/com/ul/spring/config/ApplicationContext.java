package com.ul.spring.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.Collection;
import java.util.HashSet;

/**
 * 应用上下文配置
 */
@Configuration
@ComponentScan(basePackages = "com.ul", excludeFilters = { @ComponentScan.Filter(type = FilterType.ANNOTATION, value={Controller.class, RestController.class})})
@EnableAspectJAutoProxy(proxyTargetClass=true)
@EnableTransactionManagement(proxyTargetClass = true)     //启用事务
@EnableCaching                                             //缓存
@EnableScheduling                                          //计划任务
//@ImportResource(locations={"classpath:mapper/*.xml"})    //引入spring xml配置文件，不建议使用，可用@Configuration代替
@PropertySource({"classpath:config.properties"})
public class ApplicationContext {

    /**
     * 配置文件 config.properties，可根据key取值
     */
    @Autowired
    Environment env;

    /**
     * Oracle数据源配置
     * Bean名称为方法名
     * @return
     */
    @Bean(name = "dataSource",initMethod = "init",destroyMethod = "close")
    public DruidDataSource dataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.username"));
        dataSource.setPassword(env.getProperty("jdbc.password"));
        dataSource.setInitialSize(2);                          //加载连接数
        dataSource.setMaxActive(600);                          //最大连接数
        dataSource.setMinIdle(3);                              //最小空闲
        dataSource.setMaxWait(30*1000);                        //获取链接最大等待时间，毫秒
        dataSource.setMinEvictableIdleTimeMillis(5*60*1000);    //连接在池中最小生存的时间，单位是毫秒
        dataSource.setTestOnBorrow(false);                     //申请连接时不检测
        dataSource.setTestOnReturn(false);                     //归还连接时不检测
        dataSource.setTestWhileIdle(true);                     //检查池中空闲连接状态
        dataSource.setPoolPreparedStatements(true);            //打开PSCache
        dataSource.setMaxPoolPreparedStatementPerConnectionSize(1000);  //最大PS连接数
        dataSource.setValidationQuery("SELECT 1 FROM DUAL");   //连接检查测试SQL
        dataSource.setOracle(true);
        return dataSource;
    }


    @Resource(name="dataSource")
    public DataSource dataSource;

    @Bean(name = "jdbcTemplate")
    public JdbcTemplate jdbcTemplate(){
        return new JdbcTemplate(dataSource);
    }

    @Bean(name = "transactionManager")
    public DataSourceTransactionManager transactionManager(){
        return new DataSourceTransactionManager(dataSource);
    }

    /**
     * Spring缓存通过proxy的形式实现
     * 注意：1.内部this调用方法无效 2.非public方法无效
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        Collection<Cache> caches = new HashSet<Cache>();
        caches.add(new ConcurrentMapCache("default"));
        caches.add(new ConcurrentMapCache("config"));
        caches.add(new ConcurrentMapCache("session"));
        caches.add(new ConcurrentMapCache("shop"));
        cacheManager.setCaches(caches);
        return cacheManager;
    }


}

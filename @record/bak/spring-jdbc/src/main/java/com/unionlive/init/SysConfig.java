package com.unionlive.init;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * 项目配置文件 key-value
 */
public class SysConfig {

    private static final Logger log = LogManager.getLogger(SysConfig.class);

    private static Properties properties;


    /**
     * 数据库连接
     */
    public static final String DB_DRIVER = getConf("jdbc.driverClass");
    public static final String DB_URL = getConf("jdbc.url");
    public static final String DB_USERNAME = getConf("jdbc.username");
    public static final String DB_PASSWORD = getConf("jdbc.password");
    public static final String DB_INITIAL_SIZE = getConf("druid.initialSize");
    public static final String DB_MIN_IDLE = getConf("druid.minIdle");
    public static final String DB_MAX_ACTIVE = getConf("druid.maxActive");

    /**
     * 外卖平台ID
     */
    public static final String WM_BAIDU = getConf("union.wm.baidu");
    public static final String WM_MEITUAN = getConf("union.wm.meituan");
    public static final String WM_ELEME = getConf("union.wm.eleme");

    /**
     * 订单定时任务时间，单位秒
     */
    public static final String UL_ORDER_QUERY_DAY = getConf("union.orderQueryDay");
    public static final String UL_ORDER_TIMEOUT = getConf("union.timeoutOrdersSecond");
    public static final String UL_ORDER_TASK_INTERVAL = getConf("union.orderTaskIntervalSecond");

    /**
     * PC 消息通知服务URL
     */
    public static final String PC_PUSH_MSG_URL = getConf("union.feach.url");



    /**
     * 读取项目配置文件
     * @param key
     * @return
     */
    public static String getConf(String key){
        if(properties!=null&&properties.size()>0){
            return properties.getProperty(key);
        }
        try {
            System.out.println("static................");
            properties = new Properties();

            //通过类加载器读取项目配置文件config.properties
            properties.load(new FileInputStream(SysConfig.class.getResource("/config.properties").getPath()));
            log.info("加载默认配置文件:config.properties  ok");

            //获取Tomcat容器根目录
            String catalinaHome = System.getenv("CATALINA_HOME");
            String sysConfigPath = properties.getProperty("sys.config.path");

            if(sysConfigPath!=null&&!"".equals(sysConfigPath)){
                //加载外部容器中配置文件,覆盖默认配置
                String path = catalinaHome+File.separator+sysConfigPath.trim();
                log.info("外部配置文件路径:{}",path);
                properties.load(new FileInputStream(new File(path)));

                log.info("加载容器中配置文件:{} ok",path);
            }

        } catch (IOException e) {
            log.error("***********************************************************");
            log.error("项目初始化读取配置文件信息出错 {}",e.getMessage());
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        return properties.getProperty(key);
    }


}

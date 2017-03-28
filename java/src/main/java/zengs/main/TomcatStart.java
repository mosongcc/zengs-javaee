package zengs.main;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

import javax.servlet.ServletException;
import java.io.File;

/**
 * Created by song on 2017/3/29.
 */
public class TomcatStart {

    private static Tomcat tomcat;

    public static Tomcat getTomcat() {
        return tomcat;
    }

    private static StandardServer server;

    private static AprLifecycleListener listener;

    public static void main(String[] args) throws LifecycleException,
            ServletException {

        tomcat = new Tomcat();
        // 主机名，或ip
        tomcat.setHostname("localhost");
        // 设置端口，80为默认端口
        tomcat.setPort(8080);
        // tomcat用于存储自身的信息，可以随意指定，最好包含在项目目录下
        tomcat.setBaseDir(".");
        // 建立server参照tomcat文件结构
        server = (StandardServer) tomcat.getServer();
        listener = new AprLifecycleListener();
        server.addLifecycleListener(listener);
        // 将appBase设为本项目所在目录
        //tomcat.getHost().setAppBase(".");
        tomcat.getHost().setAppBase(
                System.getProperty("user.dir") + File.separator + ".");

        // 第二个参数对应docBase为web应用路径，目录下应有WEB-INF,WEB-INF下要有web.xml
        tomcat.addWebapp("", "java/src/main/webapp");
        // 启动tomcat
        tomcat.start();
        // 维持
        tomcat.getServer().await();
    }
}

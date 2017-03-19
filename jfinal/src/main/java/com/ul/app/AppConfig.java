package com.ul.app;

import com.jfinal.config.*;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.template.Engine;

public class AppConfig extends JFinalConfig {

    public void configConstant(Constants me) {
        me.setDevMode(true);

        me.setError404View("/error/404.html");

    }

    public void configRoute(Routes me) {


    }

    public void configEngine(Engine me) {
        ;
    }

    public void configPlugin(Plugins me) {
        DruidPlugin dp = new DruidPlugin("jdbc:mysql://localhost/db_name",
                "userName", "password");
        me.add(dp);
        ActiveRecordPlugin arp = new ActiveRecordPlugin(dp);
        me.add(arp);

        //arp.addMapping("user", User.class);
        //arp.addMapping("article", "article_id", Article.class);
    }

    public void configInterceptor(Interceptors me) {

    }

    public void configHandler(Handlers me) {

    }

}

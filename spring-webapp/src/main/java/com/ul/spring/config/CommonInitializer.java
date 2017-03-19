package com.ul.spring.config;


import org.springframework.core.annotation.Order;
import org.springframework.web.WebApplicationInitializer;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;

/**
 * 实现 WebApplicationInitializer 接口onStartup方法，启动执行，可实现web.xml中的配置，不建议这么作，可通过@WebServlet @Filter 等注解实现
 */
@Order(1)
public class CommonInitializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {

        System.out.println("onStartup-------------------");
    }
}

package com.zs.log4j2.servlet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/log4j2")
public class TestServet extends HttpServlet{

    private static Logger log = LogManager.getLogger(TestServet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    log.trace("trace- - ");
                    log.debug("debug- - ");
                    log.info("info- - ");
                    log.warn("warn- - ");
                    log.error("error- - ");
                    log.fatal("fatal- - ");

                    try {
                        Thread.sleep(1000*1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

    }
}

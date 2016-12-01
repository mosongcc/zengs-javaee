package com.zengs;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


// same as @Configuration @EnableAutoConfiguration @ComponentScan
@SpringBootApplication
public class Application {

    private static Logger log = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {

        log.debug("debug启动服务...");
        log.info("info启动服务...");
        log.warn("warn启动服务...");
        log.error("error启动服务...");

        SpringApplication.run(Application.class, args);
    }


}
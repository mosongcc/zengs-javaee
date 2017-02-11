package com.unionlive.app.controller;

import com.unionlive.init.SysConfig;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 */
@Controller
public class TestController {


    private static final Logger log = LogManager.getLogger(TestController.class);

    @RequestMapping("/home")
    @ResponseBody
    public String home(){

        log.info(SysConfig.DB_DRIVER);

        System.out.println(SysConfig.DB_USERNAME);

        return System.currentTimeMillis()+"";
    }

}

package com.zengs.controller;

import com.zengs.domain.User;
import com.zengs.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class HomeController {

    private static Logger log = LoggerFactory.getLogger(HomeController.class);
    @Autowired
    private UserService userService;

    @RequestMapping("/")
    List<User> home() {
        log.info("接收home请求");

        /*for (int i=0;i<100000;i++){
            log.debug("日志测试-{}，大量日志输出测试-{}",i,i);
        }*/

        return userService.findAll();
    }


}

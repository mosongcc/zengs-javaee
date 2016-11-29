package com.zengs.controller;

import com.zengs.domain.User;
import com.zengs.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;



@RestController
public class HomeController {


    @Autowired
    private UserService userService;

    @RequestMapping("/")
    List<User> home() {
        return userService.findAll();
    }


}

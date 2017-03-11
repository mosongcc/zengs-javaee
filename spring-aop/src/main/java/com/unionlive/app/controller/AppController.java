package com.unionlive.app.controller;

import com.unionlive.app.service.ZeMemberService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 *
 */
@Controller
public class AppController {

    @Resource
    private ZeMemberService zeMemberServiceImpl;

    @ResponseBody
    @RequestMapping(value = "/home")
    public String home(@RequestParam(value = "id") int id){

        return "home:";
    }
}

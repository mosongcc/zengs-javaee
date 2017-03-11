package com.unionlive.app.service.impl;

import com.unionlive.app.annotation.LoginAuth;
import com.unionlive.app.service.ZeMemberService;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 */
@Service
@Scope("prototype")
public class ZeMemberServiceImpl implements ZeMemberService{


    @LoginAuth
    @Override
    public String aopTest(String t) {
        try {
            Thread.sleep(1000);
            //System.out.println(Thread.currentThread().getId()+" service method 耗时 1s");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "aopTest";
    }

}

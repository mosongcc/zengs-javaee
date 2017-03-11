package com.unionlive.app.service.impl;

import com.unionlive.app.context.ContextHolder;
import com.unionlive.app.service.ZeMemberService;
import org.junit.Test;

import javax.annotation.Resource;
import javax.annotation.Resources;

import static org.junit.Assert.*;

public class ZeMemberServiceImplTest extends BaseJunitTest {

    //@Resource
    //private ZeMemberService zeMemberServiceImpl;

    private int count = 0;
    private int num = 50;

    @Test
    public void aopTest() throws Exception {
        for (int i =0;i<num;i++){
            thread();
        }
        while (true){
            Thread.sleep(3000);
            System.out.println("当前线程数："+Thread.activeCount());

        }
    }


    public void thread(){
        new Thread(()->{
            while (true){
                String v = ContextHolder.getBean(ZeMemberServiceImpl.class).aopTest("");
            }
        }).start();
    }

}
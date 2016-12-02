package com.zengs.generate;

import com.zengs.core.SimpleJdbc;

/**
 * Created by songz on 2016/12/2.
 */
public class AppParent {


    public void a(){
        //new SimpleJdbc().getCriteria().
        System.out.println("AppParent-aaaaaaaaaaaaaaa");
    }

    public void b(){
        a();
        System.out.println("aaaaaaaaaaaaaaa");
    }

}

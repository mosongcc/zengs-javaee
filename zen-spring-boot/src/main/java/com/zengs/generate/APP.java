package com.zengs.generate;

/**
 * Created by song on 2016/10/23.
 */
public class APP {

    public static void main_bak(String[] args) {
        System.out.println(System.getProperty("java.class.path"));

        System.out.println(APP.class.getProtectionDomain().getCodeSource().getLocation());
    }

}

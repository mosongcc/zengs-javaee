package com.ul.utils;

import java.math.BigDecimal;

/**
 * 价格单位换算
 */
public class PriceConver {


    //价格单位 元换算为分
    public static Integer fen(Object yuan){
        return new BigDecimal(100).multiply(new BigDecimal(String.valueOf(yuan))).intValue();
    }

    //价格单位 元换算为分
    public static String penny(Object yuan){
        return new BigDecimal(100).multiply(new BigDecimal(String.valueOf(yuan))).toString();
    }

    //价格单位 分换算为元
    public static float yuan(Object fen){
        return new BigDecimal(String.valueOf(fen)).divide(new BigDecimal(100)).floatValue();
    }

}

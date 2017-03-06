package com.unionlive.util;

/**
 * 加减乘除运算
 */
public class ArithUtil {


    private int parseInt(String number){
        try {
            return Integer.parseInt(number);
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return 0;
    }




}

package com.ul.utils;

import java.math.BigDecimal;
import java.util.regex.Pattern;

/**
 * 字段效验工具类
 */
public class Validation {


    /**
     * 是否为空
     * @param args  N个参数，有一个为null则返回false
     * @return 为null "" 时返回true  否则返回false
     */
    public static boolean isEmpty(Object... args){
        for (Object str:args){
            if(str==null||"".equals(String.valueOf(str).trim())||"null".equals(String.valueOf(str).trim())||"NULL".equals(String.valueOf(str).trim())){
                return true;
            }
        }
        return false;
    }

    public static boolean isNotEmpty(Object... args){
        return !isEmpty(args);
    }

    /**
     * 非数字返回-1，否则返回int
     * @param arg
     * @return
     */
    public static Integer isNumber(Object arg){
        try {
            return Integer.parseInt(String.valueOf(arg).trim());
        } catch (NumberFormatException e) {
        }
        return null;
    }

    public static boolean isNumber(Object... args){
        boolean f = true;
        try {
            for (Object str:args){
                if(str!=null){
                    String arg = String.valueOf(str).trim();
                    Integer.parseInt(arg);
                }
            }
        } catch (NumberFormatException e) {
            f = false;
        }
        return f;
    }

    /**
     * 比较大小 arg1<arg2
     * @param arg1
     * @param arg2
     * @return -1, 0, or 1 as this {@code BigDecimal} is numerically
     *          less than, equal to, or greater than {@code val}.
     */
    public static int compareTo(Object arg1,Object arg2){
        return new BigDecimal(String.valueOf(arg1)).compareTo(new BigDecimal(String.valueOf(arg2)));
    }

    /**
     * 校验手机号
     *
     * @param mobile
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isMobile(Object mobile) {
        return mobile!=null&&Pattern.matches("^(1[0-9])\\d{9}$", String.valueOf(mobile));
    }

    /**
     * 隐藏手机号码中间4位
     * @param mobile
     * @return
     */
    public static String mobile4Hide(String mobile){
        return mobile.substring(0,3) + "****" + mobile.substring(7);
    }


    /**
     * 校验邮箱
     *
     * @param email
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isEmail(String email) {
        return Pattern.matches("^([a-z0-9A-Z]+[-|\\.]?)+[a-z0-9A-Z]@([a-z0-9A-Z]+(-[a-z0-9A-Z]+)?\\.)+[a-zA-Z]{2,}$", email);
    }

    /**
     * 校验汉字
     *
     * @param chinese
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isChinese(String chinese) {
        return Pattern.matches("^[\u4e00-\u9fa5],{0,}$", chinese);
    }

    /**
     * 校验身份证
     *
     * @param idCard
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isIDCard(String idCard) {
        return Pattern.matches("(^\\d{18}$)|(^\\d{15}$)", idCard);
    }

    /**
     * 校验URL
     *
     * @param url
     * @return 校验通过返回true，否则返回false
     */
    public static boolean isUrl(String url) {
        return Pattern.matches("http(s)?://([\\w-]+\\.)+[\\w-]+(/[\\w -./?%&=]*)?", url);
    }

    /**
     * 校验IP地址
     *
     * @param ipAddr
     * @return
     */
    public static boolean isIPAddr(String ipAddr) {
        return Pattern.matches("(25[0-5]|2[0-4]\\d|[0-1]\\d{2}|[1-9]?\\d)", ipAddr);
    }

    /*public static void main(String[] args) {
        String username = "fdsdfsdj";
        //System.out.println(Validator.isUsername(username));
        //System.out.println(Validator.isChinese(username));
    }*/

}

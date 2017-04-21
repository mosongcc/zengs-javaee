package com.zingson.utils.encrypt;

import java.math.BigInteger;
import java.security.MessageDigest;


/**
 * Hash 摘要算法
 */
public class Hash {

    private static String encrypt(String content,String enType,int length,String charset){
        try {
            String hashtext = new BigInteger(1, MessageDigest.getInstance(enType).digest(content.getBytes(charset))).toString(16);
            while (hashtext.length() < length) {
                hashtext = "0" + hashtext;
            }
            return hashtext;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "HashError";
    }

    public static String md5(String content){
        return encrypt(content,"MD5",32,"UTF-8");
    }

    public static String sha1(String content){
        return encrypt(content,"SHA-1",40,"UTF-8");
    }

    public static String sha256(String content){
        return encrypt(content,"SHA-256",64,"UTF-8");
    }

    public static String sha512(String content){
        return encrypt(content,"SHA-512",128,"UTF-8");
    }

}

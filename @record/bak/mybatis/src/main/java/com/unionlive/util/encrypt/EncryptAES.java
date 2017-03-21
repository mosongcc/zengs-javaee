package com.unionlive.util.encrypt;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Base64;

/**
 * AES 加密解密
 */
public class EncryptAES {

    /** 密钥算法 */
    private static final String KEY_ALGORITHM = "AES";
    private static final int KEY_SIZE = 128;

    //默认密钥
    public static final String KEY = "VxDksHQiTvQt9MMPtMVXdA";

    /**
     * 解密
     * @param data 待解密数据
     * @param key 密钥
     * @return byte[] 解密数据
     * @throws Exception
     */
    private static String decrypt(byte[] data,byte[] key) throws Exception{
        //还原密钥
        Key k = new SecretKeySpec(key,KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        //初始化，设置解密模式
        cipher.init(Cipher.DECRYPT_MODE,k);
        //执行操作
        return new String(cipher.doFinal(data),"UTF-8");
    }

    /**
     * 解密
     * @param data 待解密数据
     * @param key 密钥
     * @return String 解密数据
     * @throws Exception
     */
    public static String decrypt(String data,String key) throws Exception{
        return decrypt(Base64.getDecoder().decode(data), Base64.getDecoder().decode(key));
    }

    /**
     * 解密
     * @param data  带解密数据
     * @return  String 解密数据
     * @throws Exception
     */
    public static String decrypt(String data){
        try {
            return decrypt(Base64.getDecoder().decode(data), Base64.getDecoder().decode(KEY));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 加密
     * @param data 待加密数据
     * @param key 密钥
     * @return bytes[] 加密数据
     * @throws Exception
     */
    public static byte[] encrypt(byte[] data,byte[] key) throws Exception{
        //还原密钥
        Key k = new SecretKeySpec(key,KEY_ALGORITHM);
        Cipher cipher = Cipher.getInstance(KEY_ALGORITHM);
        //初始化，设置为加密模式
        cipher.init(Cipher.ENCRYPT_MODE,k);
        //执行操作
        return cipher.doFinal(data);
    }

    /**
     * 加密
     * @param data
     * @param key
     * @return
     * @throws Exception
     */
    public static String encrypt(String data,String key) throws Exception{
        byte[] dataBytes = data.getBytes("UTF-8");
        byte[] keyBytes = Base64.getDecoder().decode(key);
        return Base64.getEncoder().encodeToString(encrypt(dataBytes, keyBytes));
    }

    /**
     * 加密
     * @param data
     * @return
     * @throws Exception
     */
    public static String encrypt(String data){
        try {
            return encrypt(data, KEY);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /*public static void main(String[] args){
        String wenjian = "{哈哈?&!JSON}";
        String mw = EncryptAES.encrypt(wenjian);
        System.out.println("密文:" + mw);

        String jm = EncryptAES.decrypt(mw);
        System.out.println("明文:" + jm);
    }*/
}

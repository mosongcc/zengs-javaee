package com.unionlive.util.encrypt;

import java.nio.charset.Charset;
import java.util.Base64;

/**
 * @author  pine
 * @date  2016-01-04
 * <p>
 * java简单加密，使用异或运算 <br>
 *
 * </p>
 */
public class EncryptXOR {

    //默认加密key
    private static final String key = "P9>_6+q)3K";
    private static final Charset charset = Charset.forName("UTF-8");

    /**
     * 加密
     * @param enc  待加密字符串
     * @param key  加密签名key
     * @return
     */
    public static String encode(String enc,String key){
        byte[] b = enc.getBytes(charset);
        for(int i=0,size=b.length;i<size;i++){
            for(byte kb:key.getBytes(charset)){
                b[i] = (byte) (b[i]^kb);
            }
        }
        return Base64.getEncoder().encodeToString(b);
    }
    public static String encode(String enc){
        return encode(enc,key);
    }

    /**
     * 解密
     * @param dec 待解密字符串
     * @param key 必须与加密key相同
     * @return
     */
    public static String decode(String dec,String key) {
        byte[] e = Base64.getDecoder().decode(dec.getBytes(charset));
        byte[] dee = e;
        for(int i=0,size=e.length;i<size;i++){
            for(byte kb:key.getBytes(charset)){
                e[i] = (byte) (dee[i]^kb);
            }
        }
        return new String(e,charset);
    }
    public static String decode(String enc){
        return decode(enc,key);
    }


    /*public static void main(String[] args) throws UnsupportedEncodingException {
        String enc = encode("用户密码","接口签名key"); //避免签名字符串太多，和接口使用相同加密key
        //String dec = decode("gMEUFQGAVYDBVdQAlRRBAIXSA==");
        System.out.println(enc);
        //System.out.println(dec);
    }*/


}

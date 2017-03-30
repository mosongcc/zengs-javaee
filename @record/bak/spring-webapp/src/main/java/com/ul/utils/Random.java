package com.ul.utils;

/**
 * 随机工具类
 */
public class Random {

    private static final String N = "1234567890";
    private static final String L = "abcdefghijklmnopqrstuvwxyz";
    private static final String U = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String S = "~!@#$%^&*()_+-=[]{}|;:',.<>?";


    /**
     * 获取随机字符串
     * @param len  长度
     * @param args 类型 N L U S
     * @return
     */
    public static String string(int len,String...args){
        String base = null;
        for (String t : args) {
            if("N".equals(t)){base += N;}
            if("L".equals(t)){base += L;}
            if("U".equals(t)){base += U;}
            if("S".equals(t)){base += S;}
        }
        if(base==null){ base = N;}
        java.util.Random random = new java.util.Random();
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < len; i++) {
            sb.append(base.charAt(random.nextInt(base.length())));
        }
        return sb.toString();
    }


    /*public static void main(String[] args) {
        System.out.println(string(16,"N","L","U","S"));
    }*/

}

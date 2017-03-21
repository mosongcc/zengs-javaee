package com.unionlive.util.encrypt;

import com.unionlive.util.CharUtil;

/**
 * @author song
 *
 * Unicode
 */
public class Unicode {


    /**
     * 把中文转成Unicode码
     * @param str
     * @return
     */
    public static String chinaToUnicode(String str){
        String result="";
        for (int i = 0; i < str.length(); i++){
            char chr = str.charAt(i);
            //int chr1 = (char) str.charAt(i);
            //if(chr1>=19968&&chr1<=171941){//汉字范围 \u4e00-\u9fa5 (中文)
            //if(chr1>=12289&&chr1<=173782){
            if(CharUtil.isChinese(chr)){
                result+="\\u" + Integer.toHexString(chr);
            }else{
                result+=str.charAt(i);
            }
        }
        return result;
    }

    public static String unicodeToChina(String ucode) {
        StringBuffer string = new StringBuffer();
        for (int i = 0;i<ucode.length();i++){
            if("\\".equals(ucode.substring(i,i+1))&&"\\u".equals(ucode.substring(i,i+2))){
                int data = Integer.parseInt(ucode.substring(i+2,i+6),16);
                string.append((char)data);
                i += 6-1;
            }else{
                string.append(ucode.substring(i,i+1));
            }
        }
        /* 存在其他字符时有错误
        String[] u = ucode.split("\\\\u");
        for (int i = 0;i<u.length;i++){
            if(u[i].length()==4){
                string.append((char)Integer.parseInt(u[i],16));
            }else {
                string.append(u[i]);
            }
        }*/
        return string.toString();
    }

    /*public static void main(String[] args) throws UnsupportedEncodingException {
        String s = chinaToUnicode("");
        System.out.println(s);

        String t = "{\"body\":{\"source\":\"65267\",\"shop\":{\"id\":\"182000899000001\",\"name\":\"\\u5b9c\\u829d\\u591a\\u5916\\u5356\\uff08\\u5ef6\\u957f\\u8def\\u5e97Test\\uff09\",\"baidu_shop_id\":\"1701127920\"},\"order\":{\"order_id\":\"14702818738514\",\"send_immediately\":1,\"send_time\":\"1\",\"send_fee\":600,\"package_fee\":0,\"discount_fee\":0,\"total_fee\":3600,\"shop_fee\":3600,\"user_fee\":3600,\"pay_type\":1,\"pay_status\":1,\"need_invoice\":1,\"invoice_title\":\"\\u4e2a\\u4eba\",\"remark\":\"\\u8bf7\\u63d0\\u4f9b\\u9910\\u5177,\\u8fa3\\u4e00\\u70b9,\\u6ca1\\u96f6\\u94b1,\\u7c73\\u996d\\u591a\\u70b9\",\"delivery_party\":2,\"create_time\":\"1470281873\"},\"user\":{\"name\":\"\\u66feS\",\"phone\":\"13611703040\",\"gender\":1,\"address\":\"\\u542f\\u5149\\u827e\\u52a0\\u5927\\u53a6 \\u5ef6\\u957f\\u4e2d\\u8def581\\u53f73\\u697c\",\"coord\":{\"longitude\":121.455939,\"latitude\":31.275355}},\"products\":[{\"product_id\":\"10786859\",\"upc\":\"\",\"product_name\":\"\\u9ebb\\u8fa3\\u9999\\u9505\",\"product_price\":3000,\"product_amount\":1,\"product_fee\":3000,\"package_price\":0,\"package_amount\":\"1\",\"package_fee\":0,\"total_fee\":3000}],\"discount\":[]},\"cmd\":\"order.create\",\"sign\":\"CC30325F9CB5281CF22BC3C061EC9E51\",\"source\":\"65267\",\"ticket\":\"8A91BF38-1B54-10F9-AD19-2B14428B4328\",\"timestamp\":1470281916,\"version\":\"2.0\"}";

        System.out.println(unicodeToChina("\u5b9c\u829d\u591a\u5916\u5356\uff08\u5ef6\u957f\u8def\u5e97\uff09"));

    }*/

}

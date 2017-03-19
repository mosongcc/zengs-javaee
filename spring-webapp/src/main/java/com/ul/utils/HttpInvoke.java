package com.ul.utils;

import com.unionlive.util.exception.HttpRequestException;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.UnknownHostException;
import java.util.Map;

/**
 * HttpCliet 工具类
 */
public class HttpInvoke {

    public final static String CHARSET = "UTF-8";     //默认编码
    public final static int CONNECT_TIMEOUT = 5*1000; //默认请求超时时间
    public final static String POST = "POST";
    public final static String GET = "GET";

    public static String get(String url) throws HttpRequestException, UnknownHostException {
        return send(url,GET,null,CHARSET,null);
    }

    public static String post(String url,String params) throws HttpRequestException, UnknownHostException {
        return post(url,params,CHARSET);
    }

    public static String post(String url,String params,String charset) throws HttpRequestException, UnknownHostException {
        return send(url,POST,params,charset,null);
    }

    public static String send(String url,String method,String params,String charset,Map<String,String> requestHeader) throws UnknownHostException,HttpRequestException {
        int rescode = 404;
        String resmsg = "";
        String res = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setConnectTimeout(CONNECT_TIMEOUT);       //设置请求超时时间
            if(requestHeader!=null){
                for (String k:requestHeader.keySet()){
                    if(!"".equals(k)&&k!=null){ conn.setRequestProperty(k, requestHeader.get(k)); }
                }
            }
            if(!GET.equals(method)&&params!=null){
                conn.setRequestMethod(method);             //设置请求为post，默认为get
                conn.setDoOutput(true);                    //设置是否向httpUrlConnection输出，post请求设置为true,默认为false
                conn.setDoInput(true);                     //设置输入流
                conn.setUseCaches(false);                  //不能使用缓存
                OutputStream outputStream = conn.getOutputStream();
                outputStream.write(params.getBytes(charset));
                outputStream.flush();
                outputStream.close();
            }
            rescode = conn.getResponseCode();
            resmsg = conn.getResponseMessage();
            res = IOUtils.toString(conn.getInputStream(),CHARSET);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e){
            e.printStackTrace();
        }
        if(rescode!=200){
            throw new HttpRequestException(res," Http request error code:"+rescode+" Url:"+url+" message: "+resmsg);
        }
        return res;
    }

    /*public static void main(String[] args) {
        //System.out.println(get("http://r.qzone.qq.com/cgi-bin/user/cgi_personal_card?uin=916931772"));
        //System.out.println(post("http://api.waimai.baidu.com/","","utf-8"));
    }*/


}

package com.zingson.net.http;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * @author zingson
 * @date 2017/3/30
 * @description
 *   Http 客户端组件
 */
public class ZHttp {

    /**
     * 建立连接超时时间，默认10秒
     */
    private int connectTimeout = 10000;


    public HttpResponse get(){

        return null;
    }


    public HttpResponse post(){

        return null;
    }

   /* public HttpResponse request(String url){
        int rescode = 404;
        String resmsg = "";
        String res = null;
        try {
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setConnectTimeout(connectTimeout);
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
    }*/

}

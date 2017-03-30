package com.zingson.net.http;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 *
 */
public class ZHttpClient {

    public ZHttpClient getInstance(){
        return new ZHttpClient();
    }

    /**
     * 默认编码
     */
    private String charset = "UTF-8";

    /**
     * 建立连接超时时间，默认10秒
     */
    private int connectTimeout = 10000;

    private boolean isClient = false;

    private Map<String,String> headers = new LinkedHashMap<>();

    private List<Cookie> cookies = new ArrayList<>();

    public void setCookie(String name,String value){
        Cookie cookie = new Cookie();
        cookie.setName(name);
        cookie.setValule(value);
        cookies.add(cookie);
    }

    /**
     * 请求头
     * key:   请求URL域名
     * value: 请求头Map
     */
    private ConcurrentMap<String,Map<String,String>> requestHeader = new ConcurrentHashMap<>();

    public HttpResponse execute(){


        return null;
    }

    public HttpResponse get(String url) throws IOException {
        HttpResponse response = new HttpResponse();
        HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
        conn.setConnectTimeout(connectTimeout);
        if(headers!=null){
            for (Map.Entry<String,String> entry:headers.entrySet()){
                conn.setRequestProperty(entry.getKey(), entry.getValue());
            }
        }
        Map<String,String> cookieMap = new HashMap<>();
        for (Cookie cookie:cookies) {
            //判断过期时间
            cookieMap.put(cookie.getName(),cookie.getValule());
        }
        response.setRequestMethod(conn.getRequestMethod());
        response.setResponseCode(conn.getResponseCode());
        response.setResponseMsg(response.getResponseMsg());
        response.setHeaderFilds(conn.getHeaderFields());
        response.setContentLength(conn.getContentLength());
        response.setContentType(conn.getContentType());
        response.setContentEncoding(conn.getContentEncoding());
        response.setInputStream(conn.getInputStream());

        //维持Cookie会话信息
        if(isClient){
            if(cookies==null){
                cookies = new ArrayList<>();
            }
            cookies.addAll(response.getCookies());
        }

        return response;
    }



    /**
     * 请求头实体类
     */
    private class RequestHeader{

    }

    /**
     * 响应头实体类
     */
    private class ResponseHeader{

    }


    /**
     * 截取URL中的域名
     * @param url
     * @return
     */
    private String cutRealmNameStr(String url){
        int i = url.indexOf("//");
        url = url.substring(i==-1?0:(i+2));
        i = url.indexOf("/");
        return i==-1?url:url.substring(i);
    }

    public static void main(String[] args) {
        ZHttpClient client = new ZHttpClient();
        System.out.println(client.cutRealmNameStr("http://baidu.com"));
    }

}

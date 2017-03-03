package com.zengs.init;

import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.*;

/**
 *
 */
public class Main {

    /**
     * 配置
     */
    private static final String clientid = "53999199";//53999199
    private static final String ptwebqq = "292ed13fbeb133044ec670f93c08f9a5b48d59eccd2d33c1b65742489968ff85";
    private static final String psessionid = "8368046764001d636f6e6e7365727665725f77656271714031302e3133332e34312e383400001ad00000066b026e040015808a206d0000000a406172314338344a69526d0000002859185d94e66218548d1ecb1a12513c86126b3afb97a3c2955b1070324790733ddb059ab166de6857";
    private static final String cookie = "RK=LOUGefsPfB; pt2gguin=o0710679977; uin=o0710679977; skey=@MHEIU44rf; p_uin=o0710679977; p_skey=f-bBbVvdF6WYm7X*YF1LTfjOTGlowGwkrS1ohU4BJgU_; pt4_token=64Bz4KHAQUjEIFrMoI5OhkV1HuHOGYklAG88IYw700E_; pgv_info=ssid=s5238660631; pgv_pvid=1204319304; o_cookie=710679977; ptwebqq=292ed13fbeb133044ec670f93c08f9a5b48d59eccd2d33c1b65742489968ff85";

    private static HttpClient httpClient;

    public static void main(String[] args) {
        System.out.println("start webqq -------------------------------------");
        CookieStore cookieStore = new BasicCookieStore();
        httpClient = HttpClients.custom().setDefaultCookieStore(cookieStore).build();

        while (true){
            try {
                //sendBuddyMsg("api msg 消息232","192531315");
                poll2();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }


    /**
     * 生成消息ID
     * @return
     */
    private static int sequence = 0;
    public static String getMsgId(){
        /**
         * 以下生成消息ID逻辑来自于 http://pub.idqqimg.com/smartqq/js/mq.js?t=20161220  第8034行
         //用于生成msgid
         var sequence = 0;
         var t = (new Date()).getTime();
         t = (t - t % 1000) / 1000;
         t = t % 10000 * 10000;
         //获取msgId
         var getMsgId = function(){
         sequence++;
         return t + sequence;
         };
         */
        long t = new Date().getTime();
        t = (t - t % 1000) / 1000;
        t = t % 10000 * 10000;
        long msgId = t + sequence++;
        return msgId+"";
    }


    /**
     * 接收消息
     * @return
     * @throws IOException
     */
    public static String poll2() throws IOException {
        String url = "https://d1.web2.qq.com/channel/poll2"; //POST
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("r","{\"ptwebqq\":\""+ptwebqq+"\",\"clientid\":"+clientid+",\"psessionid\":\""+psessionid+"\",\"key\":\"\"}"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
        post.setEntity(entity);
        post.setHeader(":path","/channel/poll2");
        String result = http(post);
        System.out.println("接收消息 Result："+result);

        //解析收到的消息
        Map<String,Object> resMap = JsonUtil.json2objectmap(result);
        if("0".equals(String.valueOf(resMap.get("retcode")))){
            List<Map<String,Object>> msgList = (List<Map<String, Object>>) resMap.get("result");
            msgList.forEach((map)->{
                Map<String,Object> valueMap = (Map<String, Object>) map.get("value");
                String formUin = String.valueOf(valueMap.get("from_uin"));
                String msgType = String.valueOf(valueMap.get("msg_type"));
                if("0".equals(msgType)){
                    List<Object> contentList = (List<Object>) valueMap.get("content");
                    //消息内容
                    String msgContent = "";
                    for (Object o:contentList){
                        if(o instanceof String){
                            msgContent += String.valueOf(o);
                        }
                    }
                    System.out.println("收到消息："+msgContent);

                    try {
                        sendBuddyMsg("回复："+msgContent,formUin);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
        return "";
    }

    /**
     * 发送消息
     * @return
     */
    public static String sendBuddyMsg(String content,String to) throws IOException {
        String url = "https://d1.web2.qq.com/channel/send_buddy_msg2";
        HttpPost post = new HttpPost(url);
        List<NameValuePair> list = new ArrayList<>();
        list.add(new BasicNameValuePair("r","{\"to\":"+to+",\"content\":\"[\\\""+content+"\\\",[\\\"font\\\",{\\\"name\\\":\\\"宋体\\\",\\\"size\\\":10,\\\"style\\\":[0,0,0],\\\"color\\\":\\\"000000\\\"}]]\",\"face\":0,\"clientid\":"+clientid+",\"msg_id\":"+getMsgId()+",\"psessionid\":\""+psessionid+"\"}"));
        UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
        post.setEntity(entity);
        post.setHeader(":path","/channel/send_buddy_msg2");
        String result = http(post);
        System.out.println("发送消息 100100 Result："+result);
        return "";
    }


    public static String http(HttpUriRequest request) throws IOException {
        request.setHeader("cookie",cookie);
        request.setHeader(":authority","d1.web2.qq.com");
        request.setHeader(":method",request.getMethod());
        //request.setHeader(":path","/channel/send_buddy_msg2");
        request.setHeader(":scheme","https");
        request.setHeader("accept","*/*");
        request.setHeader("cache-control","no-cache");
        request.setHeader("content-type","application/x-www-form-urlencoded");
        request.setHeader("origin","https://d1.web2.qq.com");
        request.setHeader("pragma","no-cache");
        request.setHeader("referer","https://d1.web2.qq.com/cfproxy.html?v=20151105001&callback=1");
        request.setHeader("user-agent","ozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/52.0.2743.82 Safari/537.36 OPR/39.0.2256.48");

        System.out.println();
        for (Header header : request.getAllHeaders()) {
            System.out.println(header.getName()+":"+header.getValue());
        }

        HttpResponse httpResponse = httpClient.execute(request);
        HttpEntity resEntity = httpResponse.getEntity();
        System.out.println("HTTP ------");
        System.out.println("URL:"+request.getURI());
        System.out.println("status:"+httpResponse.getStatusLine().getStatusCode());
        Header[] headers = httpResponse.getHeaders("set-cookie");
        for (Header header : headers) {
            System.out.println("Cookie:"+header.getName()+"="+header.getValue());
        }
        return EntityUtils.toString(resEntity);
    }

}

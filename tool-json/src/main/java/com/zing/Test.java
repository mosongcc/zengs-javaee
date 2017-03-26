package com.zing;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.zing.entity.PushEntity;

import java.io.IOException;

/**
 *
 */
public class Test {


    static ObjectMapper objectMapper = new ObjectMapper();

    public static void main(String[] args) {

        //// JSON字符串
        //String content = "{\"header\":{\"version\":\"1.0\",\"transType\":\"T102\",\"submitTime\":\"20170326195057\",\"sessionId\":\"1b01f230-402e-4082-8970-0ba6f5614dca\",\"clientTraceNo\":\"20170326195057433\",\"hostTime\":\"20170326195109\",\"hostTraceNo\":\"885636\",\"returnCode\":\"0000\",\"returnMessage\":\"交易成功\"},\"body\":{\"total\":{\"orderCount\":0,\"orderAmount\":0},\"channel\":[{\"orderCount\":0,\"orderAmount\":0,\"channelId\":\"189021000009002\"},{\"orderCount\":0,\"orderAmount\":0,\"channelId\":\"189021000009003\"},{\"orderCount\":0,\"orderAmount\":0,\"channelId\":\"189021000009004\"}]}}";
        String content = "{\"returnCode\":\"-9999\",\"return_msg\":\"no\",\"submitTime\":\"20170326213027\",\"shopId\":\"189021000009006\",\"msgType\":\"\",\"loginSessionId\":\"no\"}";
        try {
            JsonGeneratePojo pojo = new JsonGeneratePojo("tool-json/src/main/java");
            pojo.setJsonAnnotation(false);
            pojo.start("com.zing.entity.PushEntity",content);



            //System.out.println( objectMapper.writeValueAsString(new PushEntity()));
            //PushEntity entity = objectMapper.readValue(content,PushEntity.class);
            //System.out.println(entity.getReturnMsg());
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}

package com.zingson.net.http;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 */
public class HttpResponse {

    private String requestMethod;

    private int responseCode;
    private String responseMsg;

    private InputStream inputStream;
    private Map<String,List<String>> headerFilds;

    private int contentLength;
    private String contentType;
    private String contentEncoding;

    private List<Cookie> cookies;

    public HttpResponse() {
    }

    public String getRequestMethod() {
        return requestMethod;
    }

    public void setRequestMethod(String requestMethod) {
        this.requestMethod = requestMethod;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(int responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public InputStream getInputStream() {
        return inputStream;
    }

    public void setInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    public Map<String, List<String>> getHeaderFilds() {
        return headerFilds;
    }

    public void setHeaderFilds(Map<String, List<String>> headerFilds) {
        this.headerFilds = headerFilds;
    }

    public int getContentLength() {
        return contentLength;
    }

    public void setContentLength(int contentLength) {
        this.contentLength = contentLength;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public String getContentEncoding() {
        return contentEncoding;
    }

    public void setContentEncoding(String contentEncoding) {
        this.contentEncoding = contentEncoding;
    }

    public List<Cookie> getCookies() {
        return getResponseCookie(this.getHeaderFilds());
    }

    public void setCookies(List<Cookie> cookies) {
        this.cookies = cookies;
    }

    /**
     * 获取响应Cookie
     * @param headerFilds
     * @return
     */
    private List<Cookie> getResponseCookie(Map<String, List<String>> headerFilds){
        List<Cookie> cookies = new ArrayList<>();
        List<String> resCookie = headerFilds.get("Set-Cookie");
        for(String str:resCookie){
            Cookie cookie = new Cookie();
            String[] arr = str.split(";");
            String[] v = arr[0].split("=");
            cookie.setName(v[0]);
            cookie.setValule(v[1]);
            for (String item:arr){
                v = item.split("=");
                if("Domain".equals(v[0])){
                    cookie.setDomain(v[1]);
                }
                if("Path".equals(v[0])){
                    cookie.setDomain(v[1]);
                }
                if("Expires".equals(v[0])){
                    cookie.setDomain(v[1]);
                }
            }
            cookies.add(cookie);
        }
        return cookies;
    }
}

package com.ul.utils.exception;

/**
 * Http请求异常
 */
public class HttpRequestException extends Exception{

    public String error;  //状态不等于200时记录网页输出的内容

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public HttpRequestException(String message) {
        super(message);
    }

    public HttpRequestException(String error,String message) {
        super(message);
        setError(error);
    }

    public HttpRequestException() {
        super();
    }
}

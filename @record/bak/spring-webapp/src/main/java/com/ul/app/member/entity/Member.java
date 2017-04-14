package com.ul.app.member.entity;

import java.io.Serializable;

public class Member implements Serializable {

    private String id;
    private String name;
    private String userName;
    private String age;
    private String remarkMsg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getRemarkMsg() {
        return remarkMsg;
    }

    public void setRemarkMsg(String remarkMsg) {
        this.remarkMsg = remarkMsg;
    }
}

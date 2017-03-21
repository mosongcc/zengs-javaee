package com.unionlive.app.entity;

import java.io.Serializable;
import java.math.BigDecimal;

public class ZeMember implements Serializable {
    private BigDecimal id;

    private String name;

    private String userName;

    private String remarkMsg;

    private BigDecimal age;

    private static final long serialVersionUID = 1L;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getRemarkMsg() {
        return remarkMsg;
    }

    public void setRemarkMsg(String remarkMsg) {
        this.remarkMsg = remarkMsg == null ? null : remarkMsg.trim();
    }

    public BigDecimal getAge() {
        return age;
    }

    public void setAge(BigDecimal age) {
        this.age = age;
    }
}
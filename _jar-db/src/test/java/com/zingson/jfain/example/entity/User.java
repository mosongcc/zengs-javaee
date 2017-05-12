package com.zingson.jfain.example.entity;

import com.zingson.jfain.jdbc.annotation.JFMap;

@JFMap("table_user")
public class User {

    private Integer id;
    private String userName;
    private String password;

    @JFMap("id")
    public Integer getId() {
        return id;
    }
    @JFMap("user_name")
    public String getUserName() {
        return userName;
    }
    @JFMap("password")
    public String getPassword() {
        return password;
    }

    public User(){}

    public User(Integer id, String userName, String password) {
        this.id = id;
        this.userName = userName;
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return String.format("id=%s; userName=%s; password=%s",id,userName,password);
    }
}

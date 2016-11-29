package com.zengs.domain;

import java.io.Serializable;

/**
 * @date 2016-10-23 
 * @author zengs
 * @tableName user
 * @descript 
 *    According to the table to generate entity class
 */
public class User implements Serializable {

    private Integer userId;
    private String username;
    private String age;

    public void setUserid(Integer userId){
        this.userId=userId;
    }
    public Integer getUserid(){
        return userId;
    }
    public void setUsername(String username){
        this.username=username;
    }
    public String getUsername(){
        return username;
    }
    public void setAge(String age){
        this.age=age;
    }
    public String getAge(){
        return age;
    }

}



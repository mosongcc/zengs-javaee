package com.zengs.entity;

import java.io.Serializable;

/**
 * @date 2016-10-23 
 * @author zengs
 * @tableName z_test
 * @descript 
 *    According to the table to generate entity class
 */
public class ZTest implements Serializable {

    private Integer id;
    private String name;
    private String key;
    private String value;

    public void setId(Integer id){
        this.id=id;
    }
    public Integer getId(){
        return id;
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return name;
    }
    public void setKey(String key){
        this.key=key;
    }
    public String getKey(){
        return key;
    }
    public void setValue(String value){
        this.value=value;
    }
    public String getValue(){
        return value;
    }

}



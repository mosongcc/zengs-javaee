package com.zengs.entity;

import java.io.Serializable;
import java.sql.Timestamp;

/**
 * @date 2016-10-23 
 * @author zengs
 * @tableName pine_merchant_info
 * @descript 
 *    According to the table to generate entity class
 */
public class MerchantInfo implements Serializable {

    private Integer mercId;
    private String mercName;
    private String status;
    private Timestamp createDate;

    public void setMercid(Integer mercId){
        this.mercId=mercId;
    }
    public Integer getMercid(){
        return mercId;
    }
    public void setMercname(String mercName){
        this.mercName=mercName;
    }
    public String getMercname(){
        return mercName;
    }
    public void setStatus(String status){
        this.status=status;
    }
    public String getStatus(){
        return status;
    }
    public void setCreatedate(Timestamp createDate){
        this.createDate=createDate;
    }
    public Timestamp getCreatedate(){
        return createDate;
    }

}



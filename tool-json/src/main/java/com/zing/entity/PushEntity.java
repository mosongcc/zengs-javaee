package com.zing.entity;



public class PushEntity { 

	private String returnCode; 
	private String returnMsg; 
	private String submitTime; 
	private String shopId; 
	private String msgType; 
	private String loginSessionId; 

	public String getReturnCode(){
		return returnCode; 
	}
	public void setReturnCode(String returnCode){
		this.returnCode = returnCode; 
	}
	public String getReturnMsg(){
		return returnMsg; 
	}
	public void setReturnMsg(String returnMsg){
		this.returnMsg = returnMsg; 
	}
	public String getSubmitTime(){
		return submitTime; 
	}
	public void setSubmitTime(String submitTime){
		this.submitTime = submitTime; 
	}
	public String getShopId(){
		return shopId; 
	}
	public void setShopId(String shopId){
		this.shopId = shopId; 
	}
	public String getMsgType(){
		return msgType; 
	}
	public void setMsgType(String msgType){
		this.msgType = msgType; 
	}
	public String getLoginSessionId(){
		return loginSessionId; 
	}
	public void setLoginSessionId(String loginSessionId){
		this.loginSessionId = loginSessionId; 
	}
}

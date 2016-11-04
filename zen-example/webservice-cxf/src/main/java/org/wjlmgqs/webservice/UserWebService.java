package org.wjlmgqs.webservice;

import javax.xml.ws.Endpoint;

import org.wjlmgqs.service.UserService;
import org.wjlmgqs.service.imp.UserServiceImp;
import org.wjlmgqs.util.WebLogger;

public class UserWebService {

	public static void main(String[] args) {
		WebLogger.showInfo("��ʼ����WebService");
		UserService userService= new UserServiceImp();
	    String address="http://localhost:8080/user";
	    Endpoint.publish(address,userService);
	    try {
			Thread.sleep(1000*60*5);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    WebLogger.showInfo("WebService��������");
	}
	
}

package org.wjlmgqs.webservice;

import java.util.List;

import org.apache.cxf.jaxws.JaxWsProxyFactoryBean;
import org.wjlmgqs.entity.User;
import org.wjlmgqs.service.UserService;

public class UserWebServiceClient {
	
	public static void main(String[] args) {
		JaxWsProxyFactoryBean factory = new JaxWsProxyFactoryBean();  
        factory.setServiceClass(UserService.class);
        factory.setAddress("http://localhost:8080/WebServiceExp/webservice/user?wsdl");
		UserService userService = (UserService) factory.create();
        List<User> findUser = userService.findUser("wang");
        for(User u : findUser){
        	System.out.println(u.toString());
        }
	}
}

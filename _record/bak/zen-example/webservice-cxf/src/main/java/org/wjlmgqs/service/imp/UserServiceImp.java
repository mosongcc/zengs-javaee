package org.wjlmgqs.service.imp;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebService;

import org.wjlmgqs.dao.imp.UserDaoImp;
import org.wjlmgqs.entity.User;
import org.wjlmgqs.service.UserService;

@WebService(endpointInterface="org.wjlmgqs.service.UserService",serviceName="user")  
public class UserServiceImp implements UserService{

	@Override
	public List<String> listUserName() {
		List<String> list = new ArrayList<>();
		list.add("111");
		list.add("222");
		return list;
	}

	@Override
	public List<User> findUser(String email) {
		List<User> list = new ArrayList<>();
		User u = new User();
		u.setName("zhangsan");
		u.setStatus("1");
		list.add(u);
		return list;
	}

}

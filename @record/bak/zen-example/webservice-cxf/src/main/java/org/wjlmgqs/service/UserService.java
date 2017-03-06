package org.wjlmgqs.service;

import java.util.List;

import javax.jws.WebParam;
import javax.jws.WebService;

import org.wjlmgqs.entity.User;
@WebService
public interface UserService {

	/**
	 * �г��û���
	 * @return
	 */
	public List<String> listUserName();
	
	/**
	 * �����������û���Ϣ
	 * @param name
	 * @param email
	 * @return
	 */
	public List<User> findUser(@WebParam(name = "email") String email);
}

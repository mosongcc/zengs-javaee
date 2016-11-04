package org.wjlmgqs.dao;

import java.util.List;

import org.wjlmgqs.entity.User;

public interface UserDao {

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
	public List<User> findUser(String email);
}

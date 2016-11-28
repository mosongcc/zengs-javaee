package org.wjlmgqs.dao;

import java.util.List;

import org.wjlmgqs.entity.User;

public interface UserDao {

	/**
	 * 列出用户名
	 * @return
	 */
	public List<String> listUserName();
	
	/**
	 * 根据邮箱查出用户信息
	 * @param name
	 * @param email
	 * @return
	 */
	public List<User> findUser(String email);
}

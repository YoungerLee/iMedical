package com.young.iMedical.service;

import com.young.iMedical.domain.User;

public interface UserService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.UserServiceImpl";

	/**
	 * 添加用户
	 * 
	 * @param user
	 */
	public void saveUser(User user);

	/**
	 * 根据id查找用户
	 * 
	 * @param id
	 * @return 查询结果
	 */
	public User findUserById(Integer id);

	/**
	 * 根据用户名查找用户
	 * 
	 * @param username
	 * @return 查询结果
	 */
	public User findUserByName(String username);
}

package com.young.iMedical.service;

import com.young.iMedical.domain.User;

public interface UserService {
	public final static String SERVICE_NAME = "com.young.iMedical.service.impl.UserServiceImpl";

	public void saveUser(User user);
}

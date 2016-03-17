package com.young.iMedical.dao;

import com.young.iMedical.domain.User;

public interface UserDao extends CommonDao<User> {
	public final static String SERVICE_NAME = "com.young.iMedical.dao.impl.UserDaoImpl";

}

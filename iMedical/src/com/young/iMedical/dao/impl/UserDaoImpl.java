package com.young.iMedical.dao.impl;

import org.springframework.stereotype.Repository;

import com.young.iMedical.dao.UserDao;
import com.young.iMedical.domain.User;

@Repository(UserDao.SERVICE_NAME)
public class UserDaoImpl extends CommonDaoImpl<User> implements UserDao {

}

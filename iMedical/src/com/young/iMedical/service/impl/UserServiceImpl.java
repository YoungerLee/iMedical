package com.young.iMedical.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.young.iMedical.dao.UserDao;
import com.young.iMedical.domain.User;
import com.young.iMedical.service.UserService;

@Transactional(readOnly = true)
@Service(UserService.SERVICE_NAME)
public class UserServiceImpl implements UserService {
	@Resource(name = UserDao.SERVICE_NAME)
	private UserDao userDao;

	@Override
	@Transactional(isolation = Isolation.DEFAULT, propagation = Propagation.REQUIRED, readOnly = false)
	public void saveUser(User user) {
		userDao.save(user);
	}
}

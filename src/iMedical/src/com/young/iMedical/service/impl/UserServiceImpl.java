package com.young.iMedical.service.impl;

import java.util.List;

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

	@Override
	public User findUserByName(String username) {
		String hqlWhere = " and o.username = ?";
		Object[] params = { username };
		List<User> list = userDao.findCollectionByConditionNoPage(hqlWhere,
				params, null);
		User user = null;
		if (list != null && list.size() > 0) {
			user = list.get(0);
		}
		return user;
	}

	@Override
	public User findUserById(String id) {
		return (User) userDao.findObjectByID(id);
	}
}

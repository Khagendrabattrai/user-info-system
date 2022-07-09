package com.techbook.service;

import java.util.List;

import com.techbook.dao.UserDao;
import com.techbook.dao.UserDaoImpl;
import com.techbook.domain.User;

public class UserServiceImpl implements UserService {
	private UserDao userDao; // we send ?? from service to userDao //c confusion on here

	public UserServiceImpl() {// constructor
		userDao = new UserDaoImpl();// object
	}

	@Override
	public int saveUserInfo(User user) {
		return userDao.saveUserInfo(user);// calling

	}

	@Override
	public int updateUserInfo(User user) {
		return userDao.updateUserInfo(user);
	}

	@Override
	public int deleteUserInfo(int id) {
		return userDao. deleteUserInfo(id);
	}

	@Override
	public List<User> getAllUserInfo() {
		return userDao. getAllUserInfo();
	}

}

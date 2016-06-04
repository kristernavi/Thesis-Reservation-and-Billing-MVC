package com.thesis.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thesis.dao.UserDao;
import com.thesis.model.User;
import com.thesis.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserDao userDao;

	@Override
	@Transactional(readOnly=true)
	public User findUserByName(String username) {

		return userDao.findUserByName(username);
	}

}

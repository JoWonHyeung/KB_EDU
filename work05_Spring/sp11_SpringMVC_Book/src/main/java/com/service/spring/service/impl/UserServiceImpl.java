package com.service.spring.service.impl;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.service.spring.dao.UserDAO;
import com.service.spring.domain.User;
import com.service.spring.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User login(User user) throws SQLException {
		
		return userDAO.login(user);
	}

	@Override
	public void addUser(User user) throws Exception {
		userDAO.addUser(user);		
	}
}

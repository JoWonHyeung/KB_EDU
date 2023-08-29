package com.service.spring.service;

import java.sql.SQLException;

import com.service.spring.domain.User;

public interface UserService {
	User login(User user) throws SQLException;
	void addUser(User user) throws Exception;
}

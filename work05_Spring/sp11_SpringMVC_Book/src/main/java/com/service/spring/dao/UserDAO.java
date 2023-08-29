package com.service.spring.dao;

import java.sql.SQLException;

import com.service.spring.domain.User;

public interface UserDAO {

	User login(User user) throws SQLException;
	void addUser(User user) throws Exception;

}
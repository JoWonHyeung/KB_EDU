package com.service.spring.dao.impl;

import java.sql.SQLException;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.dao.UserDAO;
import com.service.spring.domain.User;


@Repository
public class UserDAOImpl implements UserDAO {
	
	public static final String NS = "ns.sql.UserMapper.";
	
	@Autowired
	private SqlSession sqlSession;
	

	@Override
	public User login(User user) throws SQLException{
	   return sqlSession.selectOne(NS+"login", user);
		
	}

	@Override
	public void addUser(User user) throws Exception {
		sqlSession.insert(NS+"addUser", user);
	}
	
}








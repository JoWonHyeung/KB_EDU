package com.service.spring.model.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.Phone;
import com.service.spring.domain.UserInfo;
import com.service.spring.model.PhoneDAO;


@Repository
public class PhoneDAOImpl implements PhoneDAO{
	
	public static final String NS = "sql.pms.mapper.";
	
	@Autowired
	private SqlSession  sqlSession;
	
	
	@Override
	public int insert(Phone phone) {		
		return sqlSession.insert(NS+"insert",phone);		
	}

	@Override
	public int delete(List<String> list) {
		return sqlSession.delete(NS+"delete",list);	
	}

	@Override
	public Phone select(Phone phone) {		
		return sqlSession.selectOne(NS+"select",phone);
	}

	@Override
	public List<Phone> select() {		
		return sqlSession.selectList(NS+"select", null);
	}

	@Override
	public UserInfo select(UserInfo user) {		
		return sqlSession.selectOne(NS+"selectUser",user);
	}

	@Override
	public int update(Phone phone) {
		return sqlSession.update(NS+"update",phone);
	}
}

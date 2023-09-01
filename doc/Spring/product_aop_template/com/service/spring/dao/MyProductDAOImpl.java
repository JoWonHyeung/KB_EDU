package com.service.spring.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.service.spring.domain.MyProduct;

@Repository
public class MyProductDAOImpl implements MyProductDAO{
	
	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "ns.sql.MyProductMapper.";
	
	@Override
	public int addProduct(MyProduct vo) throws Exception {
		int result = sqlSession.insert(NS+"addProduct", vo);
		return result;
	}

	@Override
	public List<MyProduct> findByProductName(String name) throws Exception {
		return sqlSession.selectList(NS+"findByProductName", name);
	}


}

package com.service.spring.aop.model;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAOImpl implements ReportDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;
	public static final String NS="ns.sql.reportMapper.";
	
	@Override
	public void insertReport(String word) throws SQLException {
		sqlSession.insert(NS+"insertReport",word);
		
	}

	@Override
	public int updateReport(String word) throws SQLException {
		return sqlSession.update(NS+"updateReport",word);
	}

	@Override
	public List selectReport() throws SQLException {
		return sqlSession.selectList(NS+"selectReport");
	}
}

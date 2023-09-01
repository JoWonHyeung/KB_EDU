package com.service.spring.aop.model;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ReportDAOImpl implements ReportDAO{

	@Autowired
	private SqlSession sqlSession;
	public static final String NS = "ns.sql.reportMapper.";
	
	@Override
	public int insertReport(String word) throws Exception {
		int result = sqlSession.insert(NS + "insertReport", word);
		return result;
	}

	@Override
	public int updateReport(String word) throws Exception {
		int result = sqlSession.update(NS + "updateReport", word);
		return result;
	}

	@Override
	public List selectReport() throws Exception {
		return sqlSession.selectList(NS + "selectReport");
	}

}

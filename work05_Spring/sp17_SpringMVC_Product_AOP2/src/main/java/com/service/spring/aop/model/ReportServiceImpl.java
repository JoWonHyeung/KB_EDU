package com.service.spring.aop.model;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService{
	
	@Autowired
	private ReportDAO reportDAO;
	
	
	@Override
	public List selectReport() throws SQLException {		
		return reportDAO.selectReport();
	}

	@Override
	public void saveReport(String word) throws SQLException {
		int result=reportDAO.updateReport(word);	
		System.out.println(result + " ***************************");
		if(result==0)
			reportDAO.insertReport(word);
	}
	
}

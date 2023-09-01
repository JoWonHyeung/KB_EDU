package com.service.spring.aop.model;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportServiceImpl implements ReportService {
	
	@Autowired
	private ReportDAO reportDAO;
	
	@Override
	public void saveReport(String word) throws Exception {
		int result = reportDAO.updateReport(word);
		
		System.out.println("**************  " + result + "  *********************");
		if(result == 0) {
			reportDAO.insertReport(word);
		}
	}

	@Override
	public List selectReport() throws Exception {
		return reportDAO.selectReport();
	}

}

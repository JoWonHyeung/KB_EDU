package com.service.spring.aop.model;

import java.sql.SQLException;
import java.util.List;

public interface ReportService {
	List selectReport() throws SQLException;
	void saveReport(String word) throws SQLException;
	
}

package com.service.spring.aop.model;

import java.sql.SQLException;
import java.util.List;

public interface ReportDAO {
	void insertReport(String word) throws SQLException;
	int updateReport(String word) throws SQLException;
	List selectReport() throws SQLException;
}

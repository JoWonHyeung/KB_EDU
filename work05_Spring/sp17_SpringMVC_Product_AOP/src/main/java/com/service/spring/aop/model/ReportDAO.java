package com.service.spring.aop.model;

import java.util.List;

public interface ReportDAO {
	int insertReport(String word) throws Exception;
	int updateReport(String word) throws Exception;
	List selectReport() throws Exception;
}

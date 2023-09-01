package com.service.spring.aop.model;

import java.util.List;

public interface ReportService {
	void saveReport(String word) throws Exception;
	List selectReport() throws Exception;
}

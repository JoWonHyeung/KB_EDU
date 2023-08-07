package com.jdbc.dao;

import java.sql.SQLException;
import java.util.ArrayList;

import com.jdbc.vo.Custom;

//Business Logic의 템플릿
public interface CustomDAO {
	void addCustom(Custom cust) throws SQLException;
	void deleteCustom(int id) throws SQLException;
	void updateCustom(Custom cust) throws SQLException;
	
	Custom getCustomer(int id) throws SQLException;
	ArrayList<Custom> getAllCustomer() throws SQLException;
	
}

//[작업순서]
//1. vo 생성, 인터페이스로 템플릿 생성
//2.
package com.card.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.card.dao.CustDAO;
import com.card.exception.DuplicateSSNException;
import com.card.exception.RecordNotFoundException;
import com.card.vo.Card;
import com.card.vo.Cust;
import com.card.vo.Purchase;

import config.ServerInfo;

public class CustDAOImpl implements CustDAO {

	private static CustDAOImpl dao = new CustDAOImpl();
	
	private CustDAOImpl() {
		
	}
	
	public static CustDAOImpl getInstance() {
		return dao;
	}
	
	//공통 로직
	public Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	    System.out.println("DB Connect....");        
	    return conn; 
	}
	
	public void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
	    if(conn!=null) conn.close();   
	}

	public void closeAll(ResultSet rs, PreparedStatement ps, Connection conn) throws SQLException {
		 if(rs!=null) rs.close();
		    closeAll(ps,conn);  
	}
	
	//비즈니스 로직
	@Override
	public void buy(Card card, int price) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ArrayList<Purchase> getPurchase(String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchase() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchaseCompanyDetails(String companyName, String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getPurchaseByCompany(String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getPurchaseByPeriod(String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Map<String, Integer> getPurchaseByCategory(String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Purchase> getPurchaseByFiltering(String companyName, String ssn, int criteria, boolean flag)
			throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getTotalAmount(String ssn) throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void getGrade(String companyName, String ssn, String name) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void printAlgorithm() throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void register(Cust cust) throws SQLException, DuplicateSSNException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Cust cust) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateAddress(Cust cust) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updatePhoneNumber(String phoneNumber) throws SQLException, RecordNotFoundException {
		// TODO Auto-generated method stub
		
	}

}

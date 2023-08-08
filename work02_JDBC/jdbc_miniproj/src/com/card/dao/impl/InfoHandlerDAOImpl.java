package com.card.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.card.dao.InfoHandlerDAO;
import com.card.exception.DuplicateSSNException;
import com.card.exception.RecordNotFoundException;
import com.card.vo.Card;
import com.card.vo.Cust;

import config.ServerInfo;

public class InfoHandlerDAOImpl implements InfoHandlerDAO {
	
	private static InfoHandlerDAOImpl dao = new InfoHandlerDAOImpl();
	
	private InfoHandlerDAOImpl(){
		System.out.println("CustomDAOImpl Creating...Using Singletone");
	}
	
	public static InfoHandlerDAOImpl getInstance() {
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
	private boolean isExist(Cust cust, Connection conn) throws SQLException{
	    String query ="SELECT ssn FROM cust WHERE ssn=?";
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setString(1, cust.getSsn());
	    ResultSet rs = ps.executeQuery();
	    return rs.next();
	}
	
	private boolean isExist(Card card, Connection conn) throws SQLException{
	    String query ="SELECT card_id FROM card WHERE card_id=?";
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setString(1, card.getCardId());
	    ResultSet rs = ps.executeQuery();
	    return rs.next();
	}
	
	

	@Override
	public void register(Cust cust) throws SQLException, DuplicateSSNException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        if(!isExist(cust, conn)) {//추가하려는  ssn고객이 없다면
	            String query = "INSERT INTO cust(ssn, cust_name, cust_address, phone) VALUES(?,?,?, ?)";
	            ps=  conn.prepareStatement(query);
	            ps.setString(1, cust.getSsn());
	            ps.setString(2, cust.getCustName());
	            ps.setString(3, cust.getCustAddress());
	            ps.setString(4,  cust.getPhone());
	            System.out.println(ps.executeUpdate()+" 명 INSERT 성공...registerCustomer()..");
	        }else {
	            throw new DuplicateSSNException("해당하는 고객은 이미 회원이십니다");
	        }
	    }finally {
	        closeAll(ps, conn);
	    }		
	}

	@Override
	public void register(Card card) throws SQLException, DuplicateSSNException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        if(!isExist(card, conn)) {//추가하려는 카드 번호가 없다
	            String query = "INSERT INTO card(card_id, expire_date, company_name) VALUES(?,?,?)";
	            ps=  conn.prepareStatement(query);
	            Date date = Date.valueOf(card.getExpire());
	            ps.setString(1, card.getCardId());
	            ps.setDate(2, date);
	            ps.setString(3, card.getCompanyName());
	            System.out.println(ps.executeUpdate()+" 카드 INSERT 성공..registerCard()..");
	        }else {
	            throw new DuplicateSSNException("해당하는 카드는 이미 등록되있습니다.");
	        }
	    }finally {
	        closeAll(ps, conn);
	    }		
	}

	@Override
	public void delete(Cust cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        if(isExist(cust, conn)) {
	            String query = "DELETE cust WHERE ssn=?";
	            ps = conn.prepareStatement(query);
	            ps.setString(1, cust.getSsn());

	            System.out.println(ps.executeUpdate()+" 명 DELETE OK...deleteCustomer()..");
	        }else {
	            throw new RecordNotFoundException("삭제할 대상의 고객이 없습니다 ");
	        }
	    }finally {
	        closeAll(ps, conn);
	    }        
	}

	@Override
	public void delete(Card card) throws SQLException, RecordNotFoundException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        if(isExist(card, conn)) {
	            String query = "DELETE card WHERE card_id=?";
	            ps = conn.prepareStatement(query);
	            ps.setString(1, card.getCardId());

	            System.out.println(ps.executeUpdate()+" 명 DELETE OK...deleteCard()..");
	        }else {
	            throw new RecordNotFoundException("삭제할 대상의 카드가 없습니다 ");
	        }
	    }finally {
	        closeAll(ps, conn);
	    }        		
	}

	@Override
	public void updateAddress(Cust cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        String query = "UPDATE cust SET cust_address=? WHERE ssn=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, cust.getCustAddress());
	        ps.setString(2, cust.getSsn());

	        int row = ps.executeUpdate();
	        if(row==1)System.out.println(row+" 명의 주소 UPDATE OK...updateCustomer()...");
	        else throw new RecordNotFoundException("수정할 대상의 고객이 없습니다");
	    }finally {
	        closeAll(ps, conn);
	    }        		
	}

	@Override
	public void updatePhonenumber(Cust cust) throws SQLException, RecordNotFoundException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        String query = "UPDATE cust SET phone=? WHERE ssn=?";
	        ps = conn.prepareStatement(query);
	        ps.setString(1, cust.getPhone());
	        ps.setString(2, cust.getSsn());

	        int row = ps.executeUpdate();
	        if(row==1)System.out.println(row+" 명의 전화번호 UPDATE OK...updateCustomer()...");
	        else throw new RecordNotFoundException("수정할 대상의 고객이 없습니다");
	    }finally {
	        closeAll(ps, conn);
	    }            		
	}


}
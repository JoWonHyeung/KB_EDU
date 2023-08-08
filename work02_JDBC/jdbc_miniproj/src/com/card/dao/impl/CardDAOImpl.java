package com.card.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.card.dao.CardDAO;
import com.card.exception.DuplicateSSNException;
import com.card.exception.RecordNotFoundException;
import com.card.vo.Card;
import com.card.vo.Cust;

import config.ServerInfo;

public class CardDAOImpl implements CardDAO {

	private static CardDAOImpl dao = new CardDAOImpl();
	
	private CardDAOImpl() {
		
	}
	
	public static CardDAOImpl getInstance() {
		return dao;
	}
	
	//공통 로직
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
	    System.out.println("DB Connect....");        
	    return conn; 
	}
	
	private void closeAll(PreparedStatement ps, Connection conn) throws SQLException {
		if(ps!=null) ps.close();
	    if(conn!=null) conn.close();   
	}

	//비즈니스 로직
	private boolean isExist(String cardId, Connection conn) throws SQLException{
	    String query ="SELECT card_id FROM card WHERE card_id=?";
	    PreparedStatement ps = conn.prepareStatement(query);
	    ps.setString(1, cardId);
	    ResultSet rs = ps.executeQuery();
	    return rs.next();
	}
	
	@Override
	public void register(Card card) throws SQLException, DuplicateSSNException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        if(!isExist(card.getCardId(), conn)) {//추가하려는 카드 번호가 없다
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
	public void delete(String cardId) throws SQLException, RecordNotFoundException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    try {
	        conn = getConnect();
	        if(isExist(cardId, conn)) {
	            String query = "DELETE card WHERE card_id=?";
	            ps = conn.prepareStatement(query);
	            ps.setString(1, cardId);

	            System.out.println(ps.executeUpdate()+" 명 DELETE OK...deleteCard()..");
	        }else {
	            throw new RecordNotFoundException("삭제할 대상의 카드가 없습니다 ");
	        }
	    }finally {
	        closeAll(ps, conn);
	    }   
	}


}

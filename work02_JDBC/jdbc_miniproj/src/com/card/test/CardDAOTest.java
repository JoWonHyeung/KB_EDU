package com.card.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.card.dao.impl.CardDAOImpl;
import com.card.vo.Card;

import config.ServerInfo;

public class CardDAOTest {

	public static void main(String[] args) throws Exception{
		CardDAOImpl dao = CardDAOImpl.getInstance();
		
		//beforeEach();
		
//		System.out.println("================= card register ================");
//		dao.register(new Card("993-999-999", "2021-01-03", "삼성"));
//
//		System.out.println("================= card delete ================");
//		dao.delete("993-999-999");
//		
//		System.out.println("================= card register... DuplicatedSSNException... ================");
//		dao.register(new Card("992-999-999", "2021-01-03", "삼성"));
//		
//		System.out.println("================= card delete... RecordNotFound... ================");
//		dao.delete("994-999-999");
		
		//afterEach();
	}
	
	private static void beforeEach() throws SQLException {
//		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
//		PreparedStatement ps = null;
//		
//		String query = "DELETE card WHERE card_id=?";
//		
//		ps = conn.prepareStatement(query);
//		ps.setString(1, "999");
//		
//		ps.executeUpdate();
//		
//		System.out.println("afterEach Success...");
	}
	
	private static void afterEach() throws SQLException {
//		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
//		PreparedStatement ps = null;
//		
//		String query = "DELETE card WHERE card_id=?";
//		
//		ps = conn.prepareStatement(query);
//		ps.setString(1, "999");
//		
//		ps.executeUpdate();
//		
//		System.out.println("afterEach Success...");
	}
}

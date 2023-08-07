package com.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

/*
 * Business Logic을 가지고 있는 DAO 클래스
 * 하나의 기능이 완벽한 서비스 단위이다.
 */
public class CustomDAO {
	
	public CustomDAO(){
		System.out.println("CusomDAO...Creating...");
	}
	
	//////////////////// 공통적으로 반복되는 로직 ////////////////////////
	private Connection getConnect() throws SQLException {
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");
		
		return conn;
	}
	
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException {
		if(ps != null) ps.close();
		if(conn != null) conn.close();
	}
	
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException {
		if(rs != null) rs.close();
		closeAll(conn, ps);
	}
	
	////////////////////Business Logic :: basic CRUD//////////////////////
	//메소드하나는 하나의 기능이다.
	public void addCustom(int id, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "INSERT INTO custom (id, name, address) VALUES(?,?,?)";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setString(3, addr);
			
			System.out.println(ps.executeUpdate() + "명 등록 성공");	
		}finally {
			closeAll(conn, ps);
		}
		
	}//addCustom
	
	public void deleteCustom(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "DELETE custom WHERE id=?";
			ps = conn.prepareStatement(query);
			
			ps.setInt(1, id);
			
			System.out.println(ps.executeUpdate() + "명 삭제 성공");	
		}finally {
			closeAll(conn, ps);
		}
	}

	public void updateCustom(int id, String name, String addr) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
		try {
			conn = getConnect();
			
			String query = "UPDATE custom SET name=?, address=? WHERE id=?";
			ps = conn.prepareStatement(query);
			
			ps.setString(1, name);
			ps.setString(2, addr);
			ps.setInt(3, id);
			
			System.out.println(ps.executeUpdate() + "명 업데이트 성공");	
		}finally {
			closeAll(conn, ps);
		}
	}
	
	public void printAllCustom() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT * FROM custom";
			ps = conn.prepareStatement(query);
			rs = ps.executeQuery();
			
			while(rs.next()) 
				System.out.println(rs.getInt("id") + "\t" + rs.getString("name") + "\t" + rs.getString("address"));
			
		}finally {
			closeAll(conn, ps, rs);
		}
	}
	
	public void printACustom(int id) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = getConnect();
			
			String query = "SELECT id, name, address FROM custom WHERE id=?";
			
			ps = conn.prepareStatement(query);
			ps.setInt(1, id);
			
			rs = ps.executeQuery();
			if(rs.next())
				System.out.println(rs.getString("name") + "\t" + rs.getString("address"));
			else
				System.out.println("Not Found Customer....");
			
		}finally {
			closeAll(conn, ps, rs);
		}
	}
	
}

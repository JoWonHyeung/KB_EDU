package com.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class JDBCTest1 {

	public JDBCTest1() throws SQLException{
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
			System.out.println("Database Connection....");
			
			/* Delete :: ID 40번 고객 정보 삭제
			String query = "DELETE custom WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement Creation....");
			
			ps.setInt(1, 40);
			
			int row = ps.executeUpdate(); //이때 실질적으로 DB에서 데이터 삭제가 발생..commit 자동으로
			System.out.println(row + "Row Delete Ok~~!!");
			*/
			
			// UPDATE :: ID 10번 고객의 이름을 James1, 주소를 NY으로 수정
			/*
			String query = "UPDATE custom SET name=?, address=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("PreparedStatement Creation...");
			
			ps.setString(1, "James1");
			ps.setString(2, "NY");
			ps.setInt(3, 10);
			
			int row = ps.executeUpdate();
			System.out.println(row + "Row Update OK~~!!");
			*/
			
			// SELECT :: custom 테이블에 모든 데이터를 받아서 출력
			String query = "SELECT id, name, address FROM custom";
			ps = conn.prepareStatement(query);
			
			rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getInt("id") + "\t"
						+ rs.getString("name") + "\t"
						+ rs.getString("address"));
			}	
		} finally {
			rs.close();
			ps.close();
			conn.close(); //무조건 수행!!!!
		}
		
	}
	
	public static void main(String[] args) throws SQLException {
		new JDBCTest1();
	}

	static { //Global Initailization(글로벌 초기화)
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success....");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		}
	}
}

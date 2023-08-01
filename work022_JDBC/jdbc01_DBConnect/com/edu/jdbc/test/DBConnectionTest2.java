package com.edu.jdbc.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import config.ServerInfo;

public class DBConnectionTest2 {

	
	public DBConnectionTest2() {
		
		try {
			//1. Driver Loading...
			//FQCN(FULL Qualified Class Name)
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading...Success...");
			
			//2. DB Connection... 
			String url = ServerInfo.URL;
			String user = ServerInfo.USER;
			String password = ServerInfo.PASSWORD;
			
			Connection conn = DriverManager.getConnection(url, user, password);		
			System.out.println("DB Connection... Success...");
			
			//3. PrepareStatement 객체 생성
			//   custom테이블에 하나의 행을 추가하는 쿼리문
			String query  = "INSERT INTO custom (id, name, address) VALUES (?,?,?)"; //Insert Query 이런식으로 작성해서 null값 처리 가능
			PreparedStatement ps = conn.prepareStatement(query);
			System.out.println("Creating PreparedStatement....");
			
			//?에 값을 바인딩
			ps.setInt(1, 12);
			ps.setString(2, "Hinson");
			ps.setString(3, "Brandon");
			
			//4. 쿼리문 실행 
			int result = ps.executeUpdate(); //한 줄 넣어졌으면 1이 출력!!!
			System.out.println(result);
		} catch (ClassNotFoundException e) {
			System.out.println("Driver Loading...Fail");
		} catch (SQLException e) {
			System.out.println("DB Connection... Fail...");
		}
		
	}
	
	public static void main(String[] args) {
		new DBConnectionTest2();
	}

}

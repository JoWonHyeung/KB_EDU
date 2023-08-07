package com.jdbc.test;

import com.jdbc.dao.CustomDAO;

import config.ServerInfo;

public class JDBCTest2 {

	public static void main(String[] args) throws Exception {
		CustomDAO dao = new CustomDAO();
	
		//addCustom
		//dao.addCustom(40, "이정재", "신사동");
		//System.out.println("addCustom Success...");
		//deleteCustom
		//dao.deleteCustom(40);
		//System.out.println("deleteCustom Success");
		//dao.printACustom(52);
		//dao.updateCustom(20, "Maker", "Bangkok");
	
		dao.printAllCustom();
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

package com.jdbc.test;

import com.jdbc.dao.CustomDAO;
import com.jdbc.dao.impl.CustomDAOImpl;
import com.jdbc.vo.Custom;

import config.ServerInfo;

public class CustomDAOTest {

	public static void main(String[] args) throws Exception {
		CustomDAOImpl dao = CustomDAOImpl.getInstance();
		
		dao.addCustom(new Custom(88,"김갑룡","도봉산"));
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

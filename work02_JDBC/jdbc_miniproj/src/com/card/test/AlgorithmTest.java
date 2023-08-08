package com.card.test;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.card.dao.impl.ServiceDAOImpl;

public class AlgorithmTest {

	public static void main(String[] args) throws SQLException {
		ServiceDAOImpl service = ServiceDAOImpl.getInstance();
		
		service.printAlgorithm();
	}

}

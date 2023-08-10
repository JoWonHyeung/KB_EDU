package com.card.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
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
	
	/* 카드 결제 */
	@Override
	public void buy(Card card, String ssn, String date, String category, int price) throws SQLException {
		Connection conn = null;
		PreparedStatement ps = null;
		
        DecimalFormat decFormat = new DecimalFormat("###,###");
        try {
            conn = getConnect();

            String query = "INSERT INTO purchase (id, ssn, card_id, day, price, company_name ,category ) VALUES (seq_purchase.nextVal, ?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, ssn);
            ps.setString(2, card.getCardId());
            ps.setString(3, date);
            ps.setInt(4, price);
            ps.setString(5, card.getCompanyName());
            ps.setString(6, category);

            ps.executeUpdate();
            System.out.println(ssn + "회원님이 " + card.getCompanyName() + " 카드(" + card.getCardId() + ")로 " + decFormat.format(price) + "원 결제되셨습니다." );
        } finally {
            closeAll(ps, conn);
        }
		
	}

	/* 해당 사용자의 구매이력 */
	@Override
	public ArrayList<Purchase> getPurchase(String ssn) throws SQLException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    ArrayList<Purchase> temp = new ArrayList<Purchase>();
	    
	    try {
	        conn = getConnect();
	        String query = "SELECT card_id, day, price, category, company_name FROM purchase WHERE ssn=?";
	                    
	        ps = conn.prepareStatement(query);
	        
	        ps.setString(1, ssn);
	        rs = ps.executeQuery();
	        
	        while(rs.next()) 
	            temp.add(new Purchase(rs.getInt("price"),
	                    ssn, 
	                    rs.getString("card_id"),
	                    rs.getString("day"),
	                    rs.getString("category"),
	                    rs.getString("company_name")));
	            
	    }finally {
	        closeAll(rs, ps, conn);
	    }
	    
	    return temp;
	}

	@Override
	public ArrayList<Purchase> getPurchase() throws SQLException {
		Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    ArrayList<Purchase> temp = new ArrayList<Purchase>();
	    
	    try {
	        conn = getConnect();
	        String query = "SELECT ssn, card_id, day, price, category, company_name FROM purchase";
	                    
	        ps = conn.prepareStatement(query);
	        
	        rs = ps.executeQuery();
	        
	        while(rs.next()) 
	            temp.add(new Purchase( 
	                    rs.getInt("price"),
	                    rs.getString("ssn"),
	                    rs.getString("card_id"),
	                    rs.getString("day"),
	                    rs.getString("category"),
	                    rs.getString("company_name"))
	            	);
	    }finally {
	        closeAll(rs, ps, conn);
	    }
	    
	    return temp;
	}

	@Override
	public ArrayList<Purchase> getPurchaseCompanyDetails(String companyName, String ssn) throws SQLException {
		ArrayList<Purchase> temp = new ArrayList<>();
	    ArrayList<Purchase> history = getPurchase(ssn);
	    
	    for(Purchase p : history) {
	        if(p.getCompanyName().equals(companyName)) {
	            temp.add(p);
	        }
	    }
	    
	    return temp;
	}

	@Override
	public Map<String, Integer> getPurchaseByCompany(String ssn) throws SQLException {
		Map<String, Integer> temp = new HashMap<>();
        ArrayList<Purchase> history = getPurchase(ssn);
        
        PreparedStatement ps = null;
        ResultSet rs = null;
        Connection conn = null;
        
        try {
        	conn = getConnect();
        	
        	for(Purchase p : history) {
        		
        	}
        	
        } finally {
        	closeAll(rs, ps, conn);
        }
        
//        for(Purchase p : history) {
//            if(temp.containsKey(p.getCompanyName())) 
//                temp.put(p.getCompanyName(), temp.get(p.getCompanyName()) + p.getPrice());
//            else 
//                temp.put(p.getCompanyName(), p.getPrice());
//        }

        return temp;
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

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

import com.card.dao.ServiceDAO;
import com.card.vo.Purchase;

import config.ServerInfo;

public class ServiceDAOImpl implements ServiceDAO{
	private static ServiceDAOImpl service = new ServiceDAOImpl();
	
	private ServiceDAOImpl() {
		System.out.println("ServiceDAOImpl Create...");
	}
	
	public static ServiceDAOImpl getInstance() {
		return service;
	}
	
	//공통로직
	private Connection getConnect() throws SQLException{
		Connection conn = DriverManager.getConnection(ServerInfo.URL, ServerInfo.USER, ServerInfo.PASSWORD);
		System.out.println("DB Connect....");
			
		return conn;
	}	
		
	private void closeAll(Connection conn, PreparedStatement ps) throws SQLException{
		if(ps!=null) ps.close();
		if(conn!=null) conn.close();
	}	
		
	private void closeAll(Connection conn, PreparedStatement ps, ResultSet rs) throws SQLException{
		if(rs!=null) rs.close();
		closeAll(conn,ps);
	}
	
	
	@Override
	public void buy(String ssn, String cardId,String companyName, String category, int price, String date) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        DecimalFormat decFormat = new DecimalFormat("###,###");
        try {
            conn = getConnect();

            String query = "INSERT INTO purchase (id, ssn, card_id, day, price, company_name ,category ) VALUES (seq_purchase.nextVal, ?,?,?,?,?,?)";
            ps = conn.prepareStatement(query);
            ps.setString(1, ssn);
            ps.setString(2, cardId);
            ps.setString(3, date);
            ps.setInt(4, price);
            ps.setString(5, companyName);
            ps.setString(6, category);

            ps.executeUpdate();
            System.out.println(companyName + "삼성 카드(" + cardId + ")로 " +decFormat.format(price) + "원 결제되셨습니다." );
        } finally {
            closeAll(conn, ps);
        }

}

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
	        closeAll(conn, ps, rs);
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

	        for(Purchase p : history) {
	            if(temp.containsKey(p.getCompanyName())) 
	                temp.put(p.getCompanyName(), temp.get(p.getCompanyName()) + p.getPrice());
	            else 
	                temp.put(p.getCompanyName(), p.getPrice());
	        }

	        return temp;
	    }

	@Override
	public Map<String, Integer> getPurchaseByPeriod(String ssn) throws SQLException {
        Map<String, Integer> temp = new HashMap<>();
        ArrayList<Purchase> history = getPurchase(ssn);

        for(Purchase p : history) {
            String key = p.getDay().split(" ")[0].split("-")[0] + "/" + p.getDay().split(" ")[0].split("-")[1];
            if(temp.containsKey(key))
                temp.put(key, temp.get(key) + p.getPrice());
            else
                temp.put(key, p.getPrice());
        }

        return temp;
    }

	@Override
	public Map<String, Integer> getPurchaseByCategory(String ssn) throws SQLException {
	    Map<String, Integer> temp = new HashMap<>();
	    ArrayList<Purchase> history = getPurchase(ssn);
	    
	    for(Purchase p : history) {
	        if(temp.containsKey(p.getCategory())) 
	            temp.put(p.getCategory(), temp.get(p.getCategory()) + p.getPrice());
	        else 
	            temp.put(p.getCategory(), p.getPrice());
	    }
	    
	    return temp;
	}

	@Override
	public ArrayList<Purchase> getPurchaseByFiltering(String companyName,String ssn,  int criteria, boolean flag)throws SQLException { // false이면 criteria 이하, true이면 criteria 이상
		
		ArrayList<Purchase>temp = new ArrayList<>();
		temp = getPurchaseCompanyDetails(companyName, ssn);
		
		Purchase first, second;
		for(int i=0;i<temp.size()-1;i++) { //오름차순 정렬
			for(int j = 0;j<temp.size()-1-i;j++) {
				first = temp.get(j);
				second = temp.get(j+1);
				if(first.getPrice() > second.getPrice()) {
					Purchase p = temp.get(j);
					temp.add(j, second);
					temp.remove(j+1);
					temp.add(j+1, first);
					temp.remove(j+2);
				}
			}
		}
		
		
		ArrayList<Purchase>result = new ArrayList<>();
		if(!flag) {
			for(Purchase p : temp) {
				if(p.getPrice() > criteria)break;
				result.add(p);
			}
		}
		else {
			for(Purchase p : temp) {
				if(p.getPrice() >= criteria)result.add(p);
			}
		}
		
		return result;
	}

	@Override
	public int getTotalAmount(String ssn) throws SQLException{
	    ArrayList<Purchase> history = getPurchase(ssn);
	    int temp = 0;
	    for(Purchase p : history) 
	        temp += p.getPrice();
	    
	    return temp;
	}

	@Override
	public void checkGrade(String companyName, String ssn, String name) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        ResultSet rs2 = null;
        try {
            conn = getConnect();

//            String query = "SELECT card_id, TO_CHAR( sum(price) , '999,999,999') 총액, company_name,  CASE WHEN sum(price) > 500000 THEN '플래티넘'WHEN sum(price) BETWEEN 300000 AND 500000  THEN '골드'WHEN sum(price) BETWEEN 100000 AND 30000  THEN '실버' ELSE '브론즈' END AS GRADE,DENSE_RANK() OVER (ORDER BY sum(price) DESC) 순위 FROM purchase where company_name =? AND  ssn =? group by company_name,card_id ";

            String query = "SELECT  card_id, LTRIM(TO_CHAR( sum(price) , '999,999,999,999,999')), company_name ,\r\n"

                + "CASE WHEN sum(price) > 500000 THEN '플래티넘'\r\n"
                + "            WHEN sum(price) BETWEEN 300000 AND 500000  THEN '골드'\r\n"
                + "             WHEN sum(price) BETWEEN 100000 AND 30000  THEN '실버'\r\n"
                + "             ELSE '브론즈' END AS GRADE,\r\n"
                + "             DENSE_RANK() OVER (ORDER BY sum(price) DESC) 순위\r\n"
                + "FROM purchase\r\n"
                + "where company_name = ? AND ssn =?\r\n"
                + "group by company_name, card_id";
            ps = conn.prepareStatement(query);
            ps.setString(1, companyName);
            ps.setString(2, ssn);
            rs = ps.executeQuery();
        
            while(rs.next()) {
            
            	System.out.println(name + "님의 " + companyName + "카드(" +rs.getString(1)+ ") 총 소비는 "+ rs.getString(2) + "이며, 등급은 " +  rs.getString(4) + "입니다.\n"
                    + name +"님은 " + companyName + "카드 전체 고객 중 " +  rs.getInt(5) + "위 입니다.");
            
            	String grade = rs.getString(4);
            	String cardId = rs.getString(1);
            	String query2 = "SELECT count(*) \r\n"
            			+ "FROM (\r\n"
            			+ "SELECT  card_id, sum(price), company_name, \r\n"
            			+ "CASE WHEN sum(price) > 500000 THEN '플래티넘'\r\n"
            			+ "            WHEN sum(price) BETWEEN 300000 AND 500000  THEN '골드'\r\n"
            			+ "             WHEN sum(price) BETWEEN 100000 AND 30000  THEN '실버'\r\n"
            			+ "             ELSE '브론즈' END AS GRADE,\r\n"
            			+ "             DENSE_RANK() OVER (ORDER BY sum(price) DESC) 순위\r\n"
            			+ "FROM purchase\r\n"
            			+ "where company_name =?  \r\n"
            			+ "group by company_name, card_id)\r\n"
            			+ "WHERE GRADE =?";
            	ps= conn.prepareStatement(query2);
            	ps.setString(1, companyName);
            	ps.setString(2, grade);
            	rs2 = ps.executeQuery();
            	if(rs2.next())System.out.println(name + "님이 속한 "+ grade +"  등급은 총 " + rs2.getInt(1) + "명 입니다.");
            	String query3 = "update card set cust_grade =? where card_id=?";
                ps= conn.prepareStatement(query3);
                ps.setString(1, grade);
                ps.setString(2, cardId);
                ps.executeUpdate();
            	System.out.println("===========================");
            }
        
        } finally {
        	closeAll(conn, ps);
        }
	}
	
	@Override
	public ArrayList<Purchase> getPurchase() throws SQLException {
	    Connection conn = null;
	    PreparedStatement ps = null;
	    ResultSet rs = null;
	    
	    ArrayList<Purchase> temp = new ArrayList<Purchase>();
	    
	    try {
	        conn = getConnect();
	        String query = "SELECT card_id, day, price, category, company_name FROM purchase";
	                    
	        ps = conn.prepareStatement(query);
	        
	        rs = ps.executeQuery();
	        
	        while(rs.next()) 
	            temp.add(new Purchase( 
	                    rs.getString("day"),
	                    rs.getString("category"),
	                    rs.getString("company_name")));
	            
	    }finally {
	        closeAll(conn, ps, rs);
	    }
	    
	    return temp;
	}
	

	@Override
	public void printAlgorithm() throws SQLException{
	        // 구매 아이템리스트
	        ArrayList<String> lineArrList = new ArrayList<>();
	        ArrayList<Purchase> history = getPurchase();
	        // 하나의 아이템이 전체에서 나온 개수 축적하는 Map
	        HashMap<String, Integer> uniqCntMap = new HashMap<String, Integer>();
	        // 기준 아이템과 같이 나온 대상 아이템의 개수 축적하는 Map
	        HashMap<String, HashMap<String, Integer>> pareCntMap = new HashMap<String, HashMap<String, Integer>>();
	 
	        // 임시로 넣은 데이터
	        for(Purchase p : history) {
	            lineArrList.add(
	                    p.getDay().split(" ")[0].split("-")[0] + "/" + p.getDay().split(" ")[0].split("-")[1] + "," +
	                    p.getCategory() + "," +
	                    p.getCompanyName());
	        }


	 
	        String stdItem = "";
	        String targetItem = "";
	        int cnt = 0;
	        int uniCnt = 0;
	 
	        for (int i = 0; i < lineArrList.size(); i++) {
	            // line 하나를 가져와 , 구분자로 split 해서 items 배열에 넣는다.
	            String[] items = lineArrList.get(i).split(",");
	            // item 개수만큼 for문을 돌린다.
	            for (int n = 0; n < items.length; n++) {
	                // items가 순서대로 stdItem이 되고
	                stdItem = items[n];
	 
	                // 아이템별 등장 횟수 카운팅하여 uniqCntMap에 (키워드,카운트)형태로 담는다.
	                if (uniqCntMap.containsKey(stdItem))
	                    uniCnt = uniqCntMap.get(stdItem) + 1;
	                else
	                    uniCnt = 1;
	 
	                uniqCntMap.put(stdItem, uniCnt);

	 
	                // pareCntMap에 기준아이템이 있으면
	                HashMap<String, Integer> targetCntMap = new HashMap<String, Integer>();
	                if (pareCntMap.containsKey(stdItem)) {
	                    // 있으면 있는 Map을 가져오고
	                    targetCntMap = pareCntMap.get(stdItem);
	                } else {
	                    // 없으면 새로 Map생성한다.
	                    targetCntMap = new HashMap<String, Integer>();
	                }
	 
	                for (int m = 0; m < items.length; m++) {
	                    // items가 순서대로 대상 아이템이 된다.
	                    targetItem = items[m];
	 
	                    // 기준 아이템과 대상 아이템이 같으면
	                    // 해당 targetItem 에 대한 count 작업은 건너 뛴다.
	                    if (stdItem.equals(targetItem))
	                        continue;
	 
	                    // 가져온  targetCntMap에 targetItem이 있으면
	                    if (targetCntMap.containsKey(targetItem))
	                        cnt = targetCntMap.get(targetItem) + 1;
	                    else
	                        cnt = 1;
	 
	                    // targetCntMap에 cnt를 업데이트 해준다.
	                    targetCntMap.put(targetItem, cnt);
	                }
	                // 큰 맵(pareCntMap)에 다시 넣어둔다.
	                pareCntMap.put(stdItem, targetCntMap);
	            }
	        }
	        for (String item : uniqCntMap.keySet())
	            System.out.println(item + " => " + uniqCntMap.get(item));
	        System.out.println("=====================================");
	        System.out.println("[아이템 쌍 별 개수]");
	        for (String std : pareCntMap.keySet()) {
	            HashMap<String, Integer> tarCntMap = pareCntMap.get(std);
	            for (String tar : tarCntMap.keySet()) {
	                int count = tarCntMap.get(tar);
	                System.out.println("[" + std + "->" + tar + "] = " + count);
	            }
	        }



	    }

	
}

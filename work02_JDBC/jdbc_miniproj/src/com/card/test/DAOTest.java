package com.card.test;

import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import com.card.dao.impl.InfoHandlerDAOImpl;
import com.card.dao.impl.ServiceDAOImpl;
import com.card.exception.DuplicateSSNException;
import com.card.exception.RecordNotFoundException;
import com.card.vo.Card;
import com.card.vo.Cust;
import com.card.vo.Purchase;

import config.ServerInfo;

public class DAOTest {

	public static void main(String[] args) throws SQLException, DuplicateSSNException, RecordNotFoundException {
		InfoHandlerDAOImpl info = InfoHandlerDAOImpl.getInstance();
		ServiceDAOImpl service = ServiceDAOImpl.getInstance();
		
		
		System.out.println("========SSN = 5678, 이름 = 박서희 등록!================");
		info.register(new Cust("5678","박서희","선릉", "010-2064-7243"));
		info.register(new Card("4568558584", "2023-08-03", "네이버"));
				
		
		System.out.println("========== 강동으로이사, 1234567890으로 번호 변경");
		info.updateAddress(new Cust("5678","박서희","강동", "010-2064-7243"));
		info.updatePhonenumber(new Cust("97069","강유석","도봉산", "1234567890"));
		
		
		System.out.println("============== 해지 ============================");
		info.delete(new Cust("5678","박서희","선릉", "010-2064-7243"));
		info.delete(new Card("4568558584", "2023-08-03", "네이버"));	
		
		
		
		System.out.println("****************mesh153 이 삼성 카드로 1000원 결제*************");
		 service.buy("mesh153","999-999-999","삼성","교통", 1000, "25/06/23");
		//service.checkGrade("삼성", "mesh153", "조원형");
		
	    DecimalFormat decFormat = new DecimalFormat("###,###");
	    
		System.out.println("==================== mesh153의 전체 구매 내역 getPurchase() =====================");
        for(Purchase p : service.getPurchase("mesh153")) {
            System.out.print("가격 : " + decFormat.format(p.getPrice()));
            System.out.print(" 카드 회사 : " + p.getCompanyName());
            System.out.print(" 카테고리 :" + p.getCategory());
            System.out.print(" 결제 날짜 : " + p.getDay());
            System.out.println();
        }
        
        System.out.println("======================mesh153의 삼성 카드 결제 내역 ======================");
        for(Purchase p : service.getPurchaseCompanyDetails("삼성", "mesh153")){
            System.out.println(p);
        }
        
        HashMap<String, Integer>map = new HashMap<>();
        System.out.println("====================== mesh153의 회사별 결제 내역 ======================");
        map = (HashMap<String, Integer>) service.getPurchaseByCompany("mesh153"); 
        for(String key : map.keySet()) {
            System.out.println(key + " : " + decFormat.format(map.get(key)));
        }
        
        System.out.println("==================== mesh153의 카테고리별 결제 내역 =====================");
        map = (HashMap<String, Integer>) service.getPurchaseByCategory("mesh153"); 

        for(String key : map.keySet()) {
            System.out.println(key + " : " + decFormat.format(map.get(key)));
        }
        
       
        System.out.println("========================= mesh153의 기간결 총 결제 금액 ==============================");
        map = (HashMap<String, Integer>) service.getPurchaseByPeriod("mesh153"); 

        for(String key : map.keySet()) {
            System.out.println(key + " : " + decFormat.format(map.get(key)));
        }
        
        System.out.println("======================지금까지 총 결제 금액 =========================");
        System.out.println(decFormat.format(service.getTotalAmount("mesh153")));
        
        
        System.out.println("==================삼성 카드로 30000원 이하 결제 내역============================");
        ArrayList<Purchase>temp1 = new ArrayList<>();
        temp1 = service.getPurchaseByFiltering("삼성", "mesh153", 30000, false);
        for(Purchase p : temp1) {
        	System.out.print("가격 : " + decFormat.format(p.getPrice()));
        	System.out.print(" 카드 회사 : " + p.getCompanyName());
        	System.out.print(" 카테고리 :" + p.getCategory());
        	System.out.print(" 결제 날짜 : " + p.getDay());
        	System.out.println();        }
        
        System.out.println("==================삼성 카드로 30000원 이상 결제 내역============================");
        ArrayList<Purchase>temp2 = new ArrayList<>();
        temp2 = service.getPurchaseByFiltering("삼성", "mesh153", 30000, true);
        for(Purchase p : temp2) {
        	System.out.print("가격 : " + decFormat.format(p.getPrice()));
        	System.out.print(" 카드 회사 : " + p.getCompanyName());
        	System.out.print(" 카테고리 :" + p.getCategory());
        	System.out.print(" 결제 날짜 : " + p.getDay());
        	System.out.println();        
        }
        
        System.out.println("=============================== 연관 분석 알고리즘============================");
        
		service.printAlgorithm();

	}
	
	static {
		try {
			Class.forName(ServerInfo.DRIVER_NAME);
			System.out.println("Driver Loading Success....");
			
		}catch(ClassNotFoundException e) {
			System.out.println("Driver Loading Fail....");
		}
	}

}

package com.card.test;

import java.sql.SQLException;

import com.card.dao.impl.CustDAOImpl;
import com.card.vo.Card;
import com.card.vo.Cust;
import com.card.vo.Purchase;

public class CustDAOTest {

	
	public static void main(String[] args) throws SQLException {
		CustDAOImpl dao = CustDAOImpl.getInstance();

		Card card = new Card("999-999-999","29/01/23","삼성");
		Cust cust = new Cust("mesh153","조원형","mesh153@naver.com","01036493276");
		
		System.out.println("========================= buy() =========================");
		//dao.buy(card, cust.getSsn(), "2023-01-02", "외식", 10000);
		
		System.out.println("========================= getPurchase(ssn) =========================");
		for(Purchase p : dao.getPurchase(cust.getSsn())) {
			System.out.println(p);
		}
		
		System.out.println("========================= getPurchase() =========================");	
		for(Purchase p : dao.getPurchase()) {
			System.out.println(p);
		}
		
		System.out.println("========================= getPurchaseCompanyDetails() =========================");
		for(Purchase p : dao.getPurchaseCompanyDetails(card.getCompanyName(), cust.getSsn())) {
			System.out.println(p);
		}
	}

}

package com.card.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.card.exception.DuplicateSSNException;
import com.card.exception.RecordNotFoundException;
import com.card.vo.Card;
import com.card.vo.Cust;
import com.card.vo.Purchase;

public interface CustDAO {
	void buy(Card card, int price)  throws SQLException; 						//결제
	ArrayList<Purchase> getPurchase(String ssn) throws SQLException;		    //해당 사용자의 구매이력
	ArrayList<Purchase> getPurchase() throws SQLException;						//모든 사용자의 구매이력
	ArrayList<Purchase> getPurchaseCompanyDetails(String companyName, String ssn) throws SQLException; //해당 사용자의 세부 회사 내역
    Map<String, Integer> getPurchaseByCompany(String ssn) throws SQLException;  //해당 사용자의 회사별 구매이력
    Map<String, Integer> getPurchaseByPeriod(String ssn) throws SQLException;   //해당 사용자의 기간별 분석
    Map<String, Integer> getPurchaseByCategory(String ssn) throws SQLException; //카테고리별 소비 분석
	ArrayList<Purchase> getPurchaseByFiltering(String companyName, String ssn, int criteria, boolean flag) throws SQLException; //필터링 
	int getTotalAmount(String ssn) throws SQLException; 							//해당 사용자의 카드 사용 금액 총합계
	void getGrade(String companyName, String ssn, String name) throws SQLException; //해당 사용자의 등급 산출
	void printAlgorithm() throws SQLException; 										//연관 분석 알고리즘
	
	//CRUD
	void register(Cust cust) throws SQLException, DuplicateSSNException;
	void delete(Cust cust)throws SQLException, RecordNotFoundException;
	void updateAddress(Cust cust)throws SQLException, RecordNotFoundException;
	void updatePhoneNumber(String phoneNumber)throws SQLException, RecordNotFoundException;
}

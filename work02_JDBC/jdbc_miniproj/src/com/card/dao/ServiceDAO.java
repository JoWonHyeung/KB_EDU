package com.card.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import com.card.vo.Purchase;

public interface ServiceDAO {
	void buy(String ssn, String cardId,String companyName, String category, int price, String date)  throws SQLException; //결제
    ArrayList<Purchase> getPurchase(String ssn) throws SQLException;
    ArrayList<Purchase> getPurchaseCompanyDetails(String companyName, String ssn) throws SQLException; //세부 회사 내역(모든 이력)
    Map<String, Integer> getPurchaseByCompany(String ssn) throws SQLException; //
    Map<String, Integer> getPurchaseByPeriod(String ssn) throws SQLException;//기간별 분석
    Map<String, Integer> getPurchaseByCategory(String ssn) throws SQLException; //카테고리별 소비 분석
	ArrayList<Purchase> getPurchaseByFiltering(String companyName,String ssn, int criteria, boolean flag) throws SQLException; //필터
	int getTotalAmount(String ssn) throws SQLException; //총합계
	void getGrade(String companyName, String ssn, String name) throws SQLException; //해당 사용자의 등급 산출
	void printAlgorithm() throws SQLException; 		
	ArrayList<Purchase> getPurchase() throws SQLException;						//모든 사용자의 구매이력
}
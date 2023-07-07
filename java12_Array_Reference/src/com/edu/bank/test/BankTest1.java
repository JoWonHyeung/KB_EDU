package com.edu.bank.test;

import com.edu.bank.Account;
import com.edu.bank.Customer;

public class BankTest1 {

	public static void main(String[] args) {
		/*
		 1. Account타입의 배열을 생성
		 	111, 국민은행, 12만원
		 	222, 신한은행, 340만원
		 	333, 하나은행, 9
		 2. 김국민 이라는 고객이 1번에서 생성된 배열을 가짐
		 	김국민에게는 국민은행, 신한은행, 하나은행 통장을 개설...
		 3. 반복문을 사용해서 김국민이 개설한 통장의 정보를 출력
		 */
		
		Account[] accounts = {
				new Account(111,120000.0,"국민은행"),
				new Account(222,3400000.0,"신한은행"),
				new Account(333,90000.0,"하나은행")
		};
		
		Customer cust = new Customer("kimgukmin",1);
		cust.setAccounts(accounts);
		
		for(Account account : cust.getAccounts()) 
			System.out.println(account);
		
		System.out.println("===============================");
		
		//1. 김국민이 개설한 통장중에서 국민은행 통장을 찾아서 
		//	 해당 통장의 잔액을 출금..
		for(Account account : cust.getAccounts()) {
			if(account.getBankName().equals("국민은행"))
				System.out.println(account.getBalance());;
		}
		
		//2. 김국민이 개설한 통장의 모든 잔액의 총합을 출력
		double totalBalance = 0;
		for(Account account : cust.getAccounts()) 
			totalBalance += account.getBalance();
		System.out.println(totalBalance);
		
		//3. 김국민이 개설한 통장중에서 가장 많은 잔액이 들어있는 
		//	 통장의 이름과 해당 잔액을 출금
		double balance = Integer.MIN_VALUE;
		String bankName = "";
		
		for(Account account : cust.getAccounts()) {
			if(balance < account.getBalance()) {
				balance = account.getBalance();
				bankName = account.getBankName();
			}
		}
		System.out.println(bankName + "," + balance);
		
	}

}

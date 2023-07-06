package com.edu.bank;

public class BankAppTest {

	public static void main(String[] args) {
		//1,2번
		Customer dongeun = new Customer("동은",1,new Account(111,100000,"kb1"));
		Customer jisu = new Customer("지수",2,new Account(222,200000,"kb2"));
	
		//3번
		Account kb1 = dongeun.getAccount();
		Account kb2 = jisu.getAccount();
		
		kb1.deposit(100000);
		kb1.withdrawl(20000);
		
		kb2.deposit(100000);
		kb2.withdrawl(30000);
		
		//4번
		System.out.println("동은 남은 통장 잔고 : " + kb1.getBalance());
		System.out.println("지수 남은 통장 잔고 : " + kb2.getBalance());
		
		//Test
		System.out.println("동은 모든 정보 : " + dongeun.getCustomerInfo());
		System.out.println("지수 모든 정보 : " + jisu.getCustomerInfo());
	}

}

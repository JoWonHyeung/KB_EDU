package com.edu.bank;

//제어문 추가
/*
 1. 입금(deposit..)시 1천원 이상의 금액만 입금 / 
    "입금액은 1천원~"..다시 되돌린다. return
 2. 출금(withdraw..)시 잔액보다 더 큰 금액은 출금이 안되도록 /
    "출금액이 잔액보다~~"..다시 되돌린다. return 
 */
public class Account {
	private int accNumber;
	private double balance;
	private String bankName;
	
	public Account() {} //기본 생성자 항상 넣어줄 것
	public Account(int accNumber, double balance, String bankName) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.bankName = bankName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	//나머지 기능을 추가...입금/출금...제어문
	public void deposit(double amt) {
		if(amt >= 1000.0) { 
			balance += amt;
		}else {
			System.out.println("임금액은 1천원 이상으로 입금 바랍니다.");
			return;
		}
	}
	
	public void withdrawl(double amt) {
		if(amt <= balance) {
			balance -= amt;
		}
		else { 
			System.out.println("출금액이 기존 잔액보다 많습니다.");
			return;
		}
	}
	
	public String getBankName() {
		return bankName;
	}

	//필드값 리턴
	@Override
	public String toString() {
		return accNumber + "-" 
		+ balance + "-"
		+ bankName;
	}
}

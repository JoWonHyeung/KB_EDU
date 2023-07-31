package com.edu.bank;

public class Account {
	public int accNumber;
	public double balance;
	public String bankName;
	
	public Account(int accNumber, double balance, String bankName) {
		this.accNumber = accNumber;
		this.balance = balance;
		this.bankName = bankName;
	}
	
	public String getAccountInfo() {
		return accNumber + "\t" 
				+ balance + "\t"
				+ bankName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amt) {
		balance += amt;
	}
	
	public void withdrawl(double amt) {
		balance -= amt;
	}
	
	public String getBankName() {
		return bankName;
	}

}

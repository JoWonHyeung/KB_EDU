package com.edu.bank;


public class Customer {
	public String custName;
	public int ssn;
	public Account account;
	
	public Customer(String custName, int ssn, Account account) {
		this.custName = custName;
		this.ssn = ssn;
		this.account = account;
	}
	
	
	public String getCustomerInfo() {
		return custName + "\t "
				+ ssn + "\t "
				+ account.getAccountInfo();
	}
	
	public Account getAccount() {
		return account;
	}
	
	public String getName() {
		return custName;
	}
	
	//기능 추가
	public void changeCustName(String custName) {
		this.custName = custName;
	}
	
}

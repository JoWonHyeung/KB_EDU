package com.edu.bank;

public class Customer {
	private String custName;
	private int ssn;
	
	private Account[] accounts;//선언만으로 주입이 이뤄지진 않는다.
	
	public Customer() {}
	public Customer(String custName, int ssn) {
		this.custName = custName;
		this.ssn = ssn;
	}
	
	public String getCustomerInfo() {
		return custName + "-" + ssn + "-";
	}
	
	public void setAccounts(Account[] accounts) {
		this.accounts = accounts;
	}
	
	public Account[] getAccounts() {
		return accounts;
	}
	
	public String getName() {
		return custName;
	}
	
}

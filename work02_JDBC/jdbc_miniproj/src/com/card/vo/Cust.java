package com.card.vo;

import java.util.ArrayList;

public class Cust {
	private String ssn; 		/* ssn */
	private String custName; 	/* cust_name */
	private String custAddress; /* cust_address */
	private String phone;		/* phone */
	
	ArrayList<Purchase> purchaseHistory;
	

	public Cust(String ssn, String custName, String custAddress, String phone) {
		super();
		this.ssn = ssn;
		this.custName = custName;
		this.custAddress = custAddress;
		this.phone = phone;
	}

	public String getSsn() {
		return ssn;
	}

	public void setSsn(String ssn) {
		this.ssn = ssn;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getCustAddress() {
		return custAddress;
	}

	public void setCustAddress(String custAddress) {
		this.custAddress = custAddress;
	}

	public ArrayList<Purchase> getPurchaseHistory() {
		return purchaseHistory;
	}

	public void setPurchaseHistory(ArrayList<Purchase> purchaseHistory) {
		this.purchaseHistory = purchaseHistory;
	}

	public String getPhone() {
		return phone;
	}
	
	
}

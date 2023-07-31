package com.edu.bank;

public class Customer {
	private String name;
	private int rrn; //ÁÖ¹Î¹øÈ£
	private Account account;
	private Address address;
	
	public Customer() {
		name = "";
	}
	
	public Customer(String name, int rrn, int zipCode, String region, String city) {
		super();
		this.name = name;
		this.rrn = rrn;
		this.address = new Address(zipCode, region, city);
	}
	
	public String getName() {
		return name;
	}
	
	public int getRrn() {
		return rrn;
	}
	
	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return name + "\t" + rrn + "\t" + address;
	}
	
}

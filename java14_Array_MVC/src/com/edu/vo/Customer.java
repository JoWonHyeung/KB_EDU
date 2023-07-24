package com.edu.vo;

import java.util.Arrays;

public class Customer {
	private int ssn;
	private String name;
	private String address;
	
	private Product[] products; //Hasing관계에서는 setter주입을 많이 한다.

	public Customer() {}
	public Customer(int ssn, String name, String address) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
	}

	public Product[] getProducts() {
		return products;
	}

	public void buyProducts(Product[] products) {
		this.products = products;
	}
	
	public int getSsn() {
		return ssn;
	}
	
	public String getName() {
		return name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void changeAddress(String address) {
		this.address = address;
	}
	
	public String getCustmerInfo() {
		return name + "," + address;
	}
	@Override
	public String toString() {
		return "Customer [ssn=" + ssn + ", name=" + name + ", address=" + address + ", products="
				+ Arrays.toString(products) + "]";
	}
	
	
}

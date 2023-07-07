package com.edu.bank;

public class Bank {
	public static final int MAX_CUSTOMERS = 100;
	public Customer[] customers;
	public int numberOfCustomers;
	
	public Bank() {
		customers =new Customer[MAX_CUSTOMERS];
		numberOfCustomers = 0;
	}
	
	public void addCustomer(String name, int rrn, int zipCode, String region, String city) {
		if(numberOfCustomers ==  MAX_CUSTOMERS) {
			System.out.println("���̻� ȸ���� ����� �� �����ϴ�.");
			return;
		}
		customers[numberOfCustomers++] =  new Customer(name, rrn, zipCode, region, city);
	}
	
	public Customer getCustomer(int rrn) {
		for(int i=0; i<numberOfCustomers; i++) {
			if(customers[i].getRrn() == rrn) {
				return customers[i];
			}
		}
		
		return new Customer();
	}
	
	public void showAll() {
		if(numberOfCustomers == 0) {
			System.out.println("ȸ���� �ƹ��� �����ϴ�.");
			return;
		}
		for(int i=0; i<numberOfCustomers; i++) {
			System.out.println(customers[i]);
		}
	}
}

package com.edu.bank;

public class Address {
	private int zipCode; //�����ȣ
	private String region; // ��
	private String city; //�����̸�
	
	public Address(int zipCode, String region, String city) {
		this.zipCode = zipCode;
		this.region = region;
		this.city = city;
	}
	
	@Override
	public String toString() {
		return zipCode + ") " + region + " " + city;
	}
}


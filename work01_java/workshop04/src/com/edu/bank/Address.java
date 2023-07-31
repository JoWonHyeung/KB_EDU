package com.edu.bank;

public class Address {
	private int zipCode; //우편번호
	private String region; // 도
	private String city; //도시이름
	
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


package com.edu.domain;

public abstract class Person {
	private int ssn;//
	private String name;
	private String address;
	private String str;
	private int age;	

	public Person(){}
	public Person(int ssn, String name, String address, int age) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.age = age;
		this.str = "NaN";
	}
	
	public Person(int ssn, String name, String address, String str, int age) {
		this(ssn,name,address,age);
		this.str = str;
	}
	
	public int getSsn() {
		return ssn;
	}
	
	public String getStr() {
		return str;
	}
	
	public void setStr(String str) {
		this.str = str;
	}
	
	public void setSsn(int ssn) {
		this.ssn = ssn;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	@Override
	public String toString() {
		return "Person [ssn=" + ssn + ", name=" + name + ", address=" + address + ", str=" + str + ", age=" + age + "]";
	}
	
	

}

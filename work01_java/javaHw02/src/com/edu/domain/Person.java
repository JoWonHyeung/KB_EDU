package com.edu.domain;

public abstract class Person {
	private int ssn;//
	private String name;
	private String address;
	private int age;	

	public Person(){}
	public Person(int ssn, String name, String address, int age) {
		super();
		this.ssn = ssn;
		this.name = name;
		this.address = address;
		this.age = age;
	}
	public int getSsn() {
		return ssn;
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
		return "Person [tel=" + ssn + ", name=" + name + ", address=" + address
				+ ", age=" + age + "]";
	}

}

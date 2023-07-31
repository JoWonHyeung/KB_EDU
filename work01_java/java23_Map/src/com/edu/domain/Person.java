package com.edu.domain;

public abstract class Person { //abstract : cannot not instantiate 미완성된(추상된) 부분이 하나라도 있으면 객체생성 대상에서 제외된다. 메모리에 안올라겟다. 슈퍼급에서만 쓴다.
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

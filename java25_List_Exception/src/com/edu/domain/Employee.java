package com.edu.domain;

public class Employee extends Person{
	private String dept;
	
	public Employee(){}

	public Employee(int ssn, String name, int age,String address,String dept) {
		super(ssn,name,address,age);
		this.dept = dept;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	@Override
	public String toString() {
		return "Employee [subject=" + dept + "] "+super.toString();
	}
	
}

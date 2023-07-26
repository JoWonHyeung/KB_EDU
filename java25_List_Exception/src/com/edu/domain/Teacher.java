package com.edu.domain;

public class Teacher extends Person{
	private String subject;
	
	public Teacher(){}

	public Teacher(int ssn, String name, int age,String address,String subject) {
		super(ssn,name,address,age);
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Override
	public String toString() {
		return "Teacher [subject=" + subject + "] "+super.toString();
	}
	
}


package com.edu.domain;

public class Student extends Person{
	private String stuId;

	public Student(){}
	public Student(int ssn, String name, int age,String address,String stuId) {
		super(ssn,name,address,age);
		this.stuId = stuId;
	}
	public String getStuId() {
		return stuId;
	}
	public void setStuId(String stuId) {
		this.stuId = stuId;
	}
	@Override
	public String toString() {
		return "Student [stuId=" + stuId + "] "+super.toString();
	}
	
}

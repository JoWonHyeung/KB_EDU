package com.self.vo;

import com.self.util.MyDate;

public class Manager {
	private String name;
	private MyDate birthDate;
	private double salary;
	private String dept;
	private int deptno;
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super();
		this.name = name;
		this.birthDate = birthDate;
		this.salary = salary;
		this.dept = dept;
		this.deptno = deptno;
	}	
	public String getName() {
		return name;
	}
	
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public double getSalary() {
		return salary;
	}
	public String getDept() {
		return dept;
	}
	public int getDeptno() {
		return deptno;
	}
	public String getDetails() {
		return name+","+birthDate.toString()+","+salary+","+dept+","+deptno;
	}
}







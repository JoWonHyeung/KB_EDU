package com.self.vo;

import com.self.util.MyDate;

public class Manager extends Employee{
	private String dept;
	private int deptno;
	
	public Manager(String name, MyDate birthDate, double salary, String dept, int deptno) {
		super(name, salary, birthDate);
		this.dept = dept;
		this.deptno = deptno;
	}	
	
	public Manager(double salary, String dept, int deptno, String name) {
		super(name, salary, new MyDate(1990,1,1));
		this.dept = dept;
		this.deptno = deptno;
	}
	
	public String getDept() {
		return dept;
	}
	
	public void setDept(String dept) {
		this.dept = dept;
	}

	public int getDeptno() {
		return deptno;
	}
	
	public void setDeptno(int deptno) {
		this.deptno = deptno;
	}

	@Override
	public String toString() {
		return super.toString() + " , " + super.getBirthDate() + " , " + dept + " , " + deptno;
	}
}







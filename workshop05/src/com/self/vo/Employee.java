package com.self.vo;

import com.self.util.MyDate;

public class Employee {
	public String name;
	public double salary;
	private MyDate birthDate;
	
	public Employee() {}
	public Employee(String name, double salary, MyDate birthDay) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDay;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public double getSalary() {
		return salary;
	}
	
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public MyDate getBirthDate() {
		return birthDate;
	}
	
	public void setBirthDate(MyDate birthDate) {
		this.birthDate = birthDate;
	}
	
	@Override
	public String toString() {
		return name + " , " + salary;
	}
	
	
	
}

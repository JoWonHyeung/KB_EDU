package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest2 {

	public static void main(String[] args) {
		/*
		Employee m = new Manager("James", new MyDate(1990,1,1), 400000.0, "IT");
		Employee e = new Engineer("Jones", new MyDate(1997,1,3), 30000.0, "Java", 5000.0);
		Employee s = new Secretary("Kim", new MyDate(1993,2,3),50000.0, "Jin");
		*/
		
		Employee[] emps = {
			new Manager("James", new MyDate(1990,1,1), 400000.0, "IT"),
			new Engineer("Jones", new MyDate(1997,1,3), 30000.0, "Java", 5000.0),
			new Secretary("Kim", new MyDate(1993,2,3),50000.0, "Jin"),
			new Engineer("Adams", new MyDate(1994,7,3), 15000.0, "Python", 3000.0),
		};
		
		System.out.println("========= 정보를 출력합니다 ==========");
		for(Employee e : emps)
			System.out.println(e);
		
		System.out.println("\n========= 직원들의 연봉 정보를 출력합니다 ==========");
		double annualSalary = 0.0;
		for(Employee e : emps) {
			if(e instanceof Engineer) {
				annualSalary = e.getSalary() * 12 + ((Engineer) e).getBonus();
				System.out.println(e.getName() + "님의 연봉, " + annualSalary);
			}else {
				annualSalary = e.getSalary() * 12;
				System.out.println(e.getName() + "님의 연봉, " + annualSalary);
			}
		}
		
		
		
	}

}

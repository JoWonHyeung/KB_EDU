package com.edu.domain.test;

import com.edu.domain.Employee;
import com.edu.util.MyDate;

public class EmployeeTest {

	public static void main(String[] args) {
		Employee emp1 = new Employee("James", new MyDate(2000,1,1));
		Employee emp2 = new Employee("James", 3400000.0, new MyDate(1990,2,14));
		Employee emp3 = new Employee("James", 6700000.0, new MyDate(1991,3,15));
		
		Employee[] emps = {emp1,emp2,emp3};
		
		for(Employee emp : emps)
			System.out.println(emp);
	}

}

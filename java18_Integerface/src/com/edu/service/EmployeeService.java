package com.edu.service;

import com.edu.parent.Employee;

//인터페이스 : 사용자와 벤더사 사이의 강력한 Contract~~!!..규약
public interface EmployeeService {
	void printAllEmployee(Employee[] emps);
	public Employee findEmployee(Employee[] emps, String name);
	Employee[] findEmployeeByDept(Employee[] emps, String dept);
	double getAnnualSalary(Employee e);
	public double getTotalCost(Employee[] ea);
}


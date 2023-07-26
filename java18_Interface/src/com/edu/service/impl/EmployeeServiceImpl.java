package com.edu.service.impl;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;

public class EmployeeServiceImpl implements EmployeeService {

	//(1)
	static private EmployeeServiceImpl service = new EmployeeServiceImpl();
	
	//(2)
	private EmployeeServiceImpl() {
		System.out.println("Client Request Ready...");
	}
	
	//(3)
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	
	
	//1. 모든 직원의 정보를 출력하는 기능...일단 선언부만 작성 / 구현부는 나중에
	public void printAllEmployee(Employee[] emps) {
		for(Employee e : emps)
			System.out.println(e);
	}
	
	//2. 모든 직원 중 특정한 직원을 검색하는 기능을 정의
	// find~~, search~~
	public Employee findEmployee(Employee[] emps, String name) {
		Employee employee = null;
		for(Employee emp : emps) {
			if(emp.getName().equals(name)) {
				employee = emp;
				break;
			}
		}
		return employee;
	}
	
	//3. 모든 직원중에서 동일한 부서에서 일하는 직원들을 검색
	public Employee[] findEmployeeByDept(Employee[] emps, String dept) {
		Employee[] temp = new Employee[emps.length];
		int idx = 0;
		for(Employee emp : emps) {
			if(emp instanceof Manager && ((Manager) emp).getDept().equals(dept)) {
				temp[idx++] = emp;
			}
		}
		
		return temp;
	}
	
	//4. 특정한 직원의 연봉을 리턴하는 기능
	public double getAnnualSalary(Employee e) {
		double annualSalary = 0;
		if(e instanceof Engineer)
			annualSalary = e.getSalary() * 12 + ((Engineer) e).getBonus();
		else
			annualSalary = e.getSalary() * 12;
		
		return annualSalary;
	}
	
	//5. 모든 직원의 총 인건비를 리턴
	public double getTotalCost(Employee[] ea) {
		double total = 0;
		for(Employee e : ea)
			total += getAnnualSalary(e);
		
		return total;
	}

}

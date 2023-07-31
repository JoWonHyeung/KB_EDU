package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public interface EmployeeService {
	void addEmployee(Employee e);
	void deleteEmployee(String name);
	void updateEmployee(Manager m);
	void updateEmployee(Engineer eg);
	Employee findEmployeeByName(String name);
	Employee[] getBirthDayMoreThan(int year);
	Employee[] findManagerByDeptno(int deptno);
	void printManagers();
	void printEngineers();
	double getAnnualSalary(Employee e);
	double getTotalCost();
}

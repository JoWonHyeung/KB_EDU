package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.service.EmployeeService;
import com.edu.service.impl.EmployeeServiceImpl;
import com.edu.util.MyDate;

public class PolyTest3 {

	public static void main(String[] args) {
		/*
		Employee m = new Manager("James", new MyDate(1990,1,1), 400000.0, "IT");
		Employee e = new Engineer("Jones", new MyDate(1997,1,3), 30000.0, "Java", 5000.0);
		Employee s = new Secretary("Kim", new MyDate(1993,2,3),50000.0, "Jin");
		*/
		
		Employee[] emps = {
			new Manager("James", new MyDate(1990,1,1), 400000.0, "IT"),
			new Engineer("Jones", new MyDate(1997,1,3), 48000.0, "Java", 100.0),
			new Secretary("Kim", new MyDate(1993,2,3),35000.0, "Jin"),
			new Engineer("Adams", new MyDate(1994,7,3), 58000.0, "Python", 3000.0),
			new Manager("Jane", new MyDate(1998,3,4), 65000.0, "IT")
		};
		
		//Service객체 생성 == 메모리에 기능들을 로딩시킴
		EmployeeService service = new EmployeeServiceImpl();
		
		//-----서비스 기능을 호출------
		
		System.out.println("\n====1. 직원 정보를 출력합니다.====");
		//
		service.printAllEmployee(emps);
		
		System.out.println("\n====2. 특정 직원을 검색 ====");
		//
		System.out.println(service.findEmployee(emps, "James"));
		
		System.out.println("\n====3. 동일한 부서의 직원을 검색 =====");
		//
		for(Employee e : service.findEmployeeByDept(emps, "IT"))
			if(e != null)
				System.out.println(e);
		
		System.out.println("\n====4. 특정 직원의 연봉을 검색 =====");
		//
		System.out.println(service.getAnnualSalary(emps[1]));
		System.out.println(service.getAnnualSalary(emps[0]));
		
		
		System.out.println("\n====5. 직원의 총 인건비를 검색 =====");
		//
		System.out.println(service.getTotalCost(emps));
		

	}

}

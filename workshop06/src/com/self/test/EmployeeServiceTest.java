package com.self.test;

import java.util.ArrayList;

import com.self.service.EmployeeService;
import com.self.service.impl.EmployeeServiceImpl;
import com.self.util.MyDate;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service 객체를 생성
		EmployeeService service = EmployeeServiceImpl.getInstance();
		
		//2. method를 각각 호출..
		System.out.println("============ 1. addManager ============ ");
		service.addEmployee(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "개발부", 10));
		service.addEmployee(new Manager("BBB", new MyDate(1975, 2, 1), 34000.0, "기획부", 20));
		service.addEmployee(new Manager("CCC", new MyDate(1980, 3, 3), 20000.0, "교육부", 30));
		service.addEmployee(new Manager("DDD", new MyDate(1995, 8, 1), 37000.0, "개발부", 10));
		
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		
		System.out.println("\n============ 1. addEngineer ============ ");
		service.addEmployee(new Engineer("EEE", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEmployee(new Engineer("FFF", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEmployee(new Engineer("GGG", new MyDate(1994,11,2), 450000.0, "Python", 300.0));
		
		System.out.println("============ Engineer 정보확인 ============ ");
		service.printEngineers();
		
		System.out.println("\n============ 2. deleteManager(AAA 삭제) ============ ");
		service.deleteEmployee("AAA");
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		
		System.out.println("\n============ 3. updateManager(CCC 연봉 수정 200->350) ============ ");
		service.updateEmployee(new Manager(35000.0, "교육부", 30,  "CCC"));//?
		System.out.println("============ Manager 정보확인 ============ ");
		service.printManagers();
		
		System.out.println("\n============ 4. updateEngineer(FFF 연봉 수정 3500->6000) ============ ");
		service.updateEmployee(new Engineer("FFF", new MyDate(1995,7,2), 600000.0, "Java", 200.0));//?
		System.out.println("============ Manager 정보확인 ============ ");
		service.printEngineers();
		
		System.out.println("\n============ 4. findManager(BBB) ============ ");
		Employee retM1= service.findEmployeeByName("BBB");
		System.out.println(retM1);
		
		System.out.println("\n============ 5. findManager(10) ============ ");
		System.out.println("10번 부서에 근무하는 직원들 입니다..");
		ArrayList<Employee> retMs1 = service.findManagerByDeptno(10);
		for(Employee e : retMs1) {
			if(e == null) continue;
			System.out.println(e);
		}
		
		System.out.println("\n=========== 6. getTotalCost =============");
		System.out.println(service.getTotalCost());
		
		System.out.println("\n=========== 7. getBirthDayMoreThan =============");
		for(Employee e : service.getBirthDayMoreThan(1995)) {
			if(e == null) continue;
			System.out.println(e);
		}
		
	}
}








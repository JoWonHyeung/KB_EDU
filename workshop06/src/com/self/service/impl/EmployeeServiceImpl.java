package com.self.service.impl;

import java.util.ArrayList;

import com.self.service.EmployeeService;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;


public class EmployeeServiceImpl implements EmployeeService {
	
	static final EmployeeServiceImpl service = new EmployeeServiceImpl(100);
	
	ArrayList<Employee> list;

	private EmployeeServiceImpl(int size){
		list = new ArrayList<>();
	}
	
	public static EmployeeServiceImpl getInstance() {
		return service;
	}
	
	//직원 추가
	@Override
	public void addEmployee(Employee e) {
		boolean find = false;
		
		for(Employee emp : list) {
			if(emp.getName().equals(e.getName())) {
				find = true;
				System.out.println("이름 같은 사람이 존재합니다.");
				return;
			}
		}
			
		if(find == false) {
			list.add(e);
			System.out.println(e.getName() + " 님이 회원등록 성공");
		}
		
	}
	
	//직원 삭제
	@Override
	public void deleteEmployee(String name) {	
		boolean find = false;
		
		for(Employee e : list) {
			if(e.getName().equals(name)) {
				find = true;
				System.out.println(e.getName() + "님, 삭제완료");
				list.remove(e);
				break;
			}
		}
		
		if(find == false) System.out.println("삭제 대상이 존재하지 않습니다.");
	}
	
	//직원 정보 업데이트(Manger)
	@Override
	public void updateEmployee(Manager m) {	
		for(Employee e : list) {	
			if(e==null) continue;
			if(e instanceof Manager && ((Manager) e).getName().equals(m.getName())) {
				e.setSalary(m.getSalary());
				((Manager) e).setDept(m.getDept());	
				((Manager) e).setDeptno(m.getDeptno());				
			}
		}
	}
	
	//직원 정보 업데이트(Engineer)
	@Override
	public void updateEmployee(Engineer eg) {	
		for(Employee e : list) {
			if(e == null) continue;
			if(e instanceof Engineer && ((Employee) e).getName().equals(eg.getName())) {
				e.setSalary(eg.getSalary());
				((Engineer) e).setBirthDate(eg.getBirthDate());
				((Engineer) e).setBonus(eg.getBonus());
				((Engineer) e).setTech(eg.getTech());
			}
		}
	}	
	
	//이름으로 직원 정보 검색
	@Override
	public Employee findEmployeeByName(String name) {
		Employee temp = null;
		for(Employee e : list) {
			if(e == null) continue;			
			if(e.getName().equals(name)) {
				temp = e;
				break;
			}
		}
		return temp;
	}
	
	//Manager 정보에서 deptno로 직원 정보 검색
	@Override
	public ArrayList<Employee> findManagerByDeptno(int deptno) {
		ArrayList<Employee> temp = new ArrayList<>();
		for(Employee e : list) {
			if(e == null) continue;
			if(e instanceof Manager && ((Manager) e).getDeptno()==deptno) temp.add(e);
		}
		return temp;
	}
	
	//Manager 정보 출력
	@Override
	public void printManagers() {		
		for(Employee e : list) {
			if(e == null) continue;
			if(e instanceof Manager) System.out.println(e);
		}
	}
	
	//Engineer 정보 출력
	@Override
	public void printEngineers() {
		for(Employee e : list) {
			if(e == null) continue;
			if(e instanceof Engineer) System.out.println(e);
		}
	}
	
	//직원 연봉 반환
	@Override
	public double getAnnualSalary(Employee e) {
		double annualSalary = 0;
		
		if(e instanceof Engineer) annualSalary = e.getSalary() * 12 + ((Engineer) e).getBonus();
		else annualSalary = e.getSalary() * 12;
		
		return annualSalary;
	}

	//총 직원 연봉 반환
	@Override
	public double getTotalCost() {
		double total = 0;
		
		for(Employee e : list) {
			if(e == null) continue;
			total += getAnnualSalary(e);
		}
		
		return total;
	}


	//특정년도부터 태어난 출생자들을 반환
	@Override
	public ArrayList<Employee> getBirthDayMoreThan(int year) {
		ArrayList<Employee> temp = new ArrayList<>();
		
		for(Employee e : list) {
			if(e == null) continue;
			if(year <= e.getBirthDate().getYear()) temp.add(e);
		}
		
		return temp;
	}
	
	
}


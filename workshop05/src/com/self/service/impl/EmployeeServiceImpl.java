package com.self.service.impl;

import com.self.service.EmployeeService;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceImpl implements EmployeeService {
	Employee[] emps;
	int idx;

	public EmployeeServiceImpl(int size){
		emps = new Employee[size];
	}
	
	
	//직원 추가
	@Override
	public void addEmployee(Employee e) {	
		emps[idx++] = e;
	}
	
	//직원 삭제
	@Override
	public void deleteEmployee(String name) {	
		for(int i=0; i<idx; i++) {
			if(emps[i].getName().equals(name)) {
				for(int j=i; j<idx; j++) {
					emps[j] = emps[j+1];
				}
				emps[idx] = null;
				idx--;
			}
		}
	}
	
	//직원 정보 업데이트(Manger)
	@Override
	public void updateEmployee(Manager m) {	
		for(Employee e : emps) {	
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
		for(Employee e : emps) {
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
		for(Employee e : emps) {
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
	public Employee[] findManagerByDeptno(int deptno) {
		Employee[] temp = new Employee[emps.length];
		int count = 0;
		for(Employee e : emps) {
			if(e == null) continue;
			if(e instanceof Manager && ((Manager) e).getDeptno()==deptno) {
				temp[count++] = e;
			}
		}
		return temp;
	}
	
	//Manager 정보 출력
	@Override
	public void printManagers() {		
		for(Employee e : emps) {
			if(e == null) continue;
			if(e instanceof Manager) {
				System.out.println(e);
			}
		}
	}
	
	//Engineer 정보 출력
	@Override
	public void printEngineers() {
		for(Employee e : emps) {
			if(e == null) continue;
			if(e instanceof Engineer) {
				System.out.println(e);
			}
		}
	}
	
	//직원 연봉 반환
	@Override
	public double getAnnualSalary(Employee e) {
		double annualSalary = 0;
		if(e instanceof Engineer)
			annualSalary = e.getSalary() * 12 + ((Engineer) e).getBonus();
		else
			annualSalary = e.getSalary() * 12;

		return annualSalary;
	}

	//총 직원 연봉 반환
	@Override
	public double getTotalCost() {
		double total = 0;
		for(Employee e : emps) {
			if(e == null) continue;
			total += getAnnualSalary(e);
		}
		
		return total;
	}


	//특정년도부터 태어난 출생자들을 반환
	@Override
	public Employee[] getBirthDayMoreThan(int year) {
		Employee[] temp = new Employee[emps.length];
//		int count = 0;
//		for(Employee e : emps) {
//			if(e == null) continue;
//			if(year <= e.get) temp[count++] = e;
//		}
//		
		return temp;
	}
	
	
	
}


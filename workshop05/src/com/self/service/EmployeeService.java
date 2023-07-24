package com.self.service;

import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeService {
	Manager[ ] ms;
	int midx;
	
	Engineer[ ] egs;
	int egidx;	

	public EmployeeService(int size){
		ms = new Manager[size];
		egs = new Engineer[size];
	}
	public void addManager(Manager m) {	
		ms[midx++] = m;
	}
	public void addEngineer(Engineer eg) {	
		egs[egidx++] = eg;
	}
	public void deleteManager(String name) {	
		for(int i=0; i<midx; i++) {
			if(ms[i].getName().equals(name)) {
				for(int j=i; j<midx; j++) {
					ms[j] = ms[j+1];
				}
				ms[midx] = null;
				midx--;
			}
		}
	}
	public void deleteEngineer(String name) {
		for(int i=0; i<egidx; i++) {
			if(egs[i].getName().equals(name)) {
				for(int j=i; j<egidx; j++) {
					egs[j] = egs[j+1];
				}
				egs[egidx] = null;
				egidx--;
			}
		}
	}
	public void updateManager(double salary, String dept,int deptno,  String name) {	
		for(Manager manager : ms) {	
			if(manager==null) continue;
			if(manager.getName().equals(name)) {
				manager.setSalary(salary);
				manager.setDept(dept);	
				manager.setDeptno(deptno);				
			}			
		}
	}
	public void updateEngineer(Engineer eg) {	
		for(Engineer engineer : egs) {
			if(engineer==null) continue;
			if(engineer.getName().equals(eg.getName())) {
				engineer.setBirthDate(eg.getBirthDate());
				engineer.setBonus(eg.getBonus());
				engineer.setSalary(eg.getSalary());
				engineer.setTech(eg.getTech());
			}
		}
	}	
	//Method Overloading
	/*
	 * 하는일은 똑같은데...처리하는 데이타를 달리할때 쓰는 기법
	 * 메소드의 통일감을 강조하면서도 서로다른 데이타를 처리할수 있게끔 해준다.
	 */
	public Manager findManager(String name) {
		Manager m = null;
		for(Manager manager : ms) {
			if(manager==null) continue;			
			if(manager.getName().equals(name))
				m = manager;
		}
		return m;
	}
	public Manager[ ] findManager(int deptno) {
		Manager[ ] temp = new Manager[ms.length];
		int count = 0;
		for(Manager manager : ms) {
			if(manager==null) continue;
			if(manager.getDeptno()==deptno) {
				temp[count++] = manager;
			}
		}
		return temp;
	}
	public Engineer findEngineer(String name) {
		Engineer eg = null;
		
		return eg;
	}	
	//추가
	public void printManagers() {		
		for(Manager m : ms) {
			if(m!=null)
			System.out.println(m.getDetails());
		}
	}
	public void printEngineers() {
		for(Engineer e : egs) {
			if(e!=null)
			System.out.println(e.getDetails());
		}
	}
}


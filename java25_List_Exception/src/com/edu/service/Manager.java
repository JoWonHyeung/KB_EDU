package com.edu.service;

import java.util.ArrayList;

import com.edu.domain.Employee;
import com.edu.domain.Person;
import com.edu.domain.Student;
import com.edu.domain.Teacher;
import com.edu.exception.DuplicateSSNException;
import com.edu.exception.RecordNotFoundException;

public class Manager {
	
	private ArrayList<Person> list;
	
	public Manager(int size){
		list = new ArrayList<>();
	}
	public void getPersons(){
		for(Person p : list) {
			System.out.println(p);
		}
	}	
	
	public void addPerson(Person person) throws DuplicateSSNException{		
		//추가하려는 사람이 없을때만 추가되도록 작성
		boolean find = false;
		for(Person p : list) {
			if(p.getSsn() == person.getSsn()) {
				find = true;
				throw new DuplicateSSNException("그런 사람 이미 있어요...");
			}
		}
		
		if(find == false) {
			list.add(person);
			System.out.println(person.getName() + " 님이 회원등록 성공!!");
		}
		
	}
	
	public void deletePerson(int ssn) throws RecordNotFoundException{
		//삭제하려는 대상이 있을때에만 삭제가 되도록 작성
		boolean find = false;
		
		for(Person p : list) {
			if(ssn == p.getSsn()) { //삭제 대상이 존재한다면
				find = true;
				System.out.println(p.getName() + "님, 회원 탈퇴!!");
				list.remove(p);
				break;
			}
		}
		
		if(find == false) throw new RecordNotFoundException("그런 사람 찾을 수 없음...");
	}

	public Person findPerson(int ssn){
		Person person = null;
		for(Person p : list) {
			if(p.getSsn() == ssn) person = p;
		}
		
		return person;
	}//

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> temp = new ArrayList<>();
		for(Person p : list) {
			if(p.getAddress().equals(addr)) temp.add(p);
		}
		
		return temp;
	}

	public void updatePerson(String name,int age, String addr, String str,int k){	
		//툭정한 위치에 있는 사람의 정보를 수정함
		//메소드의 인자값을 잘 활용해서 모든 객체의 정보가 수정될수 있도록 로직을 작성
		list.get(k).setName(name);
		list.get(k).setAge(age);
		list.get(k).setAddress(addr);
		if(list.get(k) instanceof Student) 
			((Student) list.get(k)).setStuId(str);
		
		if(list.get(k) instanceof Employee) 
			((Employee) list.get(k)).setDept(str);
		
		if(list.get(k) instanceof Teacher) 
			((Teacher) list.get(k)).setSubject(str);;
		
		
	}
	
}

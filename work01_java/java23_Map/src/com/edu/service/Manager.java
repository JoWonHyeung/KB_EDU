package com.edu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.edu.domain.Person;



public class Manager {
	
	static private Manager manager = new Manager(100);
	private Map<Integer,Person> map;
	
	private Manager(int size){
		map = new HashMap<>();
	}
	
	public static Manager getInstance() {
		return manager;
	}
	
	public void printAllPersonInfo(){
		Set<Integer> set = map.keySet();
		for(int ssn : set) {
			System.out.println(ssn + " PersonInfo : " + map.get(ssn));
		}
	}	
	
	public void addPerson(Person person){		
		if(map.containsKey(person.getSsn())) {
			System.out.println(person.getName() + " 님은 이미 회원입니다.");
			return;
		} else {
			map.put(person.getSsn(), person);
			System.out.println(person.getName() + " 님이 등록되었습니다.");
		}
	}
	
	public void deletePerson(int ssn){
		Person p = map.remove(ssn);
		
		if(p == null) {
			System.out.println("삭제 대상이 존재하지 않습니다.");
		}else {
			System.out.println(p.getName() + " 님 삭제 완료되었습니다.");
		}
		
//		if(map.containsKey(ssn)) {
//			System.out.println(map.get(ssn).getName() + " 님의 회원정보 삭제되었습니다.");
//			map.remove(ssn);
//		}else {
//			System.out.println("회원이 존재하지 않습니다.");
//		}
	}
	
	public Person findPerson(int ssn){
		return map.get(ssn);
	}//

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> temp = new ArrayList<>();
		Set<Integer> set = map.keySet();
		for(int key : set) {
			Person p = map.get(key);
			if(p.getAddress().equals(addr))
				temp.add(p);
		}
		return temp;
	}

	//map 에는 set() 가 별도로 존재하지 않고 / key에 해당하는 값을 다시 put
	public void updatePerson(Person p, int ssn){	
		if(map.containsKey(ssn)) {
			map.put(ssn, p);
			System.out.println("업데이트 완료");
		}else {
			System.out.println("업데이트 불가");
		}
	}
	
}












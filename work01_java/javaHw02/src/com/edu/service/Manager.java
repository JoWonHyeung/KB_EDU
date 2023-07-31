package com.edu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.edu.domain.Person;
import com.edu.exception.DuplicatedPersonException;
import com.edu.exception.SSNNotFoundException;

public class Manager {
	private Map<Integer,Person> map;
	
	public Manager(int size){
		map = new HashMap<>();
	}
	public void printAllPersonInfo(){
		for(int key : map.keySet()) System.out.println(map.get(key));
	}	
	
	public void addPerson(Person person) throws DuplicatedPersonException{		
		if(map.containsKey(person.getSsn())) throw new DuplicatedPersonException();
		map.put(person.getSsn(), person);
	}
	
	public void deletePerson(int ssn) throws SSNNotFoundException{
		if(map.containsKey(ssn)) map.remove(ssn);
		else throw new SSNNotFoundException("저장된 사람이 없어 삭제할 수 없습니다....");
	}
	
	public Person findPerson(int ssn) throws SSNNotFoundException{
		if(map.containsKey(ssn)) return map.get(ssn);
		else throw new SSNNotFoundException("저장된 사람이 존재하지 않습니다....");		
	}

	public ArrayList<Person> findPerson(String addr){
		ArrayList<Person> temp = new ArrayList<>();
		for(int key : map.keySet()) {
			if(map.get(key).getAddress().equals(addr))
				temp.add(map.get(key));
		}
		return temp;
	}

	public void updatePerson(Person p, int ssn) throws SSNNotFoundException{	
		if(map.containsKey(ssn)) {
			map.get(ssn).setAddress(p.getAddress());
			map.get(ssn).setName(p.getName());
			map.get(ssn).setAge(p.getAge());
		}else {
			throw new SSNNotFoundException("저장된 사람이 존재하지 않습니다....");
		}
	}
	
}












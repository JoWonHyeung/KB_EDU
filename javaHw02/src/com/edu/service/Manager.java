package com.edu.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import com.edu.domain.Person;



public class Manager {
	private Map<Integer,Person> map;
	
	
	public Manager(int size){
		map = new HashMap<>();
	}
	public void printAllPersonInfo(){
		//
		
	}	
	
	public void addPerson(Person person){		
		//추가하려는 사람이 있을떄는 추가되지 않도록 작성
		
	}
	
	public void deletePerson(int ssn){
		// 삭제 대상이있을때만 삭제되도록
	}
	
	public Person findPerson(int ssn){
		//
		return null;
	}//

	public ArrayList<Person> findPerson(String addr){
		
		
		return null;
	}

	public void updatePerson(Person p, int ssn){	
		//
		
		
	}
}












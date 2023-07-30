package com.edu.test;

import java.util.ArrayList;

import com.edu.domain.Employee;
import com.edu.domain.Person;
import com.edu.domain.Student;
import com.edu.domain.Teacher;
import com.edu.exception.DuplicatedPersonException;
import com.edu.exception.SSNNotFoundException;
import com.edu.service.Manager;


public class PersonManagerTest {
	public static void main(String[] args) {
		Manager manager = new Manager(50);
		
		Student s1 = new Student(1111, "AAA", 27, "��赿", "aaa111");
		Student s2 = new Student(2222, "BBB", 26, "�Ǳ�", "bbb222");
		Employee e1 = new Employee(3333, "CCC", 43, "���ǵ�", "������");
		Teacher t1 = new Teacher(4444, "DDD", 50, "���¿�", "JAVA");
		Teacher t2 = new Teacher(5555,"EEE",40,"�Ǳ�","I-Phone");
		System.out.println("========================= addPerson() =================================\n");
		
		try {
			manager.addPerson(s1);		
			manager.addPerson(s2);
			manager.addPerson(e1);
			manager.addPerson(t1);
			manager.addPerson(t2);	
		}catch (DuplicatedPersonException e) {
			System.out.println(e.getMessage());
		}
		
//		manager.getPersons();
	
		System.out.println("\n");
		System.out.println("============================ deletePerson() =============================\n");
		
//		manager.deletePerson(4444);	
		
		//manager.getPersons();
	
	
		System.out.println("\n");
		System.out.println("============================= findPerson(int ssn) ===============================\n");
//		Person p = manager.findPerson(5555);
//		System.out.println("findPerson(ssn) :: "+p.getName());
		
		
	
		System.out.println("\n");
		System.out.println("============================= findPerson(String name) ===============================\n");
	
			ArrayList<Person> persons=manager.findPerson("�Ǳ�");
			for(Person p1 : persons){
				if(p1 == null) continue;
				System.out.println(p1);
			}
		
		
			
		System.out.println("\n");
		System.out.println("============================= updatePerson() ==============================");
		System.out.println("------------------ ������ ������ ����� �����ϱ?? ---------------------------------\n");
	
		//manager.updatePerson("AAA", 27, "��浿", "sogangi1", 0);
	
		//manager.getPersons();
			
	}//main
}//class





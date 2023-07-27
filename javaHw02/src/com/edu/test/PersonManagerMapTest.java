package com.edu.test;

import java.util.ArrayList;

import com.edu.domain.Employee;
import com.edu.domain.Person;
import com.edu.domain.Student;
import com.edu.domain.Teacher;
import com.edu.service.Manager;



public class PersonManagerMapTest {
	public static void main(String[] args) {
		Manager manager = new Manager(100);
		
		Student s1 = new Student(1111, "AAA", 27, "서초동", "aaa111");
		Student s2 = new Student(2222, "BBB", 26, "서초동", "bbb222");
		Employee e1 = new Employee(3333, "CCC", 33, "여의도", "연예부");
		Teacher t1 = new Teacher(4444, "DDD", 50, "이태원", "JAVA");
		Teacher t2 = new Teacher(5555,"EEE",40,"서초동","I-Phone");
		System.out.println("========================= addPerson() =================================\n");
		
		
		manager.addPerson(s1);		
		manager.addPerson(s2);
		manager.addPerson(e1);
		manager.addPerson(t1);
			
		manager.printAllPersonInfo();
		
		System.out.println("\n");
		System.out.println("============================ deletePerson() =============================\n");
		manager.deletePerson(4444);	
		manager.printAllPersonInfo();
		

		System.out.println("\n");
		System.out.println("============================= findPerson(int tel) ===============================\n");
	
			Person p = manager.findPerson(1111);
			System.out.println("findPerson(tel) :: "+p);
		
	
		System.out.println("\n");
		System.out.println("============================= findPerson(String address) ===============================\n");
		
			ArrayList<Person> persons=manager.findPerson("서초동");
			for(Person p1 : persons){
				System.out.println(p1);
			}
		
		
		System.out.println("\n");
		System.out.println("============================= updatePerson() ==============================");
		System.out.println("------------------ 정보가 수정된 사람이 누구일까여?? ---------------------------------\n");
		
		manager.updatePerson(new Employee(3333, "박나래", 33, "서초동", "연예부"),3333);
		manager.printAllPersonInfo();			
	}//main
}//class














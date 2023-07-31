package com.edu.sort.test;

import java.util.ArrayList;
import java.util.Collections;

class Person implements Comparable<Person> {
	int age;
	String name;
	
	public int getAge() {
		return age;
	}
	
	public Person(int age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Person [age=" + age + ", name=" + name + "]";
	}

	/*
	 int 리턴타입의 의미
	 ::
	 나이가 작으면 -1
	 나이가 더 많으면 1
	 같으면 0
	 */
	@Override
	public int compareTo(Person per) {
		if(age < per.age) return -1;
		else if(age > per.age) return 1;
		else return 0;
	}
	
}

public class ComparableTest1 {

	public static void main(String[] args) {
		ArrayList<Person> plist = new ArrayList<>();
		plist.add(new Person(68,"이순재"));
		plist.add(new Person(23,"제니"));
		plist.add(new Person(53,"엄정화"));
		
		//Arrays.sort(plist);
		Collections.sort(plist);
		
		for(Person p : plist) System.out.println(p);
		
	}

}

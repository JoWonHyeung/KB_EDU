package com.edu.test;


class Person{
	String name;
	static int counter;
	
	public Person(String name) {
		super();
		this.name = name;
	}
	
}

public class StaticExamTest4 {
	static int counter;
	
	public static void main(String[] args) {
		Person p = new Person("JAMES");
		System.out.println("James Person Creating...Person Instance Initilization...");
		
	}//main
	
	static {
		counter++;
		System.out.println("static initialization block..." + counter);
	}

}

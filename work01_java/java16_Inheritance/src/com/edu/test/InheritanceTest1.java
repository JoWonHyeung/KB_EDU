package com.edu.test;

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.util.MyDate;

public class InheritanceTest1 {

	public static void main(String[] args) {
		
		Manager m = new Manager("James", new MyDate(1990,1,1), 400000.0, "IT");
		Engineer e = new Engineer("Jones", new MyDate(1997,1,3), 30000.0, "Java", 5000.0);
		Secretary s = new Secretary("Kim", new MyDate(1993,2,3),50000.0, "Jin");
		
		System.out.println(m.getDetails());
		System.out.println(e.getDetails());
		System.out.println(s.getDetails());
		
	}

}

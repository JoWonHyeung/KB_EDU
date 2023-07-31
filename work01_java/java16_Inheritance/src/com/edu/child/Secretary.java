package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Secretary extends Employee {
	
	private String bossOfName;

	public Secretary(String name, MyDate birthday, double salary, String bossOfName) {
		super(name, birthday, salary);
		this.bossOfName = bossOfName;
	}

	@Override
	public String getDetails() {
		return super.getDetails() + " bossOfName : " + bossOfName;
	}
	
}

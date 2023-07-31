package com.edu.child;

import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class Engineer extends Employee {

	private String mainSkill;
	private double bonus;
	
	public Engineer(String name, MyDate birthday, double salary, String mainSkill, double bonus) {
		super(name, birthday, salary);
		this.mainSkill = mainSkill;
		this.bonus = bonus;
	}
	

	@Override
	public String getDetails() {
		return super.getDetails() + " mainSkill : " + mainSkill + ", bonus : " + bonus;
	}
	
}

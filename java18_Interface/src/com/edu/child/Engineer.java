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
	

	public void changeMainSkill(String mainSkill) {
		this.mainSkill = mainSkill;
	}
	
	public String getMainSkill() {
		return mainSkill;
	}

	public void changeBonus(double bonus) {
		this.bonus = bonus;
	}
	
	public double getBonus() {
		return bonus;
	}

	@Override
	public String toString() {
		return super.toString() + " mainSkill : " + mainSkill + ", bonus : " + bonus;
	}
	
}

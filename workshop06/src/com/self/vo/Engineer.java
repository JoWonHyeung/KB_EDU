package com.self.vo;

import com.self.util.MyDate;

public class Engineer extends Employee {
	private String tech;
	private double bonus;
	
	public Engineer(String name, MyDate birthDate, double salary, String tech, double bonus) {
		super(name,salary,birthDate);
		this.tech = tech;
		this.bonus = bonus;
	}	
	
	public String getTech() {
		return tech;
	}
	
	public void setTech(String tech) {
		this.tech = tech;
	}
	
	public double getBonus() {
		return bonus;
	}
	
	public void setBonus(double bonus) {
		this.bonus = bonus;
	}	
	
	@Override
	public String toString() {
		return super.toString() + " , " + super.getBirthDate() + " , " + tech + " , " + bonus;
	}		
}

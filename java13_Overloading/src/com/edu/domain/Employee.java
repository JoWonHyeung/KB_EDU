package com.edu.domain;

import com.edu.util.MyDate;

//직원에 대한 정보를 저장하는 클래스..
/*
 	접근하는 범위를 지정하는 키워드
 	<<Access Modifier>>
 	private : 같은 클래스안에서만 접근을 허용
 	+
 	protected 
 	+
 	public : 어디서든지 접근을 허용
 	
 	생성자 Overloading
 	::
 	필수적인 정보로만 객체를 생성
 	미처 입력되지 않은 정보는 기본값으로 채울때 반드시 필요한 기법
 	이때 다른 생성자를 호출하기 위한 this키워드를 사용한다!!!
 	
 */

public class Employee {
	private String name;
	private double salary;
	private MyDate birthDate;

	//salary의 기본값지정...(상수로 지정)
	public static final double BASIC_SALARY = 100.0;
	
	public Employee() {} //정확한 프로그래밍을 위해서 기본적으로 적어줄 것!!
	
	/*
	 	생성자 앞의 this
	 	::
	 	같은 클래스 내에서 또다른 생성자를 호출할 때 사용하는 키워드
	 */
	public Employee(String name, MyDate birthDate) {
		this(name,BASIC_SALARY,birthDate);
	}
	
	public Employee(String name, double salary, MyDate birthDate) {
		this.name = name;
		this.salary = salary;
		this.birthDate = birthDate;
	}
	
	public String getName() {
		return name;
	}

	public double getSalary() {
		return salary;
	}

	public MyDate getBirthDate() {
		return birthDate;
	}

	@Override
	public String toString() {
		return name + "," + salary + "," + birthDate;
	}
	
}

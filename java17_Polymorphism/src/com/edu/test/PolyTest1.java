package com.edu.test;

/*
 * Polymorphism
 * ::
 * 부모타입으로 다양한 자식객체를 생성
 * 1) Object Casting
 * 2) Virtual Method Invocation
 */

import com.edu.child.Engineer;
import com.edu.child.Manager;
import com.edu.child.Secretary;
import com.edu.parent.Employee;
import com.edu.util.MyDate;

public class PolyTest1 {

	public static void main(String[] args) {
		Employee m = new Manager("James", new MyDate(1990,1,1), 400000.0, "IT");
		Employee e = new Engineer("Jones", new MyDate(1997,1,3), 30000.0, "Java", 5000.0);
		Employee s = new Secretary("Kim", new MyDate(1993,2,3),50000.0, "Jin");
		
		//1. James 의 부서를 Marketing 부서로 변경...changeDept()
		//prob) 왼쪽에 쓰인 Class는 타입으로 적용 -> Employee 멤버에 changeDept() 함수가 존재하지 않는다. -> 그래서 호출 불가능
		//solv) Manager로 Type Casting후에 changeDept() 사용
		
		((Manager)m).changeDept("Marketing");
				
		//2. 정보출력
		/*
		 Virtual Method Invocation 원리
		 상속관계의 오버라이딩된 메소드에서 
		 부모타입으로 자식객체를 생성했을 때 발생하는 원리
		 
		 1. 컴파일 시점 --- 부모의 메소드의 호출
		 2. 런타임 시점 --- 실질적으로 생성된 자식의 메소드를 호출
		 */
		System.out.println(m);
		System.out.println(e);
		System.out.println(s);
		
	}

}

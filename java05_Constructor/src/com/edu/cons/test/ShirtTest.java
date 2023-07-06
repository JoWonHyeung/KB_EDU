package com.edu.cons.test;

import com.edu.cons.Shirt;

public class ShirtTest {

	public static void main(String[] args) {
		/*
		 * s1이라는 객체 생성시 Shirt 클래스는 Type으로 작동
		 * new Shirt() 객체를 생성하면 == "Shirt클래스의 멤버가 메모리에 올라간다."
		 * 여기서는 Shirt의 변수 및 메소드 5개가 메모리에 올라간다.
		 * 
		 * 객체 생성과 동시에 값주입을 원하면 생성자를 이용
		 */
		Shirt s1 = new Shirt(null, false, 't');
		//setXxx() 호출이 안된 상황... 필드초기화가 안됨.
		//필드에는 무조건 기본값이 들어가 있다.
		System.out.println(s1.getShirt());
		
	}

}

package com.edu.oop.test;

import com.edu.oop.Greet;

/*
 * main 메소드를 가지고 있는 클래스 -> 실행 클래스 = Test 클래스
 * 
 * ~Test 클래스가 하는 일
 * 1) 변수에 값을 입력
 * 2) 메소드는 호출
 */

public class GreetAppTest {

	public static void main(String[] args) {
		Greet g = new Greet();
		
		//변수 초기화(Initialization)
		//초기화(새로운 값을 할당)
		g.target = "KB IT's your life 4기"; // 오른쪽에 있는 것은 리터럴 상수
		g.message = "Hello Java~~!!";
		
		//메소드 호출
		g.sayHello();
		
	}

}

package com.edu.test;


class StaticExam{
	static String name = "James"; //static Variable
	static int age = 44; //static Variable
	int count = 1; //field
	
	public static void getMember() {
		System.out.println("getMember() : " + "우/유/빛/깔/" + name);
	}
	
	public void getMember2() {
		//static String address = "역삼동"; //로컬 레벨에서 못쓴다.
		System.out.println("getMember2() : "  + "우/유/빛/깔/" + name);
	}
}

public class StaticExamTest1 {

	public static void main(String[] args) {
		//객체 생성과정 없이 바로 사용 가능
		StaticExam.getMember();
		
		//객체 생성 == 클래스의 getMember2()가 메모리에 올라간다.
		StaticExam se = new StaticExam();
		se.getMember2();
	}

}

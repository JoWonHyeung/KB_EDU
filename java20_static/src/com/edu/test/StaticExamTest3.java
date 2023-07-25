package com.edu.test;


/*
 static 키워드와 가장 많이 함께 쓰이는 키워드는 final
 Usage Modifier
 static final
 final static
 
 final :: "내가 마지막이야~~~"
 final + 변수 :: "내가 마지막 변수야~~~" :: 상수값(고칠 수 없다)
 final + 메소드 :: "내가 마지막 메소드야~~~" :: 오버라이딩 금지
 final + 클래스 :: "내가 마지막 클래스야~~~" :: 상속 금지
 */
class A{
	public static final int BASIC_SALARY = 30000;
	public final String test() {
		return "오버라이딩 금지";
	}
}

final class B{
	
}

//class C extends B{ -> 상속금지
//	
//}

class D extends A{

//	public final String test() {
//		return "오버라이딩 금지";
//	}
	
//	BASIC_SALARY = 50000;
}

public class StaticExamTest3 {

	public static void main(String[] args) {
		
		
	}

}

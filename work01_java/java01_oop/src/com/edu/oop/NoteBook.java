package com.edu.oop;

//NoteBook에 관련된 정보를 저장하는 클래스
//NoteBook 구성요소 = 필드 + 메소드

// package명은 무조건 소문자로 작성한다. 

public class NoteBook { // 대문자로 시작하는 것은 클래스만이다. 
						// 내가 작성한 클래스, User Definition Class
	
	//필드 선언
	public String brand; // String -> 다른 개발자가 만들고 실행파일의 형태로 제공. JDK안에 이미 빌트인. 라이브러리 = API
	public int price;
	public int serialNumber;
	
	//메소드 정의(선언부 + 구현부)
	public void printNoteBookInfo() {
		System.out.println("Brand :" + "\t" + brand);
		System.out.println("price :" + "\t" + price);
		System.out.println("serialNumber:" + "\t" + serialNumber);
	}
}

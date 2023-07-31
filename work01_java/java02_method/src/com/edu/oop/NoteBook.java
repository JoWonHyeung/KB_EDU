package com.edu.oop;


public class NoteBook {  
						
	//필드 선언
	public String brand; 
	public int price;
	public int serialNumber;
	
	//메소드 정의(선언부 + 구현부)
	public void printNoteBookInfo() {
		System.out.println("Brand :" + "\t" + brand);
		System.out.println("price :" + "\t" + price);
		System.out.println("serialNumber:" + "\t" + serialNumber);
	}
	
	//필드에 값 할당하는 기능을 추가 == 주입(set~~)
	public void setNoteBook(String brand, int price, int serialNumber) {
		//필드와 로컬변수를 구분하기 위해서 this키워드를 필드앞에 붙인다.
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
}

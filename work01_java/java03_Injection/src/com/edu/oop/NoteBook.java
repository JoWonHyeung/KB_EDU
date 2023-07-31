package com.edu.oop;

//NoteBook에 대한 정보를 저장하는 클래스...
public class NoteBook {  
						
	//필드 선언
	public String brand; 
	public int price;
	public int serialNumber;
	
	//메소드는 return type을 가진다.
	//return type이 void면 반환값이 없다는 의미의 return type
	//반환값을 String으로 지정
	//~Test클래스로 리턴(호출한 곳으로 리턴)... 거기서 출력하면 된다.
	public String getNoteBookInfo() {
		return brand + 
				"\t" + price + 
				"\t" + serialNumber;
	}
	
	//필드에 값 주입(값 할당) == 필드 초기화
	public void setNoteBook(String brand, int price, int serialNumber) {
		//필드와 로컬변수를 구분하기 위해서 this키워드를 필드앞에 붙인다.
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}
	
}

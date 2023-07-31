package com.edu.domain;

public class NoteBook {  
						
	//필드 선언 -> 생성자로 만들지 setter로 만들지 먼저 고민한다. 여기서는 생성자!!! LifeCycle 생각 자세한건 필기참고
	public String brand; 
	public int price;
	public int serialNumber;
	
	public NoteBook(String brand, int price, int serialNumber) {
		this.brand = brand;
		this.price = price;
		this.serialNumber = serialNumber;
	}

	@Override
	public String toString() {
		return brand + "\t" 
				+ price + "\t" 
				+ serialNumber;
	}
	
}

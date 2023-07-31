package com.edu.cons;

public class Shirt {
	public String brand;
	public boolean longSleeved;
	public char color;
	
	
	public Shirt(String brand, 
			boolean longSleeved, 
			char color) {
		this.brand = brand;
		this.longSleeved = longSleeved;
		this.color = color;
	}
	
	//값주입...지역,로컬변수
	public void setShirt(String brand, 
						boolean longSleeved, 
						char color) {
		this.brand = brand;
		this.longSleeved = longSleeved;
		this.color = color;
	}
	
	//값반환
	public String getShirt() {
		return brand + "," + longSleeved + "," + color;
	}
}

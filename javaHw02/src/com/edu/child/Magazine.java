package com.edu.child;

import com.edu.parent.Book;

public class Magazine extends Book {
	private int month;

	public Magazine() {}

	
	public Magazine(String isbn, String title, int price, int quantity,int month) {
		super(isbn, title, price, quantity);
		this.month = month;
	}

	
	public String toString() {
		return super.toString() + "\t | " + month;
				
	}





	
}
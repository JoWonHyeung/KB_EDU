package com.edu.oop.test;

import com.edu.oop.NoteBook;

//src -> 자바소스 코드 보관하는 곳

public class NoteBookTest {
	public static void main(String[] args) {
		NoteBook nb = new NoteBook();
		
		nb.brand = "LG Gram";
		nb.price = 10000;
		nb.serialNumber = 1;
		
		nb.printNoteBookInfo();
	}
}

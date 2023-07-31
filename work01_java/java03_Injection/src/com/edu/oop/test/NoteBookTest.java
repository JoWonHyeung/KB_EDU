package com.edu.oop.test;

import com.edu.oop.NoteBook;

public class NoteBookTest {
	public static void main(String[] args) {
		NoteBook nb = new NoteBook();
		
		//1. 값 주입되는 함수로 호출
		nb.setNoteBook("LG Gram", 170, 123);
		
		//2. 값을 반환하는 함수를 호출
		System.out.println(nb.getNoteBookInfo());	
	}
}

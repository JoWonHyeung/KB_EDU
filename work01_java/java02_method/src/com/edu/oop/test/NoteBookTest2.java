package com.edu.oop.test;

import com.edu.oop.NoteBook;

/*
 * 문제점
 * 필드에 일일이 값할당(초기화) 하고 있다.
 * 필드의 갯수가 늘어나면 코드라인도 늘어나고 가독력도 떨어진다.
 * 
 * 해결책
 * 필드초기화 하는 기능을 추가한다
 */

public class NoteBookTest2 {
	public static void main(String[] args) {
		NoteBook nb = new NoteBook();
		
		/*
		 * nb.brand = "LG Gram"; nb.price = 10000; nb.serialNumber = 1234;
		 */
		nb.setNoteBook("LG Gram", 10000, 1234);
		
		nb.printNoteBookInfo();
	}
}


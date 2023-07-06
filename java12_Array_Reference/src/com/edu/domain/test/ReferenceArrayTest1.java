package com.edu.domain.test;

import com.edu.domain.NoteBook;

/*
 * Class DataType의 배열을 생성, 초기화...
 * Memory allocation...
 */

public class ReferenceArrayTest1 {

	public static void main(String[] args) {
		//1. 배열 생성
		NoteBook[] notebooks = new NoteBook[3];
		
		for(NoteBook nb : notebooks) 
			System.out.println(nb);
		
		System.out.println("=====================");
		
		notebooks[0] = new NoteBook("HP",170,123);
		notebooks[2] = new NoteBook("LG Gram",130,451);
		
		for(NoteBook nb : notebooks) 
			System.out.println(nb);
		
		System.out.println("===========1==========");
		
		for(NoteBook nb : notebooks) {
			if(nb == null) continue;
			System.out.println(nb);
		}
		
		System.out.println("===========2==========");	
		
		for(NoteBook nb : notebooks) {
			if(nb == null) continue;
			System.out.println(nb.toString());
		}
	}

}

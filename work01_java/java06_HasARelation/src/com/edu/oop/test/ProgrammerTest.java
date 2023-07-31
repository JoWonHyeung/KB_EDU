package com.edu.oop.test;

import com.edu.oop.NoteBook;
import com.edu.oop.Programmer;

public class ProgrammerTest {

	public static void main(String[] args) {
		/*
		 * 1.객체 생성
		 * 2.기능을 호출
		 * -------------------------------------
		 * 1. James라는 개발자를 생성
		 * 	  정보를 입력... 이름, 주요기술, 급여	
		 * 2. James가 HP 노트북을 구매...Setter주입
		 * 3. James가 구매한 노트북을 리턴받아서 
		 *    노트북의 정보를 출력
		 * 4. James의 변경된 mainSkill,급여를 출력
		 */
		
		//1
		Programmer p = new Programmer("James","Java",30000);
		
		//2
		p.buyNoteBook(new NoteBook("HP",500000,1234));

		//3
		System.out.println("notebook info : " + p.getNoteBook().getNoteBookInfo());
		
		//4
		p.changeMainSkill("Python");
		p.increamentSalary(10000);
		System.out.println("change mainSkill : " + p.getMainSkill());
		System.out.println("change salary : " + p.getSalary());
	}

}

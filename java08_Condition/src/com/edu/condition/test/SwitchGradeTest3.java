package com.edu.condition.test;

import java.util.Scanner;

public class SwitchGradeTest3 {

	public static void main(String[] args) {
		System.out.println("성적입력 >> ");
		Scanner sc = new Scanner(System.in);
		
		int grade = sc.nextInt();
		
		switch(grade) { // grade는 실수형 불가
			case 90:
			case 95:
			case 85:
				System.out.println("A...");
				break;
			case 80:
			case 75:
				System.out.println("B...");
				break;
			case 60:
			case 65:
				System.out.println("C...");
				break;
			default:
				System.out.println("Try...");
		}
	}

}

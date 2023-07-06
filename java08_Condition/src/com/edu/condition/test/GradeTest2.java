package com.edu.condition.test;

import java.util.Scanner;

/*
 Scanner를 사용해서 성적과 함께 과목명을 입력
 Java, A Grade...
 */

public class GradeTest2 {

	public static void main(String[] args) {
		//int grade = 88; // Local V, 컴파일시에 값이 들어간다.
		Scanner sc = new Scanner(System.in);
		System.out.println("성적 입력 >>");
		int grade = sc.nextInt();
		System.out.println("과목 입력 >>");
		String subject = sc.next();
		
		if(grade <= 100 & grade > 80) 
			System.out.printf("A %s",subject);
		else if(grade <= 80 & grade > 70)
			System.out.printf("B %s",subject);
		else if(grade <= 70 & grade > 60)
			System.out.printf("C %s",subject);
		else
			System.out.printf("Try Again~");
	}

}

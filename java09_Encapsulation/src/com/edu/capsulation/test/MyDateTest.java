package com.edu.capsulation.test;

import java.util.Scanner;

import com.edu.capsulation.MyDate;

/*
 * 1. Scanner를 사용해서 month, day값 받아온다.
 * 2. 마지막 출력 결과에 절대로 0월 13일 입니다.
 *                       7월 0일 입니다.
 *                       0월 0일 입니다.
 */

public class MyDateTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		MyDate md = new MyDate(); //calling
		
		System.out.println("월 입력 >>");
		int month = sc.nextInt();
		System.out.println("일 입력 >>");
		int day = sc.nextInt();
		
		/*
		 * 다른 클래스(~~Test)에서 field에 직접적으로 접근을 못하게 해야한다.
		 * invalid한 값이 필드에 저장되지 못하게 막아야 한다. 
		 */
		
		//md.month = 33;
		//md.day = 3;
		md.setMonth(month);
		md.setDay(day);
		
		
		System.out.println("오늘은 " + md.getMonth() + "월 " + md.getDay() + "일 입니다.");
	}

}

package com.edu.condition2.test;

import java.util.Scanner;

public class PatternGameTest {

	
	public static void solv(int num) {
		int firstNum = num % 10;
		int secondNum = num / 10;
		int cnt = 0;
		
		if(firstNum % 3 == 0)
			cnt++;
		if(secondNum % 3 == 0)
			cnt++;
		
		if(cnt == 2)
			System.out.println("@@");
		else if(cnt == 1)
			System.out.println("@");
		else
			System.out.println(num);	
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("값 입력 >>");
		int n = sc.nextInt();
		
		solv(n);
	}

}

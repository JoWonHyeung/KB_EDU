package com.edu.condition2.test;

import java.util.Scanner;

/*
 * 간단한 알고리즘을 푸는 테스트 코드의 구조
 */
public class CatAMouseTest {

	public static String solv(int x, int y, int z) { //static은 컴파일 시점에 메모리에 올라간다.
		int Adist = Math.abs(x - z);
		int Bdist = Math.abs(y - z);

		if(Adist < Bdist) 
			return "CatA Catch!";
		else if(Adist > Bdist) 
			return "CatB Catch!";
		else 
			return "Mouse Escapes!!";
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//순서대로 정수값을 입력받자.
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		
		//입력받은 값들을 가지고 알고리즘을 해결해야 한다.
		//메소드 안에서 알고리즘을 해결할 것이다.
		String result = solv(a,b,c);
		
		System.out.println(result);
	}
	
	

}

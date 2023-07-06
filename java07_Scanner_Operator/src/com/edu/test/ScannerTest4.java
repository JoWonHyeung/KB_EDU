package com.edu.test;

import java.util.Scanner;

/*
 ~Test3의 문제점을 해결해보세요
 nextLine()을 사용한채로...
 */

public class ScannerTest4 {

	public static void main(String[] args) {
		//1. 키보드로 입력되는 값을 받아오는 Scanner 생성
		Scanner sc = new Scanner(System.in);
		//2. 정수값을 입력받는 기능...
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		
		sc.nextLine();
		String name = sc.nextLine();
		
		System.out.printf("num1:%d, num2:%d", num1, num2);
		System.out.println();
		System.out.printf("name:%s", name);
	}

}

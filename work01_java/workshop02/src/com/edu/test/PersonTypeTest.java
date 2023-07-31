package com.edu.test;
import java.util.Scanner;


public class PersonTypeTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] arr = new int[6];
		int max = Integer.MIN_VALUE;
		int answer = 0;
		
		for(int i = 0; i < n;i++) {
			int tmp = sc.nextInt();
			arr[tmp] += 1;
		}
		
		for(int i = 1; i <= 5;i++) {
			/*
			 * 타입 개수가 같은 경우는 문제 조건에 따로 언급된바가 없으므로 최근 값으로 그냥 덮어씌움
			 */
			if(max < arr[i]) {
				max = arr[i];
				answer = i;
			}
		}

		System.out.println("가장 많은 타입의 유형은 " + answer + "타입입니다.!!");
		  
		 
		  
	}
}


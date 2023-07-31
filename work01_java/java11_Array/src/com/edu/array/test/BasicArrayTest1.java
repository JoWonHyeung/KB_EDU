package com.edu.array.test;



public class BasicArrayTest1 {

	public static void main(String[] args) {
		//1.선언 + 2. 생성
		int[] arr = new int[3];
		
		//3.초기화
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		for(int i = 0; i < 3; i++) {
			System.out.println(arr[i]);
		}
	}

}

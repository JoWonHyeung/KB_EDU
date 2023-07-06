package com.edu.array.test;

/*
 * Same Data Type의 서로 다른 값들을 
 * 하나로 묶을 수 있는데 이게 바로 Array 라는 객체이다.
 * ::
 * Array는 
 * 1) 선언     2) 생성     3) 초기화
 */

public class BasicArrayTest2 {

	public static void main(String[] args) {
		//1.선언
		int[] arr; //dataType + 변수명;
		
		//2.생성(이때 size를 반드시 명시한다. new라는 키워드로 생성)
		arr = new int[3];
		
		//3.초기화
		arr[0] = 11; arr[1] = 22; arr[2] = 33;
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]);
		}
	}

}

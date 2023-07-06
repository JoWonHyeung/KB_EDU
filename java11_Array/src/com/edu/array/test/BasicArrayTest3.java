package com.edu.array.test;

/*
 * Same Data Type의 서로 다른 값들을 
 * 하나로 묶을 수 있는데 이게 바로 Array 라는 객체이다.
 * ::
 * Array는 
 * 1) 선언     2) 생성    3) 초기화
 */

public class BasicArrayTest3 {

	public static void main(String[] args) {
		//1.선언 + 2.생성 + 3.초기화
		int[] arr = {11,22,33};
				
//		for(int i = 0; i < arr.length; i++) {
//			System.out.println(arr[i]);
//		}
		
		//뭐가 어디서 돌아가는가
		for(int num : arr) {
			System.out.println(num);
		}
		
	}

}

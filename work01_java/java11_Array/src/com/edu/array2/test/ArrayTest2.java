package com.edu.array2.test;

public class ArrayTest2 {

	public static void main(String[] args) {
		int[] member = {1,2,3,4,5};
		
		member = new int[8];
		
		member[5] = 6;
		member[6] = 7;
		member[7] = 8;
		
		//배열은 resizing이 안된다.
		for(int v : member) 
			System.out.println(v);
		
	}

}

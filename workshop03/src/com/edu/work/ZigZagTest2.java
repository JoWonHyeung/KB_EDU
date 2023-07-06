package com.edu.work;

public class ZigZagTest2 {

	public static void main(String[] args) {
		int [][] intArray = 
			{ 
			  { 1, 2, 3, 4, 5 },
			  { 6, 7, 8, 9,10 },
			  {11,12,13,14,15 },
			  {16,17,18,19,20 },
			} ;
		
		for(int i = 0; i < 5; i++) {
			if(i % 2 == 0) {
				for(int j = 0; j < 4; j++) {
					System.out.print(intArray[j][i] + " ");
				}
			}else {
				for(int j = 3; j > -1; j--) {
					System.out.print(intArray[j][i] + " ");
				}
			}
			System.out.println();
		}
	
	}
}

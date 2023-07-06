package com.edu.array3.test;

public class TwoDimArrayTest {

	public static void main(String[] args) {
		int[][] twoArr = new int[2][3];
		
		System.out.println(twoArr.length); //row 2
		System.out.println(twoArr[0].length);//col 3
		System.out.println(twoArr[1].length);//col 3
		
		for(int i = 0; i < twoArr.length;i++) {
			for(int j = 0; j < twoArr[0].length;j++) {
				System.out.print(twoArr[i][j] + " ");
			}
			System.out.println();
		}

	}

}

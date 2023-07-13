package com.edu.algorithm.test;

import java.util.Arrays;

public class UserSortingTest {

	public static void main(String[] args) {
		int[][] arr = {
				{1,2},
				{3,4},
				{9,10},
				{3,6},
				{5,6}
		};
		
		Arrays.sort(arr, (x,y) -> x[0] - y[0]);
		System.out.println(Arrays.deepToString(arr));
		

	}

}

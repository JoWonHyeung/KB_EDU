package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1146 {

	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] nums = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			nums[i] = Integer.parseInt(st.nextToken());
		
		/*
		 * Main code
		 */
		for(int i = 0; i < nums.length - 1; i++) {
			//최솟값
			int MIN = Integer.MAX_VALUE;
			int idx = 0;
			for(int j = i; j < nums.length; j++) {
				if(MIN > nums[j]) {
					MIN = nums[j];
					idx = j;
				}
			}
			
			//swap
			int tmp = nums[i];
			nums[i] = MIN;
			nums[idx] = tmp;
			
			//print
			for(int n : nums)
				System.out.print(n + " ");
			System.out.println();
		}
			
	}

}

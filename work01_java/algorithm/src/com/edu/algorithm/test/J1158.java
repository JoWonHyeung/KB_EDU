package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1158 {

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
		for(int i = 1; i < N; i++) {
			int insertIdx = i;
			//들어갈곳 찾기
			for(int j = 0; j < i; j++) {
				if(nums[j] > nums[i]) {
					insertIdx = j;
					break;
				}
			}
			int temp = nums[i];
			
			//i까지 뒤로 물리기
			for(int j = i; j > insertIdx; j--) 
				nums[j] = nums[j - 1];
			
			//삽입
			nums[insertIdx] = temp;
			
			//출력
			for(int num : nums)
				System.out.print(num + " ");
			System.out.println();
		}


	}

}

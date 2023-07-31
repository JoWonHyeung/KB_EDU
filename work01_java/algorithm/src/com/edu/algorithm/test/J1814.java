package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class J1814 {
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int answer = 0;
		
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		/*
		 * Main Code
		 */
		for(int i = 1; i < N; i++) {
			int insertIdx = i;
			for(int j = 0; j < i; j++) {
				if(arr[i] < arr[j]) {
					insertIdx = j;
					break;
				}
			}
			int temp = arr[i];
			
			for(int j = i; j > insertIdx; j--) {
				arr[j] = arr[j - 1];
				answer++;
			}
			
			arr[insertIdx] = temp;
		}
		
		System.out.println(answer);
			
	}
}

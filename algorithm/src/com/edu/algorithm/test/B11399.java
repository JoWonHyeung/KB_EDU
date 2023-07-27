package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11399 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		int ans = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N;i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		Arrays.sort(arr);
		
		for(int i = 1; i <= N; i++) {
			int temp = 0;
			for(int j = 0; j < i;j++) {
				temp += arr[j];
			}
			ans += temp;
		}
		
		System.out.println(ans);
	}
}

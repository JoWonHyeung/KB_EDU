package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class kb2반_알고리즘2번_조원형 {
	static int[] arr;
	static int N, M;
	static int MAX = Integer.MIN_VALUE;
	
	static void dfs(int L, int st, int sum) {
		if(L == 3) {
			if(sum <= M && MAX < sum) MAX = sum;
			return;
		} else {
			for(int i = st; i < N; i++) 
				dfs(L + 1, i + 1, sum + arr[i]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
		
		/*
		 * Main Code
		 */
		
		dfs(0,0,0);
		System.out.println(MAX);
	}

}

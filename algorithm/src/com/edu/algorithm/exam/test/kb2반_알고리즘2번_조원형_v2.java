package com.edu.algorithm.exam.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class kb2반_알고리즘2번_조원형_v2 {
	static int[] arr;
	static int M;
	static int MAX = Integer.MIN_VALUE;
	
	static void dfs(int L, int sum, int cnt) {
		if(L == arr.length) {
			if(sum <= M && sum >= MAX && cnt == 3) {
				MAX = sum;
			}
			return;
		} else {
			dfs(L + 1, sum + arr[L],cnt + 1);
			dfs(L + 1, sum, cnt);
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
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

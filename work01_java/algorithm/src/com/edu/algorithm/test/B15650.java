package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15650 {
	static int[] arr;
	static int[] ans;
	static boolean[] isVisited;
	static int N;
	static int M;
	
	static void dfs(int L, int s) {
		if(L == M) {
			for(int i = 0; i < ans.length; i++)
				System.out.print(ans[i] + " ");
			System.out.println();
			return ;
		} else {
			for(int i = s; i < arr.length ;i++) {
				ans[L] = arr[i];
				dfs(L + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		ans = new int[M];
		isVisited = new boolean[N];
		
		for(int i = 0; i < arr.length; i++){
			arr[i] = (i + 1);
		}
		
		dfs(0,0);
	}

}

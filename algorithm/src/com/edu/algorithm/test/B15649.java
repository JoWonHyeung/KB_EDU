package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B15649 {
	static int[] arr;
	static boolean[] isVisited;
	static int[] ans;
	static int N;
	static int M;
	
	static void dfs(int L) {
		if(L == M) {
			for(int num : ans)
				System.out.print(num + " ");
			System.out.println();
			return;
		} else {
			for(int i = 0; i < N; i++) {
				if(isVisited[i] == false) {
					isVisited[i] = true;
					ans[L] = arr[i];
					dfs(L + 1);
					isVisited[i] = false;
				}
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
		
		for(int i = 0; i < N; i++)
			arr[i] = (i + 1);
		
		dfs(0);
	}

}

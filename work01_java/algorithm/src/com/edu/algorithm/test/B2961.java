package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2961 {
	static int N;
	static int[][] info;
	static int ans = Integer.MAX_VALUE;
	
	static void dfs(int L, int s, int ss, int cnt) {
		if(L == N) {
			if(cnt > 0 && Math.abs(ss - s) < ans) ans = Math.abs(ss - s);
			return;
		} else {
			dfs(L + 1,s * info[L][0], ss + info[L][1], cnt + 1); //선택O
			dfs(L + 1,s, ss, cnt); //선택X
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		info = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			info[i][0] = Integer.parseInt(st.nextToken());
			info[i][1] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * Main Code
		 */
		
		dfs(0,1,0,0);
		System.out.println(ans);
	}

}

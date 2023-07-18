package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1486 {

	static int N;
	static int B;
	static int[] heights;
	static int MIN;
	
	static void dfs(int L, int sum) {
		if(L == N) {
			if(sum >= B && MIN >= sum -B) 
				MIN = sum - B;
		} else {
			dfs(L + 1, sum + heights[L]);
			dfs(L + 1, sum);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());
			heights = new int[N];
			MIN = Integer.MAX_VALUE;
			
			st = new StringTokenizer(br.readLine(), " ");
			
			for(int j = 0; j < N; j++)
				heights[j] = Integer.parseInt(st.nextToken());
			
			dfs(0,0);
			
			System.out.printf("#%d %d\n",i, MIN);
		}
	}

}

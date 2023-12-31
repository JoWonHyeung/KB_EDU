package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B21735 {
	
	static int N, M;
	static int[] arr;
	static int MAX = Integer.MIN_VALUE;
	
	static void dfs(int L, int pos, int size) {
		if(L == M || pos == N) { //시간을 다 썻을 경우 최댓값 갱신
			MAX = Math.max(MAX, size);
		}else {
			if(pos + 1 <= N)
				dfs(L + 1, pos + 1, size + arr[pos + 1]);
			
			if(pos + 2 <= N)
				dfs(L + 1, pos + 2, (int)Math.floor(size / 2) + arr[pos + 2]);
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 2];
		arr[0] = 1; arr[N + 1] = 0;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 1);
		
		System.out.println(MAX);
	}

}
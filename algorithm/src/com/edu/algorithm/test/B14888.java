package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14888 {

	static int N;
	static int[] arr;
	static int[] operator = new int[4];
	static int MIN = Integer.MAX_VALUE;
	static int MAX = Integer.MIN_VALUE;

	static void dfs(int L, int sum, int pCnt, int mCnt, int nCnt, int tCnt) {
		if(L == N) {
			MAX = Math.max(sum, MAX);
			MIN = Math.min(sum, MIN);			
		}else {
			if(pCnt < operator[0]) dfs(L + 1, sum + arr[L], pCnt + 1, mCnt, nCnt, tCnt);
			if(mCnt < operator[1]) dfs(L + 1, sum - arr[L], pCnt, mCnt + 1, nCnt, tCnt);
			if(nCnt < operator[2]) dfs(L + 1, sum * arr[L], pCnt, mCnt, nCnt + 1, tCnt);
			if(tCnt < operator[3]) dfs(L + 1, sum / arr[L], pCnt, mCnt, nCnt, tCnt + 1);	
		}
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < 4; i++)
			operator[i] = Integer.parseInt(st.nextToken());
		
		dfs(1,arr[0],0,0,0,0);
		
		System.out.println(MAX);
		System.out.println(MIN);
	}

}

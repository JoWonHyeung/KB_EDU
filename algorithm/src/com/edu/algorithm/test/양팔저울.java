package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 양팔저울 {
	
	static int K;
	static int S;
	static int[] arr;
	static boolean[] check;
	static int answer;
	
	static void dfs(int L, int leftSum, int rightSum) {
		if(L == K) {
			check[Math.abs(rightSum - leftSum)] = true;
		} else {
			dfs(L + 1, leftSum + arr[L], rightSum);//좌측사용
			dfs(L + 1, leftSum, rightSum + arr[L]);//우측사용
			dfs(L + 1, leftSum, rightSum);//사용하지 않음
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		StringTokenizer st = new StringTokenizer(br.readLine());
		K = Integer.parseInt(st.nextToken());
		arr = new int[K];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < K; i++) arr[i] = Integer.parseInt(st.nextToken());

		for(int i : arr) S += i;
		
		check = new boolean[S + 1];
		
		/*
		 * Main Code
		 */
		
		dfs(0,0,0);
		
		for(int i = 1; i <= S; i++)
			if(!check[i])
				answer++;
		
		System.out.println(answer);
			
	}

}

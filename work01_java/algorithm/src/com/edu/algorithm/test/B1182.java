package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1182 {
	static int N;
	static int S;
	static int[] arr;
	static int cnt = 0;
	
	static void dfs(int L, int sum) {
		if(L == N) {
			if(sum == S) {
				cnt++;
			}
			
			return;
		}else {
			dfs(L + 1, sum + arr[L]);
			dfs(L + 1, sum);
		}
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		
		for(int i = 0; i < N; i++)
			arr[i] = Integer.parseInt(st.nextToken());
		
		/*
		 * Main Code
		 */
		
		dfs(0,0);
		if(S == 0) System.out.println(cnt - 1);
		else System.out.println(cnt);
		
	}

}

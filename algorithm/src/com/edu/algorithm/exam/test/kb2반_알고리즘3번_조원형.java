package com.edu.algorithm.exam.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class kb2반_알고리즘3번_조원형 {
	
	static int N, M;
	static int[] arr;
	static int MAX = Integer.MIN_VALUE;
	
	static void dfs(int L, int pos, int size) {
		if(L == M) { //시간을 다 썻을 경우 최댓값 갱신
			MAX = Math.max(MAX, size);
		}else {
			if(pos + 1 <= N) //지점 밖으로 나갈경우 미리 가지치기
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
		arr[0] = 1;
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dfs(0, 0, 1);
		
		System.out.println(MAX);
	}

}

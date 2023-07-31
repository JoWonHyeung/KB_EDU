package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 휴가 {

	static int N;
	static int[][] infos;
	static int MAX = Integer.MIN_VALUE;
	
	static void dfs(int L, int money, int day) {
		if(day == N) {
			MAX = Math.max(MAX, money);
		}else {

			if(day + infos[day][0] <= N) 
				dfs(L + 1, money + infos[day][1], day + infos[day][0]);//T날로 점프
			dfs(L + 1, money, day + 1);//바로 다음날

		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		infos = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			infos[i][0] = Integer.parseInt(st.nextToken());
			infos[i][1] = Integer.parseInt(st.nextToken());
		}
		
		
		dfs(0,0,0);
		
		System.out.println(MAX);
		//System.out.println(Arrays.deepToString(infos));
	}

}


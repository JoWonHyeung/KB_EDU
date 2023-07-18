package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5209 {

	static int N;
	static int[][] map;
	static boolean[] isVisited;
	static int MIN;
	
	static void dfs(int L, int sum) {
		if(MIN < sum) return;
		if(L == N) {
			MIN = Math.min(MIN, sum);
		} else {
			for(int i = 0; i < N; i++) {
				if(isVisited[i] == false) {
					isVisited[i] = true;
					dfs(L + 1, sum + map[L][i]);
					isVisited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			MIN = Integer.MAX_VALUE;
			isVisited = new boolean[N];
			
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int k = 0; k < N; k++) {
					map[j][k] = Integer.parseInt(st.nextToken());
				}
			}
			
			dfs(0, 0);
			
			System.out.printf("#%d %d\n", i, MIN);
		}
	}

}

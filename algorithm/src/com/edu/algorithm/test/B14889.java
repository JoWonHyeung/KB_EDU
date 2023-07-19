package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B14889 {
	
	static int MIN;
	static int[][] map;
	static int N;
	static boolean[] ch;
	
	static int[] getScore() { //점수 산출
		int[] star = new int[N / 2];
		int[] link = new int[N / 2];
		int starIdx = 0, linkIdx = 0;
		int starScore = 0, linkScore = 0;
		
		//[0] 팀 나누기
		for(int i = 0; i < N; i++) {
			if(ch[i] == true) star[starIdx++] = i;
			else link[linkIdx++] = i;
		}
		
		//[1] 각 팀 점수 구하기
		for(int ci = 0; ci < N / 2; ci++) { 
			for(int cj = ci + 1; cj  < N / 2; cj++) {
				starScore += map[star[ci]][star[cj]] + map[star[cj]][star[ci]]; 
				linkScore += map[link[ci]][link[cj]] + map[link[cj]][link[ci]];
			}
		}
				
		return new int[] {starScore, linkScore};
 	}
	
	static void dfs(int L, int st) {
		if(L == N / 2) {
			int[] scores = getScore();
			MIN = Math.min(MIN, Math.abs(scores[0] - scores[1]));
			return;
		} else {
			for(int i = st; i < N; i++) {
				ch[i] = true;
				dfs(L + 1, i + 1);
				ch[i] = false;
			}
		}
	}
	
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		ch = new boolean[N];
		MIN = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0);
		
		System.out.println(MIN);
	}

}

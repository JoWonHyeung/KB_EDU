package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S5215 {
	static int N, lim;
	static int[][] infos;
	static int MAX;
	
	public static void dfs(int L, int score, int calory) {
		if(calory > lim) return;
		if(L == N) {
			if(calory <= lim && score >= MAX) { //제한 칼로리보다 적고, 최대값 점수보다 클 때 점수 갱신
				MAX = score;
			}
		}else {
			dfs(L + 1, score + infos[L][0], calory + infos[L][1]); //선택O
			dfs(L + 1, score, calory); //선택X
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int tc = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= tc; i++) {
			/*
			 * Input
			 */
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			lim = Integer.parseInt(st.nextToken());
			MAX = Integer.MIN_VALUE; //MAX초기화
			
			infos = new int[N][2];
			for(int j = 0; j < N; j++) {
				st = new StringTokenizer(br.readLine(), " ");
				infos[j][0] = Integer.parseInt(st.nextToken()); //맛 점수
				infos[j][1] = Integer.parseInt(st.nextToken()); //칼로리
			}
			
			/*
			 * Main Code
			 */
			
			dfs(0,0,0);
			
			/*
			 * 정답
			 */
			System.out.printf("#%d %d\n",i, MAX);
			
		}
		
	}
	
	
}

package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S13992 {

	static int N;
	static int[][] map;
	static boolean[] isVisited;
	static int MIN;
	
	static void dfs(int L, int sum, int node) {
		if(sum > MIN) return;
		if(L == N && node == 0) { //전부다 방문하고 마지막 노드 지점이 0일때 종료
			MIN = Math.min(MIN, sum);
			
		} else {
			for(int i = 0; i < N; i++) {
				if(node != i && isVisited[i] == false) {
					isVisited[i] = true;
					dfs(L + 1, sum + map[node][i], i);
					isVisited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int tc = 1; tc <= T; tc++) {
			/*
			 * 입력
			 */
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			isVisited = new boolean[N];
			MIN = Integer.MAX_VALUE;
			
			for(int ci = 0; ci < N; ci++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int cj = 0; cj < N; cj++){
					map[ci][cj] = Integer.parseInt(st.nextToken());
				}
			}
			
			/*
			 * Main Code
			 */
			
			dfs(0,0,0);
			
			System.out.printf("#%d %d\n",tc, MIN);
			
		}
	}

}

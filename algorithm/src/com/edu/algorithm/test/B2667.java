package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B2667 {
	static int N;
	static char[][] map;
	static boolean[][] isVisited;
	static int totalCnt, eachCnt;
	static ArrayList<Integer> eachCntList = new ArrayList<>();
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static void dfs(int x, int y) {
		eachCnt++;
		
		for(int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx > N - 1 || ny < 0 || ny > N - 1) continue;
			
			if(map[nx][ny] == '1' && isVisited[nx][ny] == false) {
				isVisited[nx][ny] = true;
				dfs(nx,ny);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new char[N][N];
		isVisited = new boolean[N][N];
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j = 0; j < N; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		for(int ci = 0; ci < N; ci++) {
			for(int cj =0; cj < N; cj++) {
				if(map[ci][cj] == '1' && isVisited[ci][cj] == false) {
					isVisited[ci][cj] = true;
					totalCnt++;
					eachCnt = 0;
					dfs(ci,cj);
					eachCntList.add(eachCnt);
				}
			}
		}
		
		Collections.sort(eachCntList);
		
		System.out.println(totalCnt);
		for(int cnt : eachCntList)
			System.out.println(cnt);
		
	}

}

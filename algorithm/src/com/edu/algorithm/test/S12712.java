package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S12712 {
	static int[][] map;
	static int N,M;
	static int[] dx1 = {-1,0,1,0}; static int[] dy1 = {0,1,0,-1};
	static int[] dx2 = {-1,1,1,-1};static int[] dy2 = {1,1,-1,-1};
	
	
	// '+' 분사
	static int getInsectNum1(int x, int y) {
		int temp = 0;
		temp += map[x][y];
		//M크기 늘리기
		for(int size = 1; size <= M - 1; size++) {
			//4방향 탐색
			for(int dr = 0; dr < 4; dr++) {
				int nx = x + size * dx1[dr];
				int ny = y + size * dy1[dr];
				
				if(nx > N - 1 || ny > N - 1 || nx < 0 || ny < 0) continue;
				temp += map[nx][ny];
			}
		}
		return temp;
	}
	
	// 'X' 분사
	static int getInsectNum2(int x, int y) {
		int temp = 0;
		//현재 위치 더하기
		temp += map[x][y];
		//M크기 늘리기
		for(int size = 1; size <= M - 1; size++) {
			//4방향 탐색
			for(int dr = 0; dr < 4; dr++) {
				int nx = x + size * dx2[dr];
				int ny = y + size * dy2[dr];
				
				if(nx > N - 1 || ny > N - 1 || nx < 0 || ny < 0) continue;
				temp += map[nx][ny];
			}
		}
		return temp;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int T = Integer.parseInt(st.nextToken());
		
		for(int i = 1; i <= T; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			map = new int[N][N];
			
			//map 값 입력
			for(int ci = 0; ci < N; ci++) {
				st = new StringTokenizer(br.readLine(), " ");
				for(int cj = 0; cj < N; cj++) {
					map[ci][cj] = Integer.parseInt(st.nextToken());
				}
			}
			
			int MAX = Integer.MIN_VALUE;
			
			//최대값 찾기
			for(int ci = 0; ci < N; ci++) {
				for(int cj = 0; cj < N; cj++) {
					int temp = Math.max(getInsectNum1(ci, cj), getInsectNum2(ci, cj));
					if(temp > MAX) 
						MAX = temp;
				}
			}
			
			System.out.printf("#%d %d\n",i,MAX);
		}
		
	}

}

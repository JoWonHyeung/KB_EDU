package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B9663 {
	
	static int N;
	static int[] dx = {-1,-1,0,1,1, 1, 0,-1}, dy = { 0, 1,1,1,0,-1,-1,-1};
	static int[][] board;
	static boolean[] ch;
	static int cnt;
	
	static boolean getCheck(int x, int y) {
		for(int si = 1; si <= N; si++) {
			for(int sj = 0; sj < dx.length; sj++) {
				int nx = x + dx[sj] * si;
				int ny = y + dy[sj] * si;
				
				if(nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) continue;
				
				if(board[nx][ny] == 1) //퀸이 있는 경우 탈출
					return false;
			}
		}
		return true; //걸리는게 없는 경우
	}
	
	static void dfs(int L) {
		if(L == N) { //끝에 도달한 경우
			cnt++;
		} else {
			for(int i = 0; i < N; i++) {
				if(ch[i] == false && getCheck(L, i)) {
					board[L][i] = 1;
					ch[i] = true;
					dfs(L + 1);
					ch[i] = false;
					board[L][i] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		ch = new boolean[N];
		
		dfs(0);
		
		System.out.println(cnt);
	}

}

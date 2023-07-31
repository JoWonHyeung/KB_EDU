package com.edu.algorithm.test;

import java.util.Scanner;

public class S2001 {
	static final int N = 100;
	static int[] dx = {0,0,-1} ;
	static int[] dy = {1,-1,0} ;
	static int[][] map = new int[N][N];
	static int[][] isVisited = new int[N][N];
	static boolean flag = false;
	
	public static void dfs(int x, int y,int tc) {
		if(flag) return;
		if(x == 0) { //마지막 행에 도달했을 때
			System.out.printf("#%d %d\n",tc,y);
			flag = true;
			return;
		}else {
			for(int i = 0; i < 3; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				
				if(xx < 0 || xx > N - 1 || yy < 0 || yy > N - 1) continue;
				
				if(map[xx][yy] == 1 && isVisited[xx][yy] == 0) {
					isVisited[xx][yy] = 1;
					dfs(xx,yy,tc);
					isVisited[xx][yy] = 0;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= N; i++) {
			sc.nextInt();
			//map 초기화
			for(int m = 0; m < N; m++) 
				for(int k = 0; k < N; k++) 
					map[m][k] = sc.nextInt();
				
			//출발점에서 시작!!!
			for(int m = 0; m < N; m++) {
				if(map[N - 1][m] == 2) {
					isVisited = new int[N][N]; //초기화
					isVisited[N - 1][m] = 1; 
					flag = false;
					dfs(N - 1,m,i);
				}
			}
			
		}
	}

}

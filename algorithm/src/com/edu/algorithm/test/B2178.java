package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Info{
	public int x,y,cnt;
	
	public Info(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;			
	}
}

public class B2178 {
	
	static int cnt;
	static int N, M;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	static boolean[][] isVisited;
	static char[][] map;
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new char[N][M];
		isVisited = new boolean[N][M];
		
		for(int ci = 0; ci < N; ci++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int cj = 0; cj < M; cj++) {
				map[ci][cj] = temp.charAt(cj);
			}
		}
		
		/*
		 * Main
		 */
		Queue<Info> q = new LinkedList<>();
		q.add(new Info(0,0,1));
		
		while(!q.isEmpty()) {
			Info now = q.poll();
			if(now.x == N - 1 && now.y == M - 1) {
				System.out.println(now.cnt);
				break;
			}
			isVisited[now.x][now.y] = true;
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nCnt = now.cnt;
				
				if(nx < 0 || nx > N - 1 || ny < 0 || ny > M - 1) continue;
				
				if(map[nx][ny] == '1' && isVisited[nx][ny] == false) {
					isVisited[nx][ny] = true;
					q.add(new Info(nx,ny,nCnt + 1));
				}
			}
		}
		
	}

}

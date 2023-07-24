package com.edu.algorithm.exam.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

class Pos{
	int x, y, day;
	
	Pos(int x, int y, int day){
		this.x = x;
		this.y = y;
		this.day = day;
	}
}

public class kb2반_알고리즘2번_조원형 {
	
	static int row, col;
	static char[][] map;
	static boolean[][] isVisited;
	static int targetX, targetY;
	static int ansDay, ansNoCorona;
	static int[] dx = {-1,0,1,0};
	static int[] dy = {0,1,0,-1};
	
	static int bfs(Pos tPos) {
		int day = 0;
		Queue<Pos> q = new LinkedList<>();
		q.add(tPos);
		isVisited[tPos.x][tPos.y] = true;
		
		while(!q.isEmpty()) {
			Pos now = q.poll();
			if(day < now.day)
				day = now.day;
			
			for(int i = 0; i < 4; i++) {
				int nx = now.x + dx[i];
				int ny = now.y + dy[i];
				int nDay = now.day + 1;
				
				if(nx < 0 || nx > row - 1 || ny < 0 || ny > col - 1) continue;
				
				if(map[nx][ny] == '1' && isVisited[nx][ny] == false) {
					isVisited[nx][ny] = true;
					q.add(new Pos(nx,ny,nDay));
				}
			}
		}
		
		return day;
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		col = Integer.parseInt(st.nextToken());
		row = Integer.parseInt(st.nextToken());
		map = new char[row][col];
		isVisited = new boolean[row][col];
		
		for(int i = 0; i < row; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j = 0; j < col; j++) {
				map[i][j] = temp.charAt(j);
			}
		}
		
		st = new StringTokenizer(br.readLine(), " ");
		targetY = Integer.parseInt(st.nextToken());
		targetX = Integer.parseInt(st.nextToken());
		
		//[0] 퇴소일 처리
		ansDay = bfs(new Pos(targetX, targetY, 3)); 
		 
		//[1] 코로나 걸리지 않은 사람 체크
		for(int i = 0; i < row; i++) {
			for(int j = 0; j < col; j++) {
				if(map[i][j] == '1' && isVisited[i][j] == false) {
					ansNoCorona++;
				}
			}
		}
		
		
		//[2] 정답 출력
		System.out.println(ansDay + "\n" + ansNoCorona);
	}

}

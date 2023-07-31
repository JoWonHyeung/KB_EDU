package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class kb2반_알고리즘3번_조원형 {
	static int N = 19;
	static int[][] map = new int[N][N];
	static int[] dx = {-1,-1, 0, 1, 1, 1, 0, -1};
	static int[] dy = { 0, 1, 1, 1, 0,-1, -1,-1};
	static boolean flag = false;
	static int ansX, ansY = 0;
	
	static boolean getCheck(int nowX, int nowY, int target) {
		// 8방향 체크하면서 사이즈 늘리기
		for(int ci = 0; ci < 8; ci++) { 
			int checkNum = 1;
			for(int cj = 1; cj <= 4; cj++) {
				int nx = nowX + cj * dx[ci];
				int ny = nowY + cj * dy[ci];
				
				//그 다음 좌표값이 오목판을 벗어나면 연속된 돌이 5개일 경우가 없을 것이므로
				//바로 탈출시킨다.
				if(nx < 0 || ny < 0 || nx > N - 1 || ny > N - 1) break;
				if(map[nx][ny] == target) //연속된 돌일 경우 체크한다.
					checkNum++;
			}
			
			//같은 돌 5개일 때 true 반환하고,
			//좌표값저장한다.
			if(checkNum == 5) {   
				ansX = nowX + 1; 
				ansY = nowY + 1;
				return true;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int ans = 0;
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		/*
		 * Main Code
		 */
		
		//좌표들을 완전 탐색하면서, 연속된 돌이 5개일 경우를 찾는다.
		for(int ci = 0; ci < N; ci++) {
			for(int cj = 0; cj < N; cj++) {
				if(map[ci][cj] == 1 && getCheck(ci, cj, 1)) { //연진 체크
					ans = 1;
					flag = true; break;
				} else if(map[ci][cj] == 2 && getCheck(ci, cj, 2)) { //동은 체크
					ans = 2;
					flag = true; break;
				}
			}
			
			if(flag) //이미 이겼으므로, 이후 연산이 필요없다. 따라서 탈출시킨다.
				break;
		}
		
		//첫째줄 답
		System.out.println(ans);
		
		//두번째줄 답
		if(flag) 
			System.out.println(ansX + " " + ansY);
		 
	}

}

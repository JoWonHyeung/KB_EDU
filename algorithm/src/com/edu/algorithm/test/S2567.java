package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2567 {
	static int[] dx = {-1,0,0,1};
	static int[] dy = {0,1,-1,0};
	static int[][] colorMap = new int[101][101];
	
	static void getColorArray(int x,int y) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				colorMap[x + i][y + j] = 1;
			}
		}
	}
	
	static int getResult() {
		int answer = 0;
		for(int i = 0; i < 100; i++) {
			for(int j = 0; j < 100; j++) {
				if(colorMap[i][j] == 1) {
					
					for(int k = 0; k < 4; k++) {
						int xx = i + dx[k];
						int yy = j + dy[k];
						
						if(colorMap[xx][yy] == 0 || xx < 0 || xx > 100 || yy < 0 || yy > 100) {
							answer++;
						}
							
					}
					
				}
			}
		}		
		return answer;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 0;i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
		
			getColorArray(x, y);
		}
					
		System.out.println(getResult());
	}

}

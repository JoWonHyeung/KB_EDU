package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2630 {

	static int white;
	static int blue;
	static int[][] map;
	
	static void solv(int x, int y, int size) {
		int colorInit = map[x][y]; 
		
		for(int i = x; i < x + size; i++) {
			for(int j = y; j < y + size; j++) {
				if(colorInit != map[i][j]) {
					int nextSize = size / 2;
					solv(x ,y , nextSize); 						// 좌측 상단
					solv(x, y + nextSize, nextSize); 			// 우측 상단
					solv(x + nextSize, y, nextSize); 			// 우측 상단
					solv(x + nextSize, y + nextSize, nextSize); // 우측 상단
					return;
				}
			}
		}
		
		if(colorInit == 1) blue++;
		else white++;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solv(0,0,N);
		
		System.out.println(white);
		System.out.println(blue);
	}

}

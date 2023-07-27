package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class S1211_v1 {
	
	static int getMaxCatchInsect(int[][] arr, int n, int m) {
		int result = Integer.MIN_VALUE;
		for(int ci = 0; ci < n; ci++) { //시작점
			for(int cj = 0; cj < n; cj++) {
				if(cj + m > n || ci + m > n) continue;
				int tmp = 0;
				for(int i = 0; i < m; i++) {
					for(int j = 0; j < m;j++) {
						tmp += arr[ci + i][cj + j];
					}
				}
				if(tmp > result) result = tmp;
			}
		}
		return result;
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		Scanner sc = new Scanner(System.in);
		int TC = sc.nextInt();
		
		for(int tc = 1; tc <= TC; tc++) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int[][] map = new int[N][N];
			
			for(int i = 0;i < N; i++) 
				for(int j = 0; j < N;j++) 
					map[i][j] = sc.nextInt();
			
			System.out.printf("#%d %d", tc, getMaxCatchInsect(map, N, M));
		}
		
	}

}

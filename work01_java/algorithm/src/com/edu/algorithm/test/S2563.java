package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S2563 {
	static int N = 100;
	
	static void getColorArray(int[][] arr,int x,int y) {
		for(int i = 0; i < 10; i++) {
			for(int j = 0; j < 10; j++) {
				arr[x + i][y + j] = 1;
			}
		}
	}
	
	static int getArea(int[][] arr) {
		int area = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(arr[i][j] != 0) area += 1;
			}
		}
		return area;
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int[][] arr = new int[N][N];

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			//색칠하기
			getColorArray(arr,x,y);
		}
		
		//결과출력
		System.out.println(getArea(arr));
	}

}

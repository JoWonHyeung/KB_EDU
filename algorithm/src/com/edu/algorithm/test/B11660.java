package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

/*
 * 입력을 Scanner로 받는 경우
 * BufferedReader
 * StringBuilder
 * 
 */
public class B11660 {

	public static void main(String[] args) throws Exception{
		Scanner sc = new Scanner(System.in);
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//StringTokenizer st = new StringTokenizer(br.readLine());
		
		int n = sc.nextInt();
		int m = sc.nextInt();
		
		int[][] map = new int[n + 1][n + 1];
		int[][] sSum = new int[n + 1][n + 1];
		
		for(int i = 1; i <= n; i++)
			for(int j = 1; j <= n; j++)
				map[i][j] = sc.nextInt();
		
		for(int i = 1; i <= n; i++) 
			for(int j = 1; j <= n; j++) 
				sSum[i][j] = sSum[i - 1][j] + sSum[i][j - 1] - sSum[i - 1][j - 1] + map[i][j];
		
		for(int i = 0; i < m; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();
			
			System.out.println(sSum[x2][y2] - sSum[x1 - 1][y2] - sSum[x2][y1 - 1] + sSum[x1 - 1][y1 - 1]);
		}
				
	}

}

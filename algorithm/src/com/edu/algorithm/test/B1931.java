package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1931 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int[][] infos = new int[N][2];
		int answer = 1;
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			infos[i] = new int[] {start, end};
		}
		
		Arrays.sort(infos, (x,y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
		
		int e = infos[0][1];
		
		for(int i = 1; i < N; i++) {
			if(e <= infos[i][0]) {
				e = infos[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);
		System.out.println(Arrays.deepToString(infos));
		
	}

}

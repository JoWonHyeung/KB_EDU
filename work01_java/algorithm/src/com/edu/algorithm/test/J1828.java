package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class J1828 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int answer = 1;
		int end = 0;
		int[][] info = new int[N][2];
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			info[i][0] = Integer.parseInt(st.nextToken()); //s
			info[i][1] = Integer.parseInt(st.nextToken()); //e
		}
		
		Arrays.sort(info,(x,y) -> x[1] == y[1] ? x[0] - y[0] : x[1] - y[1]);
		
		end = info[0][1];
		
		for(int i = 1; i < N; i++) {
			if(end <= info[i][0]) {
				end = info[i][1];
				answer++;
			}
		}
		
		System.out.println(answer);

	}

}

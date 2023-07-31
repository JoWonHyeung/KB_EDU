package com.edu.algorithm.exam.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘1번_조원형 {

	static int[] parents;
	static int answer;
	
	static void Union(int a, int b) {
		int x = Find(a);
		int y = Find(b);
		if(x != y) parents[y] = x;
	}
	
	static int Find(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = Find(parents[x]);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		parents = new int[N + 1];
		
		for(int i = 1; i <= N; i++) parents[i] = i;
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			
			Union(s,e);
		}
				
		
		for(int i = 2; i <= N; i++) {
			if(parents[i] == 1)
				answer++;
		}
		
		System.out.println(answer);
	
		
	}

}

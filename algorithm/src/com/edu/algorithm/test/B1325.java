package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

import java.util.StringTokenizer;

public class B1325 {

	static int N, M;
	static ArrayList<Integer> graph[]; 
	static int MAX = Integer.MIN_VALUE;
	static int resIdx;
	
	static int bfs(int start) {
		int cnt = 0;
		
		return cnt;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		graph = new ArrayList[N + 1];
		
		
		for(int i = 0; i <= N; i++) {
			graph[i] = new ArrayList<>();
			
		}
		
		for(int i = 1; i <= M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
		}
		
		/*
		 * Main Code
		 */
		
		for(int i = 1; i <= M; i++) {
			Collections.sort(graph[i]);
		}
		
		
		
	}

}

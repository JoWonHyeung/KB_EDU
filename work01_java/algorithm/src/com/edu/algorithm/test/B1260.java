package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B1260 {

	static int N, M, V;
	static boolean[] isVisited;
	static ArrayList<Integer>[] graph;
	
	static void dfs(int node) {
		System.out.print(node + " ");
			
		for(int next : graph[node]) {
			if(graph[next] != null && isVisited[next] == false) {
				isVisited[next] = true;
				dfs(next);
			}
		}
	}
	
	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		
		System.out.print(node + " ");
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			isVisited[now] = true;
			
			for(int next : graph[now]) {
				if(isVisited[next] == false) {
					isVisited[next] = true;
					System.out.print(next + " ");
					q.add(next);
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N + 1];	
		
		for(int i = 0; i < N + 1; i++)
			graph[i] = new ArrayList<Integer>();
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		
		for(int i = 1; i <= N; i++) 
				Collections.sort(graph[i]);
		
		//dfs
		isVisited = new boolean[N + 1];
		isVisited[V] = true;
		dfs(V);
		
		System.out.println();
		//bfs
		isVisited = new boolean[N + 1];
		isVisited[V] = true;
		bfs(V);
	}
	
}

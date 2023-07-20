package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class B1325 {
	
	static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
	static int[] result;
	static boolean[] isVisited;

	static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();
		q.add(node);
		isVisited[node] = true;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			
			for(int next : graph.get(now)) {
				if(!isVisited[next]) {
					isVisited[next] = true;
					q.add(next);
					result[next]++;
				}
			}
		}

	}
	
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		 String[] nm = br.readLine().split(" ");
		 int N = Integer.parseInt(nm[0]);
	     int M = Integer.parseInt(nm[1]);

		result = new int[N + 1];
		int MAX = 0;
		
		for(int i = 0; i <= N; i++) graph.add(new ArrayList<>());
		
		for(int i = 0; i < M; i++) {
			String[] fromTo = br.readLine().split(" ");
			int from = Integer.parseInt(fromTo[0]);
			int to = Integer.parseInt(fromTo[1]);
			graph.get(from).add(to);
		}
		
		/*
		 * Main Code
		 */
		
		for(int i = 1; i <= N; i++) {
			isVisited = new boolean[N + 1];
			bfs(i);
		}
		
		
		for(int i = 1; i <= N; i++)
			MAX = Math.max(result[i], MAX);
		
		 for (int i = 1; i <= N; i++) {
	            if(result[i] == MAX) {
	                bw.write(i + " ");
	            }
	        }

        bw.flush();
        bw.close();
	
	}

}

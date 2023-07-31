package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1197 {

	static int[] parents;
	static ArrayList<Info> infos = new ArrayList<>();
	
	static class Info implements Comparable<Info>{
		int x, y, weight;
		
		Info(int x, int y,int weight){
			this.x = x;
			this.y = y;
			this.weight = weight;
		}

		@Override
		public int compareTo(Info info) {
			if(info.weight < weight) return 1;
			else if(info.weight > weight) return -1;
			else return 0;
		}
		
	}
	
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
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		int result = 0;
		
		parents = new int[V + 1];
		
		for(int i = 1; i <= V; i++) parents[i] = i;
		
		for(int i = 0; i < E; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			int x =  Integer.parseInt(st.nextToken());
			int y =  Integer.parseInt(st.nextToken());
			int weight =  Integer.parseInt(st.nextToken());
			
			infos.add(new Info(x,y,weight));
		}

		Collections.sort(infos);
		
		for(Info info : infos) {
			if(Find(info.x) != Find(info.y)) { //같은 집합이 아닐때 -> Union
				Union(info.x, info.y);
				result += info.weight;
			}
		}
		
		System.out.println(result);
	}

}

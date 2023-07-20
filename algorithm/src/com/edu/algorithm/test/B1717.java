package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1717 {
	static int[] parents;
	
	static void Union(int a, int b) {
		int x = Find(a);
		int y = Find(b);
		if(x != y) parents[y] = x;
	}
	
	static int Find(int a) {
		if(parents[a] == a) return a;
		else return parents[a] = Find(parents[a]); 
	}
	
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		
		parents = new int[n + 1];
		
		for(int i = 0; i <= n; i++)
			parents[i] = i;
		
		for(int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			
			int flag = Integer.parseInt(st.nextToken());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(flag == 0) {
				Union(a,b);
			} else {
				if(Find(a) == Find(b)) 
					System.out.println("YES");
				else
					System.out.println("NO");
			}
		}
	}

}

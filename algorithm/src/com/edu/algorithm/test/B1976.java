package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B1976 {

	static int[][] map;
	static int[] parents;
	static int[] dest;
	static int[] destTmp;
	
	static void Union(int x, int y) {
		int a = Find(x);
		int b = Find(y);
		if(a != b) parents[b] = a;
	}
	
	static int Find(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = Find(parents[x]);
	}
	
	static void dfs(int L, int s) {
		if(L == 2) {
			if(Find(destTmp[0]) != Find(destTmp[1])) {
				System.out.println("NO");
				System.exit(0);
			}
			return;
		} else {
			for(int i = s; i < dest.length; i++) {
				destTmp[L] = dest[i];
				dfs(L + 1, i + 1);
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		
		map = new int[N + 1][N + 1];
		parents = new int[N + 1];
		
		for(int i = 1; i <= N; i++) parents[i] = i;
		
		//경유지 입력
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j = 1; j <= N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		//목적지 도시 입력
		dest = new int[M];
		destTmp = new int[2];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++) 
			dest[i] = Integer.parseInt(st.nextToken());
		
		//[0] 집합 
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] == 1) {
					Union(i,j);
				}
			}
		}
		
		//[1] 조합
//		for(int i = 0; i < M - 1; i++) {
//			for(int j = i + 1; j < M; j++) {
//				if(Find(dest[i]) != Find(dest[j])) {
//					System.out.println("NO");
//					System.exit(0);
//				}
//			}
//		}
		
		dfs(0, 0);
		
		System.out.println("YES");
	}

}

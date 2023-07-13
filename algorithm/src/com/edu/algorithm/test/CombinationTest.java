package com.edu.algorithm.test;


public class CombinationTest {
	static int[] arr = new int[] {1,2,3,4};
	static boolean[] isVisited = new boolean[4];
	static int[] ans = new int[3];
	
	static void dfs(int n, int s) {
		if(n == 3) {
			for(int i = 0; i < isVisited.length;i++) {
				if(isVisited[i])
					System.out.print((i + 1) + " ");
			}
			
			System.out.println();
			return;
		}
		else {		
			for(int i = s; i < arr.length; i++) {
				isVisited[i] = true;
				dfs(n + 1, s + 1);
				isVisited[i] = false;
			}
		}
	}
	
	public static void main(String[] args) {
		dfs(0, 0);
	}

}

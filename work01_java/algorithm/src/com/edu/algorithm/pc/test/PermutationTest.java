package com.edu.algorithm.pc.test;


public class PermutationTest {
	static int[] arr = new int[] {1,2,3,4};
	static boolean[] isVisited = new boolean[4];
	static int[] ans = new int[3];
	
	static void dfs(int n) {
		if(n == 3) {
			for(int a : ans)
				System.out.print(a + " ");
			System.out.println();
			return;
		} else {
			
			for(int i = 0; i < arr.length; i++) {
				if(isVisited[i] == false) {
					isVisited[i] = true;
					ans[n] = arr[i];
					dfs(n + 1);
					isVisited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) {
		dfs(0);
	}

}

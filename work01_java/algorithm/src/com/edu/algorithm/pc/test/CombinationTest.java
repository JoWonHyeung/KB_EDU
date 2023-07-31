package com.edu.algorithm.pc.test;


public class CombinationTest {
	static int[] arr = new int[] {1,2,3,4};
	static int[] ans = new int[3];
	
	static void dfs(int L, int st) {
		if(L == 3) {
			
			for(int j = 0; j < ans.length; j++)
				System.out.print(ans[j] + " ");
			System.out.println();
			
			return;
		}
		else {		
			for(int i = st; i < arr.length; i++) {
				ans[L] = arr[i];
				dfs(L + 1,i + 1);
			}
		}
	}
	
	public static void main(String[] args) {
		dfs(0, 0);
	}

}

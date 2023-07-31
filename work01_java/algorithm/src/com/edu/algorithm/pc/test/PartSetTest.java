package com.edu.algorithm.pc.test;

import java.util.Stack;

public class PartSetTest {
	static int[] nums = {1,2,3,4};
	static Stack<Integer> stack = new Stack<>();
	
	static void dfs(int L, int cnt) {
		if(L == nums.length) {
			if(cnt > 0) {
				for(int num : stack) 
					System.out.print(num + " ");
				System.out.println();
			}
		} else {
			stack.add(nums[L]);
			dfs(L + 1, cnt + 1);
			stack.pop();
			dfs(L + 1, cnt);
		}
	}
	
	public static void main(String[] args) {
		dfs(0, 0);
	}

}

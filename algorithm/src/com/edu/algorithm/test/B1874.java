package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B1874 {

	public static void main(String[] args) throws Exception {
		Stack<Integer> stk = new Stack<>();
		
		/*
		 * Input
		 */
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int[] inputArr = new int[n];
		int idx = 0;
		
		for(int i = 1; i <= n; i++) {
			st = new StringTokenizer(br.readLine());
			inputArr[idx++] = Integer.parseInt(st.nextToken());
		}
		
		/*
		 * Main code
		 */
		idx = 0;
		int cur = 1;
		
		while(cur != n + 1) {
			if(!stk.isEmpty() && (inputArr[idx] == stk.peek())) {
				while(!stk.isEmpty() && inputArr[idx] == stk.peek()) {
					stk.pop();
					idx++;
					sb.append("-\n");
				}
			} else {
				stk.add(cur++);
				sb.append("+\n");
			}
		}

		while(idx != n && inputArr[idx] == stk.peek()) {
			stk.pop();
			idx++;
			sb.append("-\n");
		}
		
		if(!stk.isEmpty()) {
			System.out.println("NO");
		}else {
			System.out.println(sb);	
		}
	}

}

package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17608 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			stack.add(Integer.parseInt(st.nextToken()));
		}
		
		int cnt = 1;
		int initLength = stack.pop();
		
		while(!stack.isEmpty()) {
			int top = stack.pop();
			if(initLength < top) {
				cnt++;
				initLength = top;
			}
		}
		
		System.out.println(cnt);
	}

}

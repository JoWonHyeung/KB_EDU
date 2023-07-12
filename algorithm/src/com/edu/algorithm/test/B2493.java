package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class B2493 {

	public static void main(String[] args) throws Exception {
		/*
		 * Input
		 */
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		Stack<Integer> stk = new Stack<>();
		Stack<Integer> res = new Stack<>();
		
		
		
		st = new StringTokenizer(br.readLine(), " ");
			
		for(int i = 0; i < N; i++)
			stk.add(Integer.parseInt(st.nextToken()));
		
		/*
		 * Main Code
		 */
		
		
		System.out.println(stk.toString());
			
	}

}

package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class B17298 {

	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		int[] resArr = new int[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++) 
			arr[i] = Integer.parseInt(st.nextToken());
			
		Stack<Integer> stk = new Stack<>();

		for(int i = N - 1; i > -1 ; i--) {
			int now = arr[i];
			
			while(!stk.isEmpty() && now >= stk.peek()) stk.pop();
			
			if(!stk.isEmpty())
				resArr[i] = stk.peek();
			else
				resArr[i] = -1;
			
			stk.add(now);
		}
		
		StringBuilder sb = new StringBuilder();
		
		
		for(int n : resArr)
			sb.append(n + " ");
		
		System.out.println(sb);
	}

}

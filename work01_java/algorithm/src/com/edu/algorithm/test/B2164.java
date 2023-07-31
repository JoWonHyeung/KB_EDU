package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class B2164 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		
		Queue<Integer> q = new LinkedList<Integer>();
		
		for(int i = 1; i <= n;i++)
			q.add(i);
		
		while(q.size() != 1) {
			//1
			q.remove();
			
			//2
			q.add(q.poll());
		}
		
		System.out.println(q.peek());
	}

}

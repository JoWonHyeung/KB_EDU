package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2018 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		
		int N  = Integer.parseInt(st.nextToken());
		int[] nums = new int[N + 1];
		int cnt = 1;
		int lt = 1; int rt = 1;
		int sum = 1;
		
		for(int i = 1; i <= N; i++) nums[i] = i;
		
		while(rt != N) {
			if(sum == N) {
				cnt += 1;
				rt++;
				sum += nums[rt];
			}
			else if(sum > N) {
				sum -= nums[lt];
				lt++;
			} else {
				rt++;
				sum += nums[rt];
			}
		}
		
		System.out.println(cnt);
	}

}

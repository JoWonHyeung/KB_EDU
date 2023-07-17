package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2839 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int MIN = Integer.MAX_VALUE;
		
		for(int i = 0; i <= N / 3; i++) {
			for(int j = 0; j <= N / 5; j++) {
				if((3 * i + 5 * j) == N && MIN > i + j) {
						MIN = i + j;
				}
			}
		}
		
		if(MIN != Integer.MAX_VALUE)
			System.out.println(MIN);
		else
			System.out.println(-1);
	}

}

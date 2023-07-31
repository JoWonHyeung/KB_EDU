package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B11047 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int[] money = new int[N];
		int cnt = 0;
	
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			money[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(money);
		
		for(int i = N - 1; i > -1; i--) {
			if(K >= money[i] && K != 0) {
				int temp = K / money[i];
				K = K - money[i] * temp;
				cnt += temp;
			}
		}
		
		System.out.println(cnt);
		
	}

}

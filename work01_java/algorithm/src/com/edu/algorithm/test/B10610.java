package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B10610 {

	static char[] chs;
	static boolean flag;
	static long sum;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String temp = st.nextToken();
		
		chs = new char[temp.length()];
		
		for(int i = 0; i < temp.length(); i++) {
			sum += temp.charAt(i) - '0';
			chs[i] = temp.charAt(i);
	
			if(temp.charAt(i) == '0') flag = true;
		}
		
		// [0] '0' 존재유무 || 자릿수 합이 3의 배수가 아닐 경우 -> 없으면 -1 출력
		if(!flag || sum % 3 != 0) {
			System.out.println(-1);
			return;
		}
		
		// [1] 숫자 내림차순 정렬
		Arrays.sort(chs);
		StringBuilder sb = new StringBuilder(new String(chs));
		String answer = sb.reverse().toString();
		
		for(char c : answer.toCharArray()) System.out.print(c);

	}

}

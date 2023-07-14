package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class B9742 {
	static boolean flag = false;
	static char[] ans;
	static boolean[] isVisited;
	static int cnt = 1;
	
	static void dfs(int L,String inputStr,int tg) {
		if(flag) return;
		if(L == inputStr.length()) {
			if(tg == cnt) {
				flag = true;
				System.out.printf("%s %d = %s\n",inputStr,tg,String.valueOf(ans));
			}
			cnt++;
			return;
			/*
			 * Test
			 */
//			System.out.print(cnt++ + " ");
//			for(int i = 0; i < ans.length;i++)
//				System.out.print(ans[i] + " ");
//			System.out.println();
		} else {
			for(int i = 0; i < inputStr.length(); i++) {
				if(isVisited[i] == false) {
					isVisited[i] = true;
					ans[L] = inputStr.charAt(i);
					dfs(L + 1,inputStr, tg);
					isVisited[i] = false;
				}
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		String inputStr;
		while((inputStr=br.readLine())!=null) {
			//반복
			st = new StringTokenizer(inputStr, " ");
			
			inputStr = st.nextToken();
			int tg = Integer.parseInt(st.nextToken());
			
			ans = new char[inputStr.length()];
			isVisited = new boolean[inputStr.length()];
			
			dfs(0, inputStr, tg);
			if(flag == false) 
				System.out.printf("%s %d = No permutation\n",inputStr,tg);
			flag = false;
			cnt = 1;
		}
	}

}

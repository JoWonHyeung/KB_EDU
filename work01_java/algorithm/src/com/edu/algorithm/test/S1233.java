package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class S1233 {
	static int N, ans;
	static boolean flag;
	static char[] node;

	static boolean IsOperator(char oper) {
		if(oper == '+' || oper == '-' || oper == '/' || oper == '*') return true;
		else return false;
	}
	
	static void inOrder(int n) {
		if(flag) return;
		if(n > N) {
			return;
		} else {
			inOrder(2 * n);
			if((2 * n <= N) || (2 * n + 1 <= N)) { //자식노드가 있을 경우
				if(!IsOperator(node[n])) { //부모노드는 반드시 연산자이어야 한다.
					ans = 0;
					flag = true;
					return;
				}
			}
			inOrder(2 * n + 1);
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//	TC는 10개로 고정
		for (int tc=1; tc<=10; tc++) {
			N = Integer.parseInt(br.readLine());
			node = new char[N+1];
			ans = 1;
			flag = false;
			
			for (int i=1; i<=N; i++) {
				node[i] = br.readLine().split(" ")[1].charAt(0);
			}
			
			inOrder(1);
			
			System.out.printf("#%d %d\n",tc, ans);
		}
		
	}
}

package com.edu.algorithm.test;

import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B12891 {

	static int Acnt; 
	static int Tcnt; 
	static int Ccnt; 
	static int Gcnt;
	
	static boolean getCheck() {
		return true;
	}
	
	public static void main(String[] args) throws Exception{
	
		/*
		* Input
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		int S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		
		String tmp = st.nextToken();
		
		char[] dna = new char[tmp.length()];
		
		for(int i = 0; i < dna.length; i++)
			dna[i] = tmp.charAt(i);
		
		st = new StringTokenizer(br.readLine(), " ");
		
		Acnt = Integer.parseInt(st.nextToken());
		Tcnt = Integer.parseInt(st.nextToken());
		Ccnt = Integer.parseInt(st.nextToken());
		Gcnt = Integer.parseInt(st.nextToken());
		
		/*
		 * Main code
		 */
		
		int lt = 0;
		int rt = P - 1;
		char[] dnaPart = new char[P];
		
		//초기 부분 문자열 저장
		for(int i = 0; i < P; i++)
			dnaPart[i] = dna[i];
		
		while(rt <= S) { //오른쪽이 끝에 다달하면 탈출
			//if -> 유요한 비밀번호인지 체크(getCheck), cnt++
			
			//슬라이딩
		}
		
		//Result
		
	}
}
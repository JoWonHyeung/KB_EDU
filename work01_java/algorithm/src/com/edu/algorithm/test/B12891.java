package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B12891 {
	static StringBuilder dna;
	static int Acnt; static int Tcnt; 
	static int Ccnt; static int Gcnt;
	static int lt; static int rt;
	static int S;
	
	static boolean getCheck(int initA, int initT,int initC, int initG) {
		if(initA >= Acnt && initT >= Tcnt && initC >= Ccnt && initG >= Gcnt) return true;
		return false;
	}	
	
	public static void main(String[] args) throws Exception{
		/*
		* Input
		*/
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int answer = 0;
		
		st = new StringTokenizer(br.readLine(), " ");
		
		S = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		dna = new StringBuilder(st.nextToken());
		StringBuilder dnaPart =new StringBuilder();
		
		//초기 부분 문자열 초기화
		for(int i = 0; i < P;i++)
			dnaPart.append(dna.charAt(i));
		
		st = new StringTokenizer(br.readLine(), " ");
		
		Acnt = Integer.parseInt(st.nextToken());
		Ccnt = Integer.parseInt(st.nextToken());
		Gcnt = Integer.parseInt(st.nextToken());
		Tcnt = Integer.parseInt(st.nextToken());
		
		/*
		 * Main code
		 */
		lt = 0;
		rt = P;
		
		//초기 문자열 카운트
		int initA = 0;
		int initT = 0;
		int initC = 0;
		int initG = 0;
		
		for(int i = 0; i < dnaPart.length(); i++) {
			if(dnaPart.charAt(i) == 'A') initA++;
			if(dnaPart.charAt(i) == 'T') initT++;
			if(dnaPart.charAt(i) == 'C') initC++;
			if(dnaPart.charAt(i) == 'G') initG++;
		}
	
		while(true) { 
			//비밀번호 유효성 체크
			if(getCheck(initA,initT,initC,initG)) 
				answer++;
			
			//rt == S일때 탈출(Out of range 방지)
			if(rt == S) break;
			
			//DNA 문자 개수 업데이트(슬라이딩)
			
			//add
			if(dna.charAt(rt) == 'A') initA++;
			else if(dna.charAt(rt) == 'T') initT++;
			else if(dna.charAt(rt) == 'C') initC++;
			else if(dna.charAt(rt) == 'G') initG++;
			rt++;
			
			//delete
			if(dna.charAt(lt) == 'A') initA--;
			else if(dna.charAt(lt) == 'T') initT--;
			else if(dna.charAt(lt) == 'C') initC--;
			else if(dna.charAt(lt) == 'G') initG--;
			lt++;
		}
		
		
		System.out.println(answer);
	}
}
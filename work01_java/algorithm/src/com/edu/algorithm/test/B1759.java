package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class B1759 {
	static char[] arr, tempArr;
	static boolean[] isVisited;
	static ArrayList<String> result = new ArrayList<>();
	static int S, C;
	
	static boolean getCheck(char[] tArr) {
		int vols = 0, consonant = 0;
		for(int i = 0; i < tArr.length; i++) {
			if(tArr[i] == 'a' || tArr[i] == 'e' || tArr[i] == 'i' || tArr[i] == 'o' || tArr[i] == 'u') 
				vols++;
			else
				consonant++;
		}
		if(vols >= 1 && consonant >= 2) 
			return true;
		else 
			return false;
	}
	
	static void dfs(int L, int st) {
		if(L == S) {
			if(getCheck(tempArr)) {
				result.add(String.valueOf(tempArr));
			}
		} else {
			for(int i = st; i < C; i++) {
				tempArr[L] = arr[i]; 
				dfs(L + 1, i + 1);	
			}
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		S = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		arr = new char[C];
		tempArr = new char[S];
		isVisited = new boolean[C];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0;i < C; i++)
			arr[i] = st.nextToken().charAt(0);
		
		Arrays.sort(arr);
		
		dfs(0, 0);
		
		for(String s : result)
			System.out.println(s);
	}

}

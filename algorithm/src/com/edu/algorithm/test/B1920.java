package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class B1920 {
	
	static boolean binarySearch(long[] A, long target) {
		int lt = 0, rt = A.length - 1;
		
		while(lt <= rt) {
			int mid = (lt + rt) / 2;
			
			if(target == A[mid]) {
				return true;
			}
			else if(target < A[mid]) {
				rt = mid - 1;
			}else {
				lt = mid + 1;
			}
		}
		return false;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		long[] A = new long[N];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < N; i++)
			A[i] = Long.parseLong(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		long[] B = new long[M];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i = 0; i < M; i++)
			B[i] = Long.parseLong(st.nextToken());
		
		Arrays.sort(A);
		
		/*
		 * Main Code
		 */
		for(int i = 0; i < M; i++) {
			long target = B[i];
			
			if(binarySearch(A, target))
				System.out.println(1);
			else
				System.out.println(0);
		}
	}

}

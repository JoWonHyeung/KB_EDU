package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class kb2반_알고리즘1번_조원형 {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));	//	파일로부터 읽기
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		int[] arr = new int[N];
		
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		
		//	i는 선택한 최대값을 위치시킬 index
		for (int i=0; i<N-1; i++) {
			int maxI = i;
			// j 는 범위에서 최대값 인덱스
			for (int j=i+1; j<N; j++) {
				if (arr[maxI] < arr[j]) {
					maxI = j;
				}
			}
			
			//	최대값을 i 위치로 교환
			int t = arr[maxI];
			arr[maxI] = arr[i];
			arr[i] = t;
			
		}
		
		for(int num : arr)
			System.out.println(num);
	}

}

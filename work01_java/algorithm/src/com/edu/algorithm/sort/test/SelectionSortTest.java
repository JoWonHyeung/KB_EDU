package com.edu.algorithm.sort.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SelectionSortTest {

	public static void main(String[] args) throws IOException {
		//	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("input.txt")));	//	파일로부터 읽기
			StringTokenizer st = new StringTokenizer(br.readLine());

			int N = Integer.parseInt(st.nextToken());
			int[] arr = new int[N];
			st = new StringTokenizer(br.readLine(), " ");
			for (int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			//	i는 선택한 최소값을 위치시킬 index
			for (int i=0; i<N-1; i++) {
				int minI = i;
				// j 는 범위에서 최소값 인덱스
				for (int j=i+1; j<N; j++) {
					if (arr[minI] > arr[j]) {
						minI = j;
					}
				}
				
				//	최소값을 i 위치로 교환
				int t = arr[minI];
				arr[minI] = arr[i];
				arr[i] = t;
				
				//	출력
				StringBuilder ans = new StringBuilder();
				for (int n: arr) ans.append(n+" ");
				System.out.println(ans);
			}
			

		}

}

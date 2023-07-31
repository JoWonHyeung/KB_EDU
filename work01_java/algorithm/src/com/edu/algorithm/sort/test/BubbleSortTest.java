package com.edu.algorithm.sort.test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BubbleSortTest {

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
			
			for (int i=N-1; i>0; i--) {
				for (int j=0; j<i; j++) {
					if (arr[j]>arr[j+1]) {
						int t = arr[j];
						arr[j] = arr[j+1];
						arr[j+1] = t;
					}
				}
				
				//	한 단계 정렬시 출력
				StringBuilder sb = new StringBuilder();
				for (int n: arr) {
					sb.append(n).append(" ");
				}
				System.out.println(sb);
			}				

		}

}

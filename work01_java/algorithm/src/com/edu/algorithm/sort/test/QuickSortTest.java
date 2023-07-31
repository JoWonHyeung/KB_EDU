package com.edu.algorithm.sort.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class QuickSortTest {

	static int[] arr;
	static int[] tarr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int N = Integer.parseInt(st.nextToken());
		arr = new int[N];
		tarr = new int[N];
		for (int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		qsort(0, N-1);	//	0~N-1 까지 오름차순 정렬
//		msort(0, N-1);
		
		StringBuilder ans = new StringBuilder();
		for (int n: arr) ans.append(n).append("\n");
		System.out.println(ans);
	}

	public static void msort(int left, int right) {
		//	[0] 종료조건 체크 => 종료
		if (left==right)	return;
		
		//	[1] 절반을 나눠서, 양쪽을 정렬(msort)
		int m = (left+right)/2;
		msort(left, m);		//	왼쪽정렬
		msort(m+1, right);	//	오른쪽정렬
		
		// 	[2] 합치기
		// 임시 tarr에 원본데이터 복사(지금 병합할 부분만!)
		for (int i=left; i<=right; i++) tarr[i]=arr[i];
		int l=left, r=m+1, i=left;
		// 	[3] 둘 중 하나 소진될때까지 작은값부터 붙임  
		while (l<=m && r<=right) {	//	둘 중 작은값 붙이기
			if (tarr[l]<tarr[r])	arr[i++] = tarr[l++];
			else					arr[i++] = tarr[r++];
		}
		//	[4] 남은 배열의 값 뒤에 붙이기(둘 중 하나만 남아있음)
		while (l<=m) 		arr[i++] = tarr[l++];
		while (r<=right)	arr[i++] = tarr[r++];
		
	}
	
	public static void qsort(int l, int r) {
		// 재귀함수는 시작부분에서 종료조건 체크 및 종료
		if (l>=r) return;
		int p = partition(l, r);	//	p기준 양쪽 정렬
		qsort(l, p-1);				//	왼쪽정렬
		qsort(p+1, r);				//	오른쪽 정렬
	}

	public static int partition(int l, int r) {
		int p = l++;	//	p, l, r 초기값 설정
		while (l<r) {	//	l, r 자리잡고 교환
			//	l, r 위치 잡기
			while(l<r && arr[p]>arr[l]) l++;
			while(l<r && arr[p]<arr[r]) r--;
			
			//  l<r 조건을 만족하지 않아서 탈출했는지 체크필요
			if (l<r) {	// 자리잡았다면 교환!
				int t=arr[l]; arr[l]=arr[r]; arr[r]=t;
			}			
		}
		//	while문 탈출 == (l==r), p만 자리잡고 교환!
		if (arr[p] <= arr[l]) l--;
		int t=arr[p]; arr[p]=arr[l]; arr[l]=t;
		
		return l;		
	}
}

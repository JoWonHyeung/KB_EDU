package com.edu.algorithm.sort.test;

public class MergeSortTest {
	static int[] arr = new int[] {3, 2, 3, 4, 6, 1};
	static int[] tArr = new int[6];
	
	public static void main(String[] args) {	
		mergeSort(0, arr.length - 1);
		
		for(int num : arr)
			System.out.print(num + " ");
		System.out.println();
	}
	
	static void mergeSort(int left, int right) {
		if(left >= right) return;
		int m = (left + right) / 2;
		mergeSort(left, m);
		mergeSort(m + 1, right);
		
		//병합
		for(int i = left; i <= right; i++)
			tArr[i] = arr[i];
		
		int lt = left;
		int rt = m + 1;
		int i = left;
		
		while(lt <= m && rt <= right) {
			if(tArr[lt] < tArr[rt]) arr[i++] = tArr[lt++];
			else arr[i++] = tArr[rt++];
		}
		
		while(lt <= m) arr[i++] = tArr[lt++];
		while(rt <= right) arr[i++] = tArr[rt++];
	}

}

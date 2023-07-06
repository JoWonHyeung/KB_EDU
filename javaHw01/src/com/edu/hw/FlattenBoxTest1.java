package com.edu.hw;

import java.util.Arrays;
import java.util.Scanner;

public class FlattenBoxTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int boxLen = 100;
		for(int tcn = 1; tcn <= tc; tcn++) {
			int dump = sc.nextInt();
			int[ ] boxes = new int[boxLen];
			for(int i=0; i<boxes.length; i++) {
				boxes[i] = sc.nextInt();
			}//초기화
			
			int heighDiff = flatten(boxes,dump);
			System.out.printf("#%d %d%n",tcn, heighDiff);
		}

	}

	static int flatten(int[] boxes, int dump) {
		int[] boxCnt = new int[101];
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		
		for(int num : boxes) {
			boxCnt[num]++;
			if(max < num) max = num;
			if(min > num) min = num;
		}
		
		for(int i = 0; i < dump; i++) {
			//dump작업
			boxCnt[max]--;
			boxCnt[max - 1]++;
			
			boxCnt[min]--;
			boxCnt[min + 1]++;
			
			if(boxCnt[max] == 0) max -= 1;
			if(boxCnt[min] == 0) min += 1;
			
			//차이가 1일 때는 dump횟수가 남아있더라도 탈출한다.
			if(max - min == 1) break;
		}
		
		return max - min;
	}

}













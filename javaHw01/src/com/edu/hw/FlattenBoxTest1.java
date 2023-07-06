package com.edu.hw;

import java.util.Arrays;
import java.util.Scanner;

public class FlattenBoxTest1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 10;
		int boxLen = 100;
		for(int tcn = 1; tcn<=tc; tcn++) {
			int dump = sc.nextInt();
			int[ ] boxes = new int[boxLen];
			for(int i=0; i<boxes.length; i++) {
				boxes[i] = sc.nextInt();
			}//초기화
			
			int heighDiff=flatten(boxes,dump );
			System.out.printf("#%d %d%n",tcn, heighDiff);
		}

	}

	static int flatten(int[] boxes, int dump) {
		
		// 코드구현
		
		return 00;
	}

}













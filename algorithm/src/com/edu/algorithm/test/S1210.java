package com.edu.algorithm.test;

import java.util.Scanner;

public class S1210 {
	static final int N = 10;
	static int[][] map = new int[N][N];
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		for(int i = 1; i <= 10; i++) {
			sc.nextInt();
			int x = 0;
			int y = 0;
			//map 초기화
			for(int m = 0; m < N; m++) {
				for(int k = 0; k < N; k++) { 
					map[m][k] = sc.nextInt();
					if(map[m][k] == 2) {
						x = m;
						y = k;
					}
				}
			}
				
			while(x != 0) {
				if(y - 1 > -1 && map[x][y - 1] == 1) {
					y -= 1;
				}else if(y + 1 < N && map[x][y + 1] == 1) {
					y += 1;
				}else {
					x -= 1;
				}
			}
			
			System.out.printf("#%d %d\n",i,y);
			
		}
	}

}

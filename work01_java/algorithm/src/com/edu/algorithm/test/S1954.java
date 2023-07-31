package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class S1954 {
	static int[] dx = {0,1,0,-1};
    static int[] dy = {1,0,-1,0};
     
    public static void main(String[] args) throws Exception {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st;
    
    	st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        
        for(int i = 1; i <= T; i++) {
        	st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int[][] map = new int[N][N];
            int init = 1;
            int ci = 0; int cj = 0;
            int end = N * N;
            int dr = 0;
             
            map[ci][cj] = init;
             
            while(init < end) {
            	//move
                ci = ci + dx[dr];
                cj = cj + dy[dr];
                 
                //const insert
                init += 1;
                map[ci][cj] = init;
                 
                if(ci + dx[dr] > N - 1 || cj + dy[dr] > N - 1 || ci + dx[dr] < 0 || cj + dy[dr] < 0
                        || map[ci + dx[dr]][cj + dy[dr]] != 0) {
                    dr = (dr + 1) % 4;
                }
            }// (dr + 3) % 4 -> 3 2 1 0 3 2 1 0 .....
             
            System.out.printf("#%d\n",i);
             
            for(int j = 0; j < N; j++) {
                for(int k = 0; k < N; k++) {
                    System.out.print(map[j][k] + " ");
                }
                System.out.println();
            }
             
        }
    }

}

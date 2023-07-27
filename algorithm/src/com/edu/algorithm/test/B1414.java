package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class B1414 {
	
	static int N;
	static int answer;
	static int[][] map;
	static int[] parents;
	static List<Info> infoList = new ArrayList<>();
	
	static class Info implements Comparable<Info>{
		int s, e, length;
		boolean dir; //이후 map에서 (i,j)에 0을 대입할 지, (j, i)에 대입할 지 구별을 위해 dir변수 선언
		
		Info(int s, int e, int length, boolean dir){
			this.s = s;
			this.e = e;
			this.length = length;
			this.dir = dir;
		}
		
		@Override
		public int compareTo(Info info) { //오름차순 정렬
			if(info.length < length) return 1;
			else if(info.length > length) return -1;
			else return 0;
		}

	}
	
	static int Find(int x) {
		if(parents[x] == x) return x;
		else return parents[x] = Find(parents[x]);
	}
	
	static void Union(int a, int b) {
		int x = Find(a);
		int y = Find(b);
		if(x != y) parents[y] = x;
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		map = new int[N + 1][N + 1];
		parents = new int[N + 1];
		
		for(int i = 1; i <= N; i++) parents[i] = i; //Union-find에 사용할 배열 초기화
		
		//[0] 랜선 초기화
		//아스키코드표를 이용하여 문제에서 제시한 값들로 변형해주었다.
		for(int i = 1; i <= N; i++) {
			st = new StringTokenizer(br.readLine());
			String temp = st.nextToken();
			for(int j = 1; j <= N; j++) {
				if('a' <= temp.charAt(j - 1) && temp.charAt(j - 1) <= 'z') map[i][j] = temp.charAt(j - 1) - 96;
				else if('A' <= temp.charAt(j - 1) && temp.charAt(j - 1) <= 'Z') map[i][j] = temp.charAt(j - 1) - 38;
				else map[i][j] = temp.charAt(j - 1) - 48;
			}
		}
		
		//[1] 랜선 길이 && 연결정보 저장
		//map[i][j] 와 map[j][i]의 랜선 중에 짧은 랜선 길이를 List에 저장한다. 
		for(int i = 1; i <= N; i++) {
			for(int j = i + 1; j <= N; j++) {
				if(map[i][j] != 0 && map[j][i] == 0) infoList.add(new Info(i, j, map[i][j], true));
				else if(map[i][j] == 0 && map[j][i] != 0) infoList.add(new Info(i, j, map[j][i], false));
				else if((map[i][j] <= map[j][i])) infoList.add(new Info(i, j, map[i][j], true));
				else if(map[i][j] >= map[j][i]) infoList.add(new Info(i, j, map[j][i], false));
			}
		}
		
		//[2] 오름차순 정렬
		Collections.sort(infoList);
		
		//[3] MST 생성
		for(Info info : infoList) {
			if(map[info.s][info.e] == 0 && map[info.e][info.s] == 0) continue; //(i, j) 와 (j, i)가 0이면 연결될 수 없으니 MST 연산하지 않는다.
			if(Find(info.s) != Find(info.e)) { //부모노드가 다를 경우
				Union(info.s, info.e); //집합 결합
				//사용할 랜선길이는 map에서 0으로 바꿔준다.
				if(info.dir) map[info.s][info.e] = 0;
				else map[info.e][info.s] = 0;
			}
		}
		
		//[3] 반환할 랜선 길이 합구하기
		for(int i = 1; i <= N; i++) {
			for(int j = 1; j <= N; j++) {
				if(map[i][j] != 0)
					answer += map[i][j];
			}
		}
		
		//[4] 조합으로 모든 컴퓨터가 연결되어 있는지 체크한다.
		for(int i = 1; i <= N - 1; i++) {
			for(int j = i + 1; j <= N; j++) {
				if(Find(i) != Find(j)) {
					System.out.println(-1);
					System.exit(0);
				}
			}
		}
		
		//[5] 결과 반환
		System.out.println(answer);
		//System.out.println(Arrays.deepToString(map));
		
	}
}

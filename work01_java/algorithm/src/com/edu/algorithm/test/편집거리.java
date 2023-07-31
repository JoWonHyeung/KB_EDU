package com.edu.algorithm.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class 편집거리 {

	static StringBuilder origin;
	static StringBuilder target;
	static int answer = Integer.MAX_VALUE;

	static class Info{
		StringBuilder str;
		int idx;
		int cnt;
		
		Info(StringBuilder str, int idx, int cnt){
			this.str = str;
			this.idx = idx;
			this.cnt = cnt;
		}

		public int getIdx() {
			return idx;
		}

		public void setIdx(int idx) {
			this.idx = idx;
		}
		
	}
	
	static Info insert(Info info, char c) {
		StringBuilder temp = new StringBuilder(info.str);
		return new Info(temp.insert(info.idx, c), info.idx + 1, info.cnt + 1);
	}
	
	static Info delete(Info info, char c) {	
		StringBuilder temp = new StringBuilder(info.str);
		return new Info(temp.deleteCharAt(info.idx), info.idx, info.cnt + 1);
	}
	
	static Info replace(Info info, char c) {
		StringBuilder temp = new StringBuilder(info.str);
		temp.setCharAt(info.idx, c);
		return new Info(temp, info.idx + 1, info.cnt + 1);
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		origin = new StringBuilder(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		target = new StringBuilder(st.nextToken());
		
		Queue<Info> q = new LinkedList<>();
		int initPos = 0;
		
		for(int i = 0; i < Math.min(origin.length(), target.length()); i++) {
			if(origin.charAt(i) != target.charAt(i)) {
				initPos = i;
				break;
			}
		}
		
		q.add(new Info(origin,initPos,0));
		
		while(!q.isEmpty()) {
			Info now = q.poll();

			if(target.toString().equals(now.str.toString())) {
				answer = Math.min(now.cnt, answer);
				break;
			}
			
			if(target.length() == now.idx || now.str.length() == now.idx) continue;
			if(target.charAt(now.idx) != now.str.charAt(now.idx)) {
				q.add(insert(now, target.charAt(now.idx))); //삽입
				
				q.add(delete(now,target.charAt(now.idx))); //삭제
				
				q.add(replace(now,target.charAt(now.idx))); //교체
			}else { //같을 경우는 그냥 idx, cnt만 넘겨준다
				now.setIdx(now.idx + 1);
				q.add(now);
			}
		
		}
		
		System.out.println(answer);
	}

}

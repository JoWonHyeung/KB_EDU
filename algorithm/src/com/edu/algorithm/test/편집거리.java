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
	static int answer;

	static class Info{
		StringBuilder str;
		int idx;
		int cnt;
		
		Info(StringBuilder str, int idx, int cnt){
			this.str = str;
			this.idx = idx;
			this.cnt = cnt;
		}
		
	}
	
	static Info insert(Info info, char c) {
		return new Info(info.str.insert(info.idx, c), info.idx + 1, info.cnt + 1);
	}
	
	static Info delete(Info info, char c) {		
		return new Info(info.str.deleteCharAt(info.idx), info.idx + 1, info.cnt + 1);
	}
	
	static Info replace(Info info, char c) {
		info.str.setCharAt(info.idx, c);
		return info;
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
			if(origin.charAt(i) != target.charAt(i))
				initPos = i;
		}
		
		
			
		q.add(new Info(origin,initPos,0));
		
		while(!q.isEmpty()) {
			Info now = q.poll();
			if(target.equals(now.str)) {
				answer = now.cnt;
				break;
			}
			

			if(target.charAt(now.idx) != now.str.charAt(now.idx)) {
				q.add(insert(now, target.charAt(now.idx))); //삽입
				
				if(now.str.length() >= target.length() && now.str.length() != 0) 
					q.add(delete(now,target.charAt(now.idx))); //삭제
				
				q.add(replace(now,target.charAt(now.idx))); //추가
			}else { //같을 경우는 그냥 idx, cnt만 넘겨준다
				q.add(new Info(now.str, now.idx + 1, now.cnt + 1));
			}
		
		}
		
		System.out.println(answer);
	}

}

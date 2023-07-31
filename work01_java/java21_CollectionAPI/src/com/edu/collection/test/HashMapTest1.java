package com.edu.collection.test;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class HashMapTest1 {

	public static void main(String[] args) {
		Map<String, Integer> map = new HashMap<>();
		map.put("아이유", 90);
		map.put("박나래", 80);
		map.put("미미", 70);
		map.put("제임스", 85);
		
		System.out.println(map);
		//1. map 안에 있는 사람들의 이름들만 받아옴...keySet()
		Set<String> set = map.keySet();
		System.out.println(set);
		
		//2. 이름에 해당하는 성적들을 출력
		for(String name : set) {
			int score = map.get(name);
			System.out.println(name + " : " + score);
			//System.out.println(name + " : "  + map.get(name));
		}
		
		//3. map에 있는 사람들의 성적들만 받아옴
		Collection<Integer> scores = map.values();;
		System.out.println(scores);
		
		//4. 사람들의 성적의 평균과 최고성적을 구해서 출력
		int totalScore = 0;

		for(String name : set) {
			totalScore += map.get(name);
		}
		
		double avgScore = totalScore / map.size();
		System.out.println("평균 점수 : " + avgScore);
		System.out.println("최고 점수 : " + Collections.max(scores));
		System.out.println("최저 점수 : " + Collections.min(scores));
		
	}

}

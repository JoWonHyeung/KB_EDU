package com.edu.sort.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/*
 * Comparator 방법으로 정렬할 수 있다.
 * Comparable 상속받지 않고
 */
public class ComparableTest3 {

	public static void main(String[] args) {
		ArrayList<Person> plist = new ArrayList<>();
		plist.add(new Person(68,"이순재"));
		plist.add(new Person(23,"제니"));
		plist.add(new Person(53,"엄정화"));
		
		//Arrays.sort(plist);
		Collections.sort(plist, new Comparator<Person>() {
			@Override
			public int compare(Person p1, Person p2) {
				if(p1.getAge() > p2.getAge()) return -1;
				else if(p1.getAge() < p2.getAge()) return 1;
				else return 0;
			}
		});
		
		for(Person p : plist) 
			System.out.println(p.age);
	}

}

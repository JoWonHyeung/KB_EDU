package com.edu.loop.test;

public class BasicLoopTest1 {

	public static void main(String[] args) {
		System.out.println("===for===");
		
		for(int i = 0; i < 10; i++) //여기서 i는 Temporary Variable = Automatically Variable  
			System.out.println("i :" + i);
		
		System.out.println("===while===");
		int i = 10;
		while(i > 0) {
			System.out.println("i : " + i);
			i--;
		}
			
	}

}

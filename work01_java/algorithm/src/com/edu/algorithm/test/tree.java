package com.edu.algorithm.test;

public class tree {

	static char[] spellings = {'X','A','B','C','D','E','F','G','H','I','J'};
	
	static void preOrder(int node) {
		if(node > spellings.length - 1) {
			return;
		}else {
			System.out.print(spellings[node] + " ");
			preOrder(2 * node);
			preOrder(2 * node + 1);
		
		}
	}
	
	static void inOrder(int node) {
		if(node > spellings.length - 1) {
			return;
		}else {
			inOrder(2 * node);
			System.out.print(spellings[node] + " ");
			inOrder(2 * node + 1);
		}
	}
	
	static void postOrder(int node) {
		if(node > spellings.length - 1) {
			return;
		}else {
			postOrder(2 * node);
			postOrder(2 * node + 1);
			System.out.print(spellings[node] + " ");
		}
	}
	
	public static void main(String[] args) {
		
		//전위
		System.out.println("[전위 순회]");
		preOrder(1);
		System.out.println();
		
		//중위
		System.out.println("[중위 순회]");
		inOrder(1);
		System.out.println();
		
		//후위
		System.out.println("[후위 순회]");
		postOrder(1);
		System.out.println();
	}

}

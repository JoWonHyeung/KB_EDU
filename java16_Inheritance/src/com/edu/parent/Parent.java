package com.edu.parent;

//부모 클래스...
public class Parent {
	public String publicVar = "publicVar";
	protected String protectedVar = "protectedVar";
	String var = "var";
	private String privateVar = "privateVar";
	
	public Parent(){}
	
	public void access() {
		System.out.println("Access Modifier Test...");
	}

}

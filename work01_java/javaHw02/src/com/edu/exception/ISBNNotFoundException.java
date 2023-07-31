package com.edu.exception;

public class ISBNNotFoundException extends Exception{
	
	public ISBNNotFoundException() {
		this("ISBNNotFoundException...");
	}
	public ISBNNotFoundException(String message) {
		super(message);
	}

}

package com.edu.exception;

public class DuplicateSSNException extends Exception{

	public DuplicateSSNException(){
		this("This is DuplicateSSNException...");
	}
	
	public DuplicateSSNException(String message) {
		super(message);
	}
}

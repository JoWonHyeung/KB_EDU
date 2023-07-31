package com.edu.exception;

public class QuantityException extends Exception{
	
	public QuantityException() {
		this("QuantityException...");
	}
	public QuantityException(String message) {
		super(message);
	}
	
}

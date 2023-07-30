package com.edu.exception;

public class SSNNotFoundException extends Exception{
	
	public SSNNotFoundException() {
		this("저장된 사람이 존재하지 않습니다...");
	}
	public SSNNotFoundException(String message) {
		super(message);
	}

}

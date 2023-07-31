package com.edu.exception;

public class DuplicatedPersonException extends Exception{
	
	public DuplicatedPersonException() {
		this("이미 존재하는 사람입니다...");
	}
	public DuplicatedPersonException(String message) {
		super(message);
	}

}

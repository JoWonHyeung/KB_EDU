package com.edu.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading2{
	
	public void readFile(String fileName) throws FileNotFoundException, IOException {
		FileReader reader = null;		
		try {
			reader = new FileReader(fileName);
			System.out.println("1. 파일을 잘 찾았습니다...");
		} finally {
			reader.close();
		}
		System.out.println("2. FileReader API...");
	}
}

public class CompileTest3 {

	public static void main(String[] args) throws Exception { 
		FileReading2 fr = new FileReading2();
		
		fr.readFile("C:\\KB_EDU\\doc\\CatchAMouse1.png");
		
		System.out.println("3. readFile() calling...");
	}

}

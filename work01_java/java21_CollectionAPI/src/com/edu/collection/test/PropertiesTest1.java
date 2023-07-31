package com.edu.collection.test;

import java.util.Enumeration;
import java.util.Properties;

//System위에 탑재된 VM관련 환경변수값을 다 출력해보자.
public class PropertiesTest1 {

	public static void main(String[] args) {
		Properties p = System.getProperties();
		
		Enumeration en = p.propertyNames();
		
		while(en.hasMoreElements()) {
			String key = (String)en.nextElement();
			String value = p.getProperty(key);
			
			System.out.println(key + " : " + value);
		}
	}

}

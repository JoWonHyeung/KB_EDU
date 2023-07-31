package com.edu.test;


class ZeroBoom extends Exception{ //가장 정확하게 만들어진 사제 폭탄... 사용자 정의 Exception
	
	ZeroBoom() {
		this("This is ZeroBoom Exception...");
	}
	
	ZeroBoom(String message){
		super(message);
	}
	
}

class User{
	public void go() throws ZeroBoom {
		int i = 10;
		int j = 0;
		
		System.out.println(" 2. go()... 진입");
		//저 밑에 어느 부분에서 연산진행...i/j...j에 0값이 할당되면 안돼...
		//만약에 J가 0이라면 Exception을 발생시킬 것이다...
		if(j == 0) throw new ZeroBoom("분모가 0이면 안됩니다...");
		
		System.out.println("Arithmetic Exception 터짐!!");
	}
}

public class UserException4 {

	public static void main(String[] args) {
		User user = new User();
		System.out.println(" 1. go()...호출...");
		
		try {
			user.go();
		}catch(ZeroBoom e) {
			System.out.println(e.getMessage());
		}
	}

}

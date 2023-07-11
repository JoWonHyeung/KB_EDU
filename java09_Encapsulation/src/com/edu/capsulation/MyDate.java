package com.edu.capsulation;

/*
 * 오늘 날짜를 저장하는 클래스...
 * valid 값만 month, day에 할당되도록 제어문을 사용
 * month 1~12사이의 값만 필드 초기화... / "Invalid Month "
 * day
 * 1,3,5,7,8,10,12월 day 1~31일
 * 4,6,9,11월        day 1~30일
 * 2월               day 1~28일
 * 
 * Encapsulation 작성 Pattern
 * 1. field앞 --- private
 * 2. method(setter | getter)앞 --- public
 * 3. setter메소드 필드초기화 하기 직전에 타당한 값만 필드에 저장되도록 접근을 허용
 */
public class MyDate {
	//private: 같은 클래스에서만 접근을 허용
	private int month;
	private int day;
	
	//생성자의 접근제어자는 public class MyDate를 따라간다.
	//public MyDate() {} //default로 컴파일이 넣어준다.
	
	public String getDate() {
		return month + "-" + day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(1 <= month & month <= 12) {
			this.month = month;
		}else {
			System.out.println("Invalid Day");
			System.exit(0);
		}
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		//값이 많으면 default쪽으로 돌려라
		switch(month) {
			case 1: case 3: case 5:
			case 7: case 8: case 10:
			case 12:
				if(1 <= day & day <= 31)
					this.day = day;
				else
					System.out.println("Invalid Day");
					System.exit(0);
				break;
			case 4: case 6:
			case 9: case 11:
				if(1 <= day & day <= 30)
					this.day = day;
				else
					System.out.println("Invalid Day");
					System.exit(0);
				break;
			case 2:
				if(1 <= day & day <= 28)
					this.day = day;
				else
					System.out.println("Invalid Day");
					System.exit(0);
				break;
		}
	}
}

package com.edu.test;

//추상메소드(구현부가 없고 선언부만으로 이뤄진 메소드)들의 집합
interface Flyer{
	void fly();//무조건 앞에 public abstract가 붙는다.
	void land();
	void takeOff();
}

class Bird implements Flyer{
// 클래스는 구현부를 만들어야만 한다.
	@Override 
	public void fly() {
		System.out.println("Bird fly...");
	}

	@Override
	public void land() {
		System.out.println("Bird land...");
	}

	@Override
	public void takeOff() {
		System.out.println("Bird takeOff...");
	}
	
	public String layEggs() {
		return "알을 까다";
	}
	
}

class SuperMan implements Flyer{

	@Override
	public void fly() {
		System.out.println("SuperMan fly...");
	}

	@Override
	public void land() {
		System.out.println("SuperMan land...");
	}

	@Override
	public void takeOff() {
		System.out.println("SuperMan takeOff...");
	}
	
	public String stopBullet() {
		return "망토로 총알을 막는다";
	}
	
}

//인터페이스는 벤더사와 클라이언트의 규약?

public class InterfaceTest1 {

	public static void main(String[] args) {
		//추상메소드가 있는걸로는 객체를 생성할 수 없다. 하나라도!!..메모리에 못올라간다. -->> 시험문제 무조건 나온다
		//Flyer f = new Flyer();
		
		//인터페이스는 객체 생성시 타입으로서는 존재한다. 왜냐하면, 부모이기 때문이다. 
		//다형성
		Flyer b = new Bird();
		Flyer s = new SuperMan();
		
		b.fly();
		s.fly();
		
	}

}

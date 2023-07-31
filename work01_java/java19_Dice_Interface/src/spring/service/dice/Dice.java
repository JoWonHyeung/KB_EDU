package spring.service.dice;

//DiceA, DiceB, DiceC 클래스가 가지고 있는 핵심기능의 Template or 추상메소드
public interface Dice {
	void selectedNumber();
	int getValue();
}

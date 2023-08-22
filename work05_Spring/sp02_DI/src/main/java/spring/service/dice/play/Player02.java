package spring.service.dice.play;

import spring.service.dice.Dice;
import spring.service.dice.DiceA;
import spring.service.dice.impl.DiceAImpl;

/*
 *	FileName : Player01.java
 *	ㅇ DiceA 을 가지고(?, has a :: Association Relationship)있는 Player Object Modeling
 *  ㅇDiceA 를 사용 합을 리턴하는 Method 정의  
 */
public class Player02 {
	
	///Field
	private Dice dice;
	private int totalValue;
	private String message;
	
	///Constructor Method
	public Player02() {
	}
	
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Player02(Dice dice) {
		this.dice = dice;
	}
	
	public Dice getDice() {
		return dice;
	}

	//<property name="dice" ref="diceC" />
	public void setDice(Dice dice) {
		this.dice = dice;
	}

	public int getTotalValue() {
		return totalValue;
	}
	
	public void setTotalValue(int totalValue) {
		this.totalValue = totalValue;
	}
	
	//==> count 만큼 주사위를 굴려서 합을 후하는 행위
	public void playDice(int count){
		
		System.out.println("==>"+getClass().getName()+".playDice() start....");

		for (int i = 0; i < count; i++) {
			dice.selectedNumber();
			System.out.println("::[ "+dice.getClass().getName()+" ] 의 선택된수 : "+dice.getValue());
			totalValue += dice.getValue(); 
		}
		
		System.out.println("==>"+getClass().getName()+".playDice() end....");
	}
	
	

}//end of class
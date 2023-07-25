package spring.service.dice.play;

import spring.service.dice.Dice;
import spring.service.dice.DiceA;

/*
 *	FileName : Player01.java
 *	ㅇ DiceA 을 가지고(?, has a :: Association Relationship)있는 Player Object Modeling
 *  ㅇ DiceA 를 사용 합을 리턴하는 Method 정의  
 */
public class Player03 {
	
	///Field 
	private Dice dice; //재사용성(유지보수)이 낮은 코드!!! 주사위 하나가 추가되면 플레이어가 추가되어야 한다.
	private int totalValue;
	
	///Constructor Method
	public Player03() {
	}
	
	///Method (getter/setter)
	public Dice getDice() {
		return dice;
	}
	
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
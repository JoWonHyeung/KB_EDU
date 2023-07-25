package spring.service.dice.play;

import spring.service.dice.Dice;

/*
	주사위를 추가할 때마다 코드를 수정하는 것이 아닌
	재사용성(유지보수성)이 높은 코드를 작성
	::
	인터페이스를 Hasing 하는 관계를 만든다.
	::
	Loose한 결합도!!!
 */
public class Player02 {
	
	///Field 
	private Dice dice; //재사용성(유지보수)이 낮은 코드!!! 주사위 하나가 추가되면 플레이어가 추가되어야 한다.
	private int totalValue;
	
	///Constructor Method
	public Player02() {}
	public Player02(Dice dice) {
		super();
		this.dice = dice;
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
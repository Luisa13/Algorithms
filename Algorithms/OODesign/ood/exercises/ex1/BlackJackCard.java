package ood.exercises.ex1;

public class BlackJackCard extends Card{

	public BlackJackCard(Suit s, int v) {
		super(v, s);
	}
	
	/**
	 * Returns the value of a card n BlackJack where all the 
	 * figures count as 10
	 * */
	@Override
	public int getValue() {
		if(this.getValue() >= 10)
			return 10;
		
		return this.getValue();
	}

}

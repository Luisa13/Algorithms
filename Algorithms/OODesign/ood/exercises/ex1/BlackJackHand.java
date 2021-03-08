package ood.exercises.ex1;

import java.util.List;

/**
 * BlackJack version of a hand of cards
 * 
 * @param BlackJackCard
 * @author luisa
 * */
public class BlackJackHand extends Hand<BlackJackCard>{

	private final static int MAXSCORE = 21;
	private boolean ASValue;
	
	public BlackJackHand(List<BlackJackCard> myHand) {
		super(myHand);
	}
	
	public void setASValue(boolean value) {
		this.ASValue = value;
	}
	
	@Override
	public int score() {
		int score = 0;
		
		for(BlackJackCard card: cards) {
			if(card.getValue() == 1 && ASValue)
				score += 11;
			else
				score += card.getValue();
		}
		return score;
	}
	
	/**
	 * Returns true if the player of this hand is the winner, taking 
	 * into account the final decision about the AS value
	 * 
	 * @param boolean
	 * @param BlackJackHand
	 * @return boolean
	 * */
	public boolean isTheWinner(boolean valueAS, BlackJackHand cruppier) {
		this.ASValue = valueAS;
		return this.isTheWinner(cruppier);
	}
	
	/**
	 * Returns true if the player of this hand is the winner.
	 * 
	 * @param BlackJackHand
	 * @return boolean
	 * */
	private boolean isTheWinner(BlackJackHand cruppier) {
		int score = this.score();
		if(score > MAXSCORE)
			return false;
		
		//int playerProx = MAXSCORE - score;
		//int crupProx = MAXSCORE - cruppier.score();
		
		if(score < cruppier.score())
			return false;
		
		
		if(score == cruppier.score() && 
				this.cards.size() > cruppier.cards.size())
			return false;
		
		return true;
	}
}

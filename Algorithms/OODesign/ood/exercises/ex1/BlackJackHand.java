package ood.exercises.ex1;

import java.util.List;

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
	public boolean isTheWinner(boolean valueAS, BlackJackHand cruppier) {
		this.ASValue = valueAS;
		return this.isTheWinner(cruppier);
	}
	
	
	private boolean isTheWinner(BlackJackHand cruppier) {
		int score = this.score();
		if(score > MAXSCORE)
			return false;
		
		int playerProx = MAXSCORE - score;
		int crupProx = MAXSCORE - cruppier.score();
		
		if(playerProx < crupProx)
			return false;
		
		if(playerProx == crupProx && 
				this.cards.size() > cruppier.cards.size())
			return false;
		
		return true;
	}
}

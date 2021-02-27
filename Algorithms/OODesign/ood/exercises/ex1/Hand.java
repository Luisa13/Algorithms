package ood.exercises.ex1;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * */
public abstract class Hand<T extends Card> {

	protected List<T> cards;
	
	public Hand() {
		 this.cards = new ArrayList<>();
	 }
	
	public Hand(List<T> myHand) {
		this.cards = myHand;
	}
	
	public void add(T card) {
		this.cards.add(card);
	}
	
	public Card giveAway() {
		return this.cards.remove(0);
	}
	
	public abstract int score();
}

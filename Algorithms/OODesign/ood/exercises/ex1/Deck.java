package ood.exercises.ex1;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import ood.exercises.ex1.Card.Suit;

/**
 * Represent a deck of cards that must be specified.
 * @param <T>
 * @author luisa
 * */

public class Deck <T extends Card>{
	private List<T> myDeck;
	private List<T> ruledOut;
	private static final int  MAX_CARDS = 12;
	private Class<T> type;
	
	public Deck(Class<T> t) {
		this.type = t;
		this.myDeck = new ArrayList<T>();
		this.ruledOut = new ArrayList<T>();
		
		for(Suit suit: Suit.values() ) {
			for(int value = 1; value<= MAX_CARDS; value++) {
					try {
						// TODO: Implement Factory Method to fix this?
						T card = type.getDeclaredConstructor().newInstance(value, suit);
						this.myDeck.add(card);
					} catch (IllegalArgumentException | InstantiationException | 
							IllegalAccessException | InvocationTargetException | 
							NoSuchMethodException | SecurityException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} 
			}

		}
	}
	
	
	
	/**
	 * Gets the deck of card
	 * */
	public List<T> getDeck(){
		return this.myDeck;
	}
	
	/**
	 * Shuffle the deck of cards
	 * */
	public void shuffle() {
		Collections.shuffle(this.myDeck);
	}
	

	/**
	 * Delivers a whole set that contains the number of card defined in the 
	 * parameter to a player. Note that the deck might be not shuffled.
	 * 
	 * @param int
	 * @return List<T>
	 * */
	public List<T> deliverHand (int NCards){
		List<T> list = new ArrayList<T>();
		
		for(int i=0; i<NCards; i++) {
			T card = this.myDeck.remove(i);
			card.isAvailable(false);
			this.ruledOut.add(card);
			list.add(card);
		}
		
		return list;
	}
	
	/**
	 * Gives a card to a player
	 * 
	 * @return T
	 * */
	public T handOverACard() {
		T card = this.myDeck.remove(0);
		card.isAvailable(false);
		this.ruledOut.add(card);
		
		return card;
	}
	
	/**
	 * Returns the number of cards available that left in the deck.
	 * 
	 * @return int
	 * */
	public int howManyLeft() {
		return this.myDeck.size();
	}
	
}

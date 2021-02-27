package ood.exercises.ex1;

/**
 * Represent a French style card to play any game such as poker, black jack,...
 * 
 * Notice this class is abstract, that is because the value of every card will 
 * depend on the game is playing, so if any other class extends this one, should 
 * be force to provide a specific implementation for it
 * 
 * @author luisa
 * */


public abstract class Card {

	public enum Suit {DIAMOND, CLUB, SWORD, HEART};
	
	private Suit suit;
	private boolean available;
	private int value;
	
	/**
	 * 
	 * */
	public Card () {
		this.available = true;
		this.suit = null;
	}
	/**
	 * 
	 * */
	public Card(int value, Suit suit) {
		this.suit = suit;
		this.value = value;
	}
	
	/**
	 * 
	 * */
	public Suit getSuit() {
		return this.suit;
	}
	
	/**
	 * 
	 * */
	public boolean isAvailable() {
		return this.available;
	}
	
	/**
	 * 
	 * */
	public void isAvailable(boolean state) {
		this.available = state;
	}
	
	public abstract int getValue();
}

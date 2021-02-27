package ood.app;

import ood.exercises.ex1.BlackJackCard;
import ood.exercises.ex1.BlackJackHand;
import ood.exercises.ex1.Deck;

public  class BlackJackGame {


	public static void main(String args[]) {
		Deck<BlackJackCard> bjCards = new Deck<>(BlackJackCard.class);
		bjCards.shuffle();
		BlackJackHand hand = new BlackJackHand(bjCards.deliverHand(2));
		BlackJackHand hand2 = new BlackJackHand(bjCards.deliverHand(2));
		System.out.print(hand.score());
	}

}

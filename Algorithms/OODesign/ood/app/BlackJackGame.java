package ood.app;

import java.util.Scanner;

import ood.exercises.ex1.BlackJackCard;
import ood.exercises.ex1.BlackJackHand;
import ood.exercises.ex1.Deck;

public  class BlackJackGame {


	public static void main(String args[]) {
		Deck<BlackJackCard> bjCards = new Deck<>(BlackJackCard.class);
		bjCards.shuffle();
		BlackJackHand hand = new BlackJackHand(bjCards.deliverHand(2));
		BlackJackHand hand2 = new BlackJackHand(bjCards.deliverHand(2));
		Scanner sc = new Scanner(System.in);
		
		//==========================================

		System.out.println("LET'S PLAY");
		System.out.println("Your score is: " + hand.score() + 
				"\nAnother card? (y/n)");
		String response = sc.next();
		
		while(response.equals("y")) {
			hand.add(bjCards.handOverACard());
			System.out.println("Your score is: " + hand.score() + 
					"\nAnother card? (y/n): ");
			response = sc.next();
		}
		
		
		
		
		System.out.println("Player: " + hand.score());
		System.out.println("Cruppier: " + hand2.score());
		if(hand.isTheWinner(false, hand2)) {
			System.out.print("Congrats! You have won!!");
		}
		else {
			System.out.print("Cruppier won...");
		}
	}

}

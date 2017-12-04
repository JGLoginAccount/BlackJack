package com.lmig.gfc.blackjack.modes;

import java.util.ArrayList;

public class Hand {

	private ArrayList<Card> hand;

	public Hand() {
		hand = new ArrayList<Card>();
	}

	public void dealUser(Card card1, Card card2) {
		hand.add(card1);
		hand.add(card2);
	}

	public void hitUser(Card card1) {
		hand.add(card1);
	}

	public boolean isBust() {
 
		if (getScore() > 21) {  
			return true;
		} 
		return false;
	}

	public int getScore() {
		int currentHand = 0;
		for (int i = 0; i < hand.size(); i += 1) {
			currentHand = hand.get(i).cardValue + currentHand;
		}

		if (currentHand > 21) {

			for (int i = 0; i < hand.size(); i += 1) {
				if (hand.get(i).cardValue == 11) {
					currentHand-=10;
					if (currentHand<21) {
						break;
					}
				}
				
			} 
			
		}

		return currentHand;
	}

	public boolean isBlackJack() {
		if (getScore() == 21) {
			return true;
		}
		return false;
	}

	public void discard() {
		hand.clear();
	}

	public Card pullHole() {

		return hand.get(0);
	}

}

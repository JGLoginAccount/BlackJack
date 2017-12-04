package com.lmig.gfc.blackjack.modes;

import java.util.ArrayList;
import java.util.Stack;

public class Deck {

	Stack<Card> deckOfCards;

	public Deck() {
		deckOfCards = new Stack<Card>();
		createCards();
		shuffle();
	}
	
	public void createCards() {
		Card card;

		for (int j = 0; j < 4; j++) {
			for (int i = 0; i < 13; i++) {

				if (i == 0) {
					card = new AceCard(j, i);
				} else if (i > 10 || i == 1) {
					card = new FaceCard(j, i);
				} else {
					card = new NumberCard(j, i);
				}

				card.addCard(deckOfCards);
			}
		}

	}

	public void shuffle() {

		Card[] shuffledCards = new Card[deckOfCards.size()];
		ArrayList<Integer> currentUse = new ArrayList<Integer>();
		int z = 0;

		for (int i = 0; i < deckOfCards.size(); i++) {

			double x = Math.random() * 52;

			z = (int) x;
			boolean checkCards = true;

			while (checkCards) {
				if (currentUse.contains(z)) {
					x = Math.random() * 52;

					z = (int) x;
				} else {
					checkCards = false;
				}

			}
			currentUse.add(z);

			shuffledCards[i] = deckOfCards.elementAt(z);

		}

		deckOfCards.clear();

		for (int i = 0; i < shuffledCards.length; i++) {

			deckOfCards.push(shuffledCards[i]);

		}
	}

	public Card deal() {
		return deckOfCards.pop();

	}

}

package com.lmig.gfc.blackjack.modes;

import java.util.Stack;

public class Card {

	private String suit;
	public int cardValue;
	protected String faceValue;
	private String suits []= {"Hearts","Clubs","Spades","Diamonds"};

	public Card(int j, Integer i) {
	
			cardValue = i;
			suit = suits[j];
			faceValue = i.toString();

	}

	public void addCard(Stack<Card> deck) {
		deck.push(this);
	}
	
	
	public void setAceValue() {}

}

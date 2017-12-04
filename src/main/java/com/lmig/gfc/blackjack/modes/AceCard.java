package com.lmig.gfc.blackjack.modes;

public class AceCard extends Card {

	public AceCard(int j, int i) {
		super(j, i);
		
		faceValue = "A";
		this.cardValue=11;
	}
	
}

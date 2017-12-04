package com.lmig.gfc.blackjack.modes;

public class FaceCard extends Card {

	public FaceCard(int j, int i) {
		super(j, i);
		
		if (cardValue == 1) {
			faceValue = "Jack";
		}
		if (cardValue == 11) {
			faceValue = "Queen";
		}
		if (cardValue == 12) {
			faceValue = "King";
		}
		
		this.cardValue=10;
	}

}

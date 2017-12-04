package com.lmig.gfc.blackjack.modes;

public class Dealer extends SittingPlayers {

	public Dealer() {
		super();
	}

	@Override
	public void hitUser(Card card1) {
		if (getScore() > 16) {
		} else {
			hand.hitUser(card1);
		}
	}
	

	
	public Card pullHole() {
		return hand.pullHole();
	}


}

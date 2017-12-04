package com.lmig.gfc.blackjack.modes;

public class SittingPlayers {

	protected Hand hand;
	
	public SittingPlayers() {
	hand=new Hand();
	}
	
	public void dealUser(Card card1, Card card2) {
		hand.dealUser(card1, card2);
	}
	
	public void hitUser(Card card1) {
		hand.hitUser(card1);
	}
	
	public boolean isBust() {
		return hand.isBust();
	}
	
	public int getScore() {
		return hand.getScore();
	}
	
	public void discard() {
		hand.discard();
	}
	
	public boolean isBlackJack() {
		if (getScore() == 21) {
			return true;
		}
		return false;
	}
	
}

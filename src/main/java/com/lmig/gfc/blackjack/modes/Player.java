package com.lmig.gfc.blackjack.modes;


public class Player extends SittingPlayers {
	
	private double bank;
	
	public Player(double bank) {
	super();
	this.bank=bank;
	}
	
	public void userBet(double bet) {
		bank=bank-bet;
	}
	
	public double getBank() {
		return bank;
	}
	
	public void setBank(double winnings) {
		bank=bank+winnings;
	}


	

}

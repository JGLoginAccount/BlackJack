package com.lmig.gfc.blackjack.modes;

import java.util.EmptyStackException;

public class BlackJackGame {

	Deck deck;
	Player player;
	Dealer dealer;
	boolean deal;
	boolean outOfMoney;
	boolean gameOn;
	boolean Over;
	String results = "";
	Double resultsAmt;
	boolean outOfCards;
	double bet = 0;

	public BlackJackGame() {
		deck = new Deck();
		player = new Player(500);
		dealer = new Dealer();
		deal = true;
		Over = false;
		outOfCards = false;
		outOfMoney = false;
		gameOn = false;
	}

	public void deal(double userBet) {
		getGoing(userBet);
		deal = false;
	}
	
	public void reDeal(double userBet) {
		player.discard();
		dealer.discard();
		results = "";
		getGoing(userBet);
		Over = false;

	}
 
	public void getGoing(double userBet) {
		try {
			player.dealUser(deck.deal(), deck.deal());
			dealer.dealUser(deck.deal(), deck.deal());
			gameOn = true;

		} catch (EmptyStackException e) {
			outOfCards = true;
		}
		if (userBet > player.getBank()) {
			userBet = player.getBank();
		}
		bet = userBet;
		player.userBet(userBet);
		if (player.isBlackJack()) {
			gameOver();
		}

	}

	public void hit() {
		try {
			player.hitUser(deck.deal());
		} catch (EmptyStackException e) {
			outOfCards = true;
		}

		if (player.isBust()) {
			gameOver();
		}
		if (player.isBlackJack()) {
			gameOver();
		}
	}

	public void stay() {

		while (dealer.getScore() < 17) {
			try {
				dealer.hitUser(deck.deal());
			} catch (EmptyStackException e) {
				outOfCards = true;
				break;
			}

		} 
		gameOver();
	}
 


	public boolean gameOver() {
		gameOn = false;
		payUser();
		return true;
	}

	public void payUser() {

		Over = true;

		if (player.isBlackJack() && dealer.isBlackJack()) {
			resultsAmt = bet * 2;
			player.setBank(resultsAmt);

			results = "Mutual Black Jack.  Player wins $" + resultsAmt.toString();
		} else if (player.isBlackJack() && !dealer.isBlackJack()) {
			resultsAmt = bet * 2.5; 
			player.setBank(resultsAmt);
			results = "Player wins, BlackJack.  Player wins $" + resultsAmt.toString();
		} else if (player.getScore() > dealer.getScore() && !player.isBust()) {
			resultsAmt = bet * 2;
			player.setBank(resultsAmt); 
			results = "Player wins $" + resultsAmt.toString();
		} else if (player.getScore() == dealer.getScore()) {
			player.setBank(bet);
			results = "Its a push!  Players bank is unchanged.";
		} else if (dealer.isBust()) {

			resultsAmt = bet * 2;
			results = "Dealer Busts.  Player wins $" + resultsAmt.toString();
			player.setBank(resultsAmt);
		} else if (player.isBust()) {
			resultsAmt = bet;
			results = "Player Busts. Player loses $" + resultsAmt.toString();
		} else {
			resultsAmt = bet;
			results = "Dealer wins. Player loses $" + resultsAmt.toString();

		}
		bet = 0;

		if (player.getBank() < 1) {
			results="User is out of money.";
			outOfMoney = true;
		}

	}


}
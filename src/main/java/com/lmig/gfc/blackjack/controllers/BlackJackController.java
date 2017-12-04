package com.lmig.gfc.blackjack.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
  
import com.lmig.gfc.blackjack.modes.BlackJackGame;

@Controller
public class BlackJackController {

	BlackJackGame game;
 
	public BlackJackController() {
		resetGame() ;
	}
	
	public void resetGame() {
		game = new BlackJackGame();
	}

	@GetMapping("/") 
	public ModelAndView checkDeck() { 
		return sendMAndV();
	}  
 
	@PostMapping("/deal")
	public ModelAndView dealCards(double userBet) {
		game.deal(userBet);
		return sendMAndV(); 
	}

	@PostMapping("/hit")
	public ModelAndView hitUser() {
		game.hit();
		return sendMAndV();
	}

	@PostMapping("/stay")
	public ModelAndView stay() {
		game.stay();
		return sendMAndV();
	}

	@PostMapping("/redeal")
	public ModelAndView redeal(double userBet) {
		game.reDeal(userBet);
		return sendMAndV();
	}
	
	@PostMapping("/resetGame")
	public ModelAndView resetGameController() {
		resetGame();
		return sendMAndV();
	}

	public ModelAndView sendMAndV() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("main/main");
		mv.addObject("game", game);
		return mv;
	}

}

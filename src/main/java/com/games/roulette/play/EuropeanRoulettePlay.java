package com.games.roulette.play;

import java.math.BigDecimal;

import com.games.roulette.IPocketType;
import com.games.roulette.IRoulettePlay;
import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Customer;
import com.games.roulette.domainobject.Winnings;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.EuropeanRoulette;
import com.games.roulette.util.InvalidNumberPocketType;
import com.games.roulette.util.NumberPocketType;
import com.games.roulette.util.OddEvenNumberPocketType;

/**
 * This class is used to play Roulette as is played in Europe
 *
 */
public class EuropeanRoulettePlay implements IRoulettePlay {

	Customer customer;
	Bet bet;
	IPocketType betPocket;
	EuropeanRoulette europeanRoulette;
	
	public void initialize()
	{
		customer = new Customer("John", "Smith");
		bet = new Bet();
		europeanRoulette = new EuropeanRoulette();
	}
	

	@Override
	public void customerPlayRouletteLosing£10BetPound() {

		betPocket = NumberPocketType.SEVEN;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer places a bet of £10 on a pocket");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.FIVE);
			
			Winnings winnings = europeanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands in a losing pocket");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");
	}

	@Override
	public void customerPlayRouletteWinning£10BetPound() {
		betPocket = NumberPocketType.SEVEN;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer places a bet of £10 on a pocket");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.SEVEN);
			
			Winnings winnings = europeanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands in a losing pocket");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");
	}

	@Override
	public void customerDisallowedToPlayAsBetPlacedIs£0() {
		betPocket = NumberPocketType.SEVEN;
		bet.setBetAmount(new BigDecimal(0));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet");
		System.out.println("That bet is less than or equal to £0");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.SEVEN);
			
			europeanRoulette.play();
			
		} catch (RouletteGameException e) {
			System.out.println("Customer gets a messsage : "+e.getMessage());
		}		
		System.out.println("");		
	}

	@Override
	public void customerDisallowedToPlayAsBetOnInvalidPocket() {
		betPocket = InvalidNumberPocketType.FORTY;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet");
		System.out.println("A customer has selected an invalid pocket");
		
		try {
			europeanRoulette.play();
			
		} catch (RouletteGameException e) {
			System.out.println("Customer gets a messsage : "+e.getMessage());
		}		
		System.out.println("");				
	}

	@Override
	public void customerPlays£10OnOddOrEvenAndBallLandsOnZero() {

		betPocket = OddEvenNumberPocketType.ODD;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on odd or even");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.ZERO);
			
			Winnings winnings = europeanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands in pocket 0");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");		
	}

	@Override
	public void customerPlays£10OnEvenAndBallLandsOnEven() {

		betPocket = OddEvenNumberPocketType.EVEN;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on even");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.TWENTYTWO);
			
			Winnings winnings = europeanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands on an even pocket");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");		
	}

	@Override
	public void customerPlays£10OnEvenAndBallLandsOnOdd() {

		betPocket = OddEvenNumberPocketType.EVEN;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on even");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.TWENTYFIVE);
			
			Winnings winnings = europeanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands on an odd pocket");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");				
	}

	@Override
	public void customerPlays£10OnOddAndBallLandsOnEven() {

		betPocket = OddEvenNumberPocketType.ODD;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on odd");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.THIRTYSIX);
			
			Winnings winnings = europeanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands on an even pocket");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");						
	}

	@Override
	public void customerPlays£10OnOddAndBallLandsOnOdd() {

		betPocket = OddEvenNumberPocketType.ODD;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on odd");
		
		try {
			europeanRoulette.setBallLandingPocket(NumberPocketType.TWENTYTHREE);
			
			Winnings winnings = europeanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands on an odd pocket");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");						
	}

	public static void main(String[] args) {
		
		EuropeanRoulettePlay europeanRoulettePlay = new EuropeanRoulettePlay();
		
		europeanRoulettePlay.initialize();
		
		System.out.println("\nPlaying European Roulette\n");
		
		System.out.println("Stage 1\n");
		europeanRoulettePlay.customerPlayRouletteLosing£10BetPound();
		europeanRoulettePlay.customerPlayRouletteWinning£10BetPound();
		
		System.out.println("Stage 2\n");
		europeanRoulettePlay.customerDisallowedToPlayAsBetPlacedIs£0();
		europeanRoulettePlay.customerDisallowedToPlayAsBetOnInvalidPocket();
		
		System.out.println("Stage 3\n");
		europeanRoulettePlay.customerPlays£10OnOddOrEvenAndBallLandsOnZero();
		europeanRoulettePlay.customerPlays£10OnEvenAndBallLandsOnEven();
		europeanRoulettePlay.customerPlays£10OnEvenAndBallLandsOnOdd();
		europeanRoulettePlay.customerPlays£10OnOddAndBallLandsOnEven();
		europeanRoulettePlay.customerPlays£10OnOddAndBallLandsOnOdd();		
	}	
}
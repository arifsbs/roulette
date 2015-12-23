package com.games.roulette.play;

import java.math.BigDecimal;

import com.games.roulette.IPocketType;
import com.games.roulette.IRoulettePlay;
import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Customer;
import com.games.roulette.domainobject.Winnings;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.AmericanRoulette;
import com.games.roulette.util.InvalidNumberPocketType;
import com.games.roulette.util.NumberPocketType;
import com.games.roulette.util.OddEvenNumberPocketType;

/**
 * This class is used to play Roulette as is played in America
 *
 */
public class AmericanRoulettePlay implements IRoulettePlay {

	Customer customer;
	Bet bet;
	IPocketType betPocket;
	AmericanRoulette americanRoulette;
	
	public void initialize()
	{
		customer = new Customer("John", "Smith");
		bet = new Bet();
		americanRoulette = new AmericanRoulette();
	}
	

	@Override
	public void customerPlayRouletteLosing£10BetPound() {

		betPocket = NumberPocketType.SEVEN;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(betPocket);
		customer.setBet(bet);
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer places a bet of £10 on a pocket");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.FIVE);
			
			Winnings winnings = americanRoulette.play();
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer places a bet of £10 on a pocket");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.SEVEN);
			
			Winnings winnings = americanRoulette.play();
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet");
		System.out.println("That bet is less than or equal to £0");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.SEVEN);
			
			americanRoulette.play();
			
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet");
		System.out.println("A customer has selected an invalid pocket");
		
		try {
			americanRoulette.play();
			
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on odd or even");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.ZERO);
			
			Winnings winnings = americanRoulette.play();
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on even");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.TWENTYTWO);
			
			Winnings winnings = americanRoulette.play();
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on even");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.TWENTYFIVE);
			
			Winnings winnings = americanRoulette.play();
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on odd");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.THIRTYSIX);
			
			Winnings winnings = americanRoulette.play();
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
		americanRoulette.placeBet(customer.getBet());
		
		System.out.println("A customer has placed a bet of £10 on odd");
		
		try {
			americanRoulette.setBallLandingPocket(NumberPocketType.TWENTYTHREE);
			
			Winnings winnings = americanRoulette.play();
			System.out.println("The roulette wheel is spun and the ball lands on an odd pocket");
			
			System.out.println("The customer receives £"+winnings.getWinnings()+" winnings");
			
		} catch (RouletteGameException e) {
			System.out.println("Error while processing "+e.toString());
		}		
		System.out.println("");						
	}

	public static void main(String[] args) {
		
		AmericanRoulettePlay americanRoulettePlay = new AmericanRoulettePlay();
		
		americanRoulettePlay.initialize();
		
		System.out.println("\nPlaying American Roulette\n");
		
		System.out.println("Stage 1\n");
		americanRoulettePlay.customerPlayRouletteLosing£10BetPound();
		americanRoulettePlay.customerPlayRouletteWinning£10BetPound();
		
		System.out.println("Stage 2\n");
		americanRoulettePlay.customerDisallowedToPlayAsBetPlacedIs£0();
		americanRoulettePlay.customerDisallowedToPlayAsBetOnInvalidPocket();
		
		System.out.println("Stage 3\n");
		americanRoulettePlay.customerPlays£10OnOddOrEvenAndBallLandsOnZero();
		americanRoulettePlay.customerPlays£10OnEvenAndBallLandsOnEven();
		americanRoulettePlay.customerPlays£10OnEvenAndBallLandsOnOdd();
		americanRoulettePlay.customerPlays£10OnOddAndBallLandsOnEven();
		americanRoulettePlay.customerPlays£10OnOddAndBallLandsOnOdd();		
	}	
}
package com.games.roulette.impl.us.it;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.games.roulette.IPocketType;
import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Customer;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.AmericanRoulette;
import com.games.roulette.util.NumberPocketType;
import com.games.roulette.util.OddEvenNumberPocketType;

public class USRouletteOddEvenPocket£10PoundBetBallInZeroPocketIT {

	Customer customer;	
	Bet bet;
	AmericanRoulette americanRoulette;
	IPocketType pocket;
	
	@Before
	public void placeBet()
	{
		customer = new Customer("John", "Smith");		
		bet = new Bet();
		bet.setBetAmount(new BigDecimal(10));		
		americanRoulette = new AmericanRoulette();		
	}
	
	
	@Test
	public void playOdd() throws RouletteGameException
	{
		pocket = OddEvenNumberPocketType.ODD;
		bet.setPocket(pocket);
		customer.setBet(bet);
		americanRoulette.placeBet(customer.getBet());		
		
		americanRoulette.setBallLandingPocket(NumberPocketType.ZERO);
		assertEquals(new BigDecimal(0), americanRoulette.play().getWinnings());
	}

	@Test
	public void playEven() throws RouletteGameException
	{
		pocket = OddEvenNumberPocketType.EVEN;
		bet.setPocket(pocket);
		customer.setBet(bet);
		americanRoulette.placeBet(customer.getBet());		
		
		americanRoulette.setBallLandingPocket(NumberPocketType.ZERO);
		assertEquals(new BigDecimal(0), americanRoulette.play().getWinnings());
	}	
}
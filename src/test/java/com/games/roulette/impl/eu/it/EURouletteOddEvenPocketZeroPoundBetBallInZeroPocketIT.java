package com.games.roulette.impl.eu.it;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.games.roulette.IPocketType;
import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Customer;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.EuropeanRoulette;
import com.games.roulette.util.NumberPocketType;
import com.games.roulette.util.OddEvenNumberPocketType;

public class EURouletteOddEvenPocketZeroPoundBetBallInZeroPocketIT {

	Customer customer;	
	Bet bet;
	EuropeanRoulette europeanRoulette;
	IPocketType pocket;
	
	@Before
	public void placeBet()
	{
		customer = new Customer("John", "Smith");		
		bet = new Bet();
		bet.setBetAmount(new BigDecimal(10));		
		europeanRoulette = new EuropeanRoulette();		
	}
	
	
	@Test
	public void playOdd() throws RouletteGameException
	{
		pocket = OddEvenNumberPocketType.ODD;
		bet.setPocket(pocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());		
		
		europeanRoulette.setBallLandingPocket(NumberPocketType.ZERO);
		assertEquals(new BigDecimal(0), europeanRoulette.play().getWinnings());
	}

	@Test
	public void playEven() throws RouletteGameException
	{
		pocket = OddEvenNumberPocketType.EVEN;
		bet.setPocket(pocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());		
		
		europeanRoulette.setBallLandingPocket(NumberPocketType.ZERO);
		assertEquals(new BigDecimal(0), europeanRoulette.play().getWinnings());
	}	
}
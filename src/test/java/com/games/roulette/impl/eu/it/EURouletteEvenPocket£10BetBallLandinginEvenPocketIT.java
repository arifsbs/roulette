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

public class EURouletteEvenPocket£10BetBallLandinginEvenPocketIT {

	Customer customer;
	Bet bet;
	EuropeanRoulette europeanRoulette;
	IPocketType pocket;
	
	@Before
	public void placeBet()
	{
		customer = new Customer("John", "Smith");
		bet = new Bet();
		europeanRoulette = new EuropeanRoulette();		

		bet.setBetAmount(new BigDecimal(10));
		pocket = OddEvenNumberPocketType.EVEN;
		bet.setPocket(pocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());						
	}
		
	@Test
	public void playEven() throws RouletteGameException
	{
		europeanRoulette.setBallLandingPocket(NumberPocketType.TWENTYFOUR);
		assertEquals(new BigDecimal(20), europeanRoulette.play().getWinnings());
	}
}
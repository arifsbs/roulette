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

public class EUEURouletteWinning£10BetPoundIT {

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
		
		pocket = NumberPocketType.SEVEN;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(pocket);
		customer.setBet(bet);
		europeanRoulette.placeBet(customer.getBet());
	}
	
	@Test
	public void customerPlaces10PoundBetOnWinningPocket() throws RouletteGameException
	{
		europeanRoulette.setBallLandingPocket(NumberPocketType.SEVEN);
		assertEquals(new BigDecimal(360), europeanRoulette.play().getWinnings());
	}	
		
}
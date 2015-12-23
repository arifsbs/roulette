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

public class USRouletteWinning£10BetPoundIT {

	Customer customer;
	Bet bet;
	AmericanRoulette americanRoulette;
	IPocketType pocket;
	
	@Before
	public void placeBet()
	{
		customer = new Customer("John", "Smith");
		bet = new Bet();
		americanRoulette = new AmericanRoulette();
		
		pocket = NumberPocketType.DOUBLEZERO;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(pocket);
		customer.setBet(bet);
		americanRoulette.placeBet(customer.getBet());
	}
	
	@Test
	public void customerPlaces10PoundBetOnWinningPocket() throws RouletteGameException
	{
		americanRoulette.setBallLandingPocket(NumberPocketType.DOUBLEZERO);
		assertEquals(new BigDecimal(360), americanRoulette.play().getWinnings());
	}	
		
}
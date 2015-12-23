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

public class USRouletteOddPocket£10BetBallLandinginOddPocketIT {

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

		bet.setBetAmount(new BigDecimal(10));
		pocket = OddEvenNumberPocketType.ODD;
		bet.setPocket(pocket);
		customer.setBet(bet);
		americanRoulette.placeBet(customer.getBet());						
	}
		
	@Test
	public void play() throws RouletteGameException
	{
		americanRoulette.setBallLandingPocket(NumberPocketType.NINETEEN);
		assertEquals(new BigDecimal(20), americanRoulette.play().getWinnings());
	}

}
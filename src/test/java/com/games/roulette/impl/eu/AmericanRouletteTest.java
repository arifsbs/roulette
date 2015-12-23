package com.games.roulette.impl.eu;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Test;

import com.games.roulette.domainobject.Bet;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.AmericanRoulette;
import com.games.roulette.util.InvalidNumberPocketType;
import com.games.roulette.util.NumberPocketType;

public class AmericanRouletteTest {

	AmericanRoulette roulette;
	Bet bet;
	
	@Before
	public void setup()
	{
		roulette = new AmericanRoulette();
		bet = new Bet();
	}
	
	@Test
	public void initializeWithPockets()
	{
		assertEquals(38, roulette.getPockets().size());
	}
	
	@Test
	public void betIsValid()
	{
		bet.setPocket(NumberPocketType.DOUBLEZERO);
		roulette.setBet(bet);
		assertTrue(roulette.isBetValid());
	}
	
	@Test
	public void betIsNotValid()
	{
		bet.setPocket(InvalidNumberPocketType.FIFTY);
		roulette.setBet(bet);
		assertFalse(roulette.isBetValid());
	}	
	
	@Test
	public void placeBet()
	{
		bet.setPocket(NumberPocketType.FIVE);
		bet.setBetAmount(new BigDecimal(40));
		assertEquals(new BigDecimal(40), bet.getBetAmount());
		assertEquals(NumberPocketType.FIVE, bet.getPocket());
	}
	
	@Test
	public void play() throws RouletteGameException
	{
		bet.setPocket(NumberPocketType.FIVE);
		bet.setBetAmount(new BigDecimal(10));
		roulette.setBet(bet);
		roulette.setBallLandingPocket(NumberPocketType.FIVE);
		
		assertEquals(new BigDecimal(360), roulette.play().getWinnings());
	}
}

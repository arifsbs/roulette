package com.games.roulette.impl.eu;

import static org.junit.Assert.assertEquals;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.math.BigDecimal;

import org.junit.Before;

import com.games.roulette.domainobject.Bet;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.EuropeanRoulette;
import com.games.roulette.util.InvalidNumberPocketType;
import com.games.roulette.util.NumberPocketType;

public class EuropeanRouletteTest {

	EuropeanRoulette roulette;
	Bet bet;
	
	@Before
	public void setup()
	{
		roulette = new EuropeanRoulette();
		bet = new Bet();
	}
	
	//@Test
	public void initializeWithPockets()
	{
		assertEquals(37, roulette.getPockets().size());
	}
	
	//@Test
	public void betIsValid()
	{
		bet.setPocket(NumberPocketType.EIGHTEEN);
		roulette.setBet(bet);
		assertTrue(roulette.isBetValid());
	}
	
	//@Test
	public void betIsNotValid()
	{
		bet.setPocket(InvalidNumberPocketType.FIFTY);
		roulette.setBet(bet);
		assertFalse(roulette.isBetValid());
	}	
	
	//@Test
	public void betIsNotValidWithDoubleZeroBet()
	{
		bet.setPocket(NumberPocketType.DOUBLEZERO);
		roulette.setBet(bet);
		assertFalse(roulette.isBetValid());
	}
	
	//@Test
	public void placeBet()
	{
		bet.setPocket(NumberPocketType.FIVE);
		bet.setBetAmount(new BigDecimal(40));
		assertEquals(new BigDecimal(40), bet.getBetAmount());
		assertEquals(NumberPocketType.FIVE, bet.getPocket());
	}
	
	//@Test
	public void play() throws RouletteGameException
	{
		bet.setPocket(NumberPocketType.FIVE);
		bet.setBetAmount(new BigDecimal(10));
		roulette.setBet(bet);
		roulette.setBallLandingPocket(NumberPocketType.FIVE);
		
		assertEquals(new BigDecimal(360), roulette.play().getWinnings());
	}
}

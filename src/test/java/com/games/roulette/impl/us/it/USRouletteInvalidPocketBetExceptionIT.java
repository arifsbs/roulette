package com.games.roulette.impl.us.it;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import com.games.roulette.IPocketType;
import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Customer;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.AmericanRoulette;
import com.games.roulette.util.InvalidNumberPocketType;

public class USRouletteInvalidPocketBetExceptionIT {

	Customer customer;
	Bet bet;
	AmericanRoulette americanRoulette;
	IPocketType pocket;
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Before
	public void placeBet()
	{
		customer = new Customer("John", "Smith");
		bet = new Bet();
		americanRoulette = new AmericanRoulette();
		
		pocket = InvalidNumberPocketType.FIFTY;
		bet.setBetAmount(new BigDecimal(20));
		bet.setPocket(pocket);
		customer.setBet(bet);
		americanRoulette.placeBet(customer.getBet());
	}
		
	@Test
	public void play() throws RouletteGameException
	{
		thrown.expect(RouletteGameException.class);
		thrown.expectMessage("Bet placed on invalid pocket");
		
		americanRoulette.play();
		
		System.out.println("222");
	}
	
}
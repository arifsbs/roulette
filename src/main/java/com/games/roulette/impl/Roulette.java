package com.games.roulette.impl;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.List;

import com.games.roulette.IPocketType;
import com.games.roulette.IRoulette;
import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Winnings;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.util.NumberPocketType;
import com.games.roulette.util.OddEvenNumberPocketType;

/**
 * Common implementation of Roulette
 *
 */
public abstract class Roulette implements IRoulette {

	public Roulette() {
		super();
		//initializeWithPockets();
	}

	Bet bet;
	List<NumberPocketType> pockets = new ArrayList<NumberPocketType>();
	
	IPocketType ballLandingPocket;

	public List<NumberPocketType> getPockets() {
		return pockets;
	}

	public void setPockets(List<NumberPocketType> pockets) {
		this.pockets = pockets;
	}

	public Bet getBet() {
		return bet;
	}

	public void setBet(Bet bet) {
		this.bet = bet;
	}

	public IPocketType getBallLandingPocket() {
		return ballLandingPocket;
	}

	public void setBallLandingPocket(IPocketType ballLandingPocket) {
		this.ballLandingPocket = ballLandingPocket;
	}
	
	public void initializeWithPockets() {
		pockets.add(NumberPocketType.ZERO);
		pockets.add(NumberPocketType.ONE);
		pockets.add(NumberPocketType.TWO);
		pockets.add(NumberPocketType.THREE);
		pockets.add(NumberPocketType.FOUR);
		pockets.add(NumberPocketType.FIVE);
		pockets.add(NumberPocketType.SIX);
		pockets.add(NumberPocketType.SEVEN);
		pockets.add(NumberPocketType.EIGHT);
		pockets.add(NumberPocketType.NINE);
		pockets.add(NumberPocketType.TEN);
		pockets.add(NumberPocketType.ELEVEN);
		pockets.add(NumberPocketType.TWELVE);
		pockets.add(NumberPocketType.THIRTEEN);
		pockets.add(NumberPocketType.FOURTEEN);
		pockets.add(NumberPocketType.FIFETEEN);
		pockets.add(NumberPocketType.SIXTEEN);
		pockets.add(NumberPocketType.SEVENTEEN);
		pockets.add(NumberPocketType.EIGHTEEN);
		pockets.add(NumberPocketType.NINETEEN);
		pockets.add(NumberPocketType.TWENTY);
		pockets.add(NumberPocketType.TWENTYONE);
		pockets.add(NumberPocketType.TWENTYTWO);
		pockets.add(NumberPocketType.TWENTYTHREE);
		pockets.add(NumberPocketType.TWENTYFOUR);
		pockets.add(NumberPocketType.TWENTYFIVE);
		pockets.add(NumberPocketType.TWENTYSIX);
		pockets.add(NumberPocketType.TWENTYSEVEN);
		pockets.add(NumberPocketType.TWENTYEIGHT);
		pockets.add(NumberPocketType.TWENTYNINE);
		pockets.add(NumberPocketType.THIRTY);
		pockets.add(NumberPocketType.THIRTYONE);
		pockets.add(NumberPocketType.THIRTYTWO);
		pockets.add(NumberPocketType.THIRTYTHREE);
		pockets.add(NumberPocketType.THIRTYFOUR);
		pockets.add(NumberPocketType.THIRTYFIVE);
		pockets.add(NumberPocketType.THIRTYSIX);
	}
	
	
	@Override
	//public boolean isBetValid() throws RouletteGameException {
	public boolean isBetValid() {

		if(bet.getPocket().getClass().getSimpleName().equals("OddEvenNumberPocketType"))
		{
			if(bet.getPocket().equals(OddEvenNumberPocketType.ODD) || 
					bet.getPocket().equals(OddEvenNumberPocketType.EVEN))
			{
				return true;
			} 
		} else {
			if(pockets.contains(getBet().getPocket()))
			{
				return true;
			}			
		}
		
		return false;
	}	
	
	@Override
	public void placeBet(Bet bet) {
		this.bet = bet;		
	}

	@Override
	public Winnings play() throws RouletteGameException {
		
		if(!isBetValid())
		{
			throw new RouletteGameException("Bet placed on invalid pocket");
		}
		
		if(getBet().getBetAmount().equals(new BigDecimal(0)))
		{
			throw new RouletteGameException("Cannot place Bet with £0");
		}

		return new Winnings().calculateWinnings(bet, ballLandingPocket);		
	}	
}

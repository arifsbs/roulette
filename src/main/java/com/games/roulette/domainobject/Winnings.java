package com.games.roulette.domainobject;

import java.math.BigDecimal;

import com.games.roulette.IPocketType;
import com.games.roulette.util.NumberPocketType;
import com.games.roulette.util.OddEvenNumberPocketType;

/**
 * Domain object to represent Winnings from placing bets.
 *
 */
public class Winnings {
	
	public BigDecimal winnings = new BigDecimal(0);
	
	public Winnings(BigDecimal winnings)
	{
		this.winnings = winnings;
	}

	public Winnings() {
		
	}

	public BigDecimal getWinnings() {
		return winnings;
	}

	public void setWinnings(BigDecimal winnings) {
		this.winnings = winnings;
	}
	
	public Winnings calculateWinnings(Bet bet, IPocketType ballLandingPocket)
	{
		if(bet.getPocket().getClass().getSimpleName().equals("NumberPocketType"))
		{
			if(bet.getPocket().equals(ballLandingPocket))
			{
				if(bet.betAmount.equals(new BigDecimal(10)))
				{
					return new Winnings(new BigDecimal(360));			
				}
			}
		} else if(bet.getPocket().getClass().getSimpleName().equals("OddEvenNumberPocketType"))
		{
			IPocketType pocketTemp;
			
			if(ballLandingPocket.equals(NumberPocketType.ZERO))
			{
				return new Winnings(new BigDecimal(0));
			}
			
			if(ballLandingPocket.equals(NumberPocketType.ONE) || 
				ballLandingPocket.equals(NumberPocketType.THREE) ||
				ballLandingPocket.equals(NumberPocketType.FIVE) ||
				ballLandingPocket.equals(NumberPocketType.SEVEN) ||
				ballLandingPocket.equals(NumberPocketType.NINE) ||
				ballLandingPocket.equals(NumberPocketType.ELEVEN) ||
				ballLandingPocket.equals(NumberPocketType.THIRTEEN) ||
				ballLandingPocket.equals(NumberPocketType.FIFETEEN) ||
				ballLandingPocket.equals(NumberPocketType.SEVENTEEN) ||
				ballLandingPocket.equals(NumberPocketType.NINETEEN) ||
				ballLandingPocket.equals(NumberPocketType.TWENTYONE) ||
				ballLandingPocket.equals(NumberPocketType.TWENTYTHREE) ||
				ballLandingPocket.equals(NumberPocketType.TWENTYFIVE) ||
				ballLandingPocket.equals(NumberPocketType.TWENTYSEVEN) ||
				ballLandingPocket.equals(NumberPocketType.TWENTYNINE) ||
				ballLandingPocket.equals(NumberPocketType.THIRTYONE) ||
				ballLandingPocket.equals(NumberPocketType.THIRTYTHREE) ||
				ballLandingPocket.equals(NumberPocketType.THIRTYFIVE))
			{
				pocketTemp = OddEvenNumberPocketType.ODD; 
			} else
			{
				pocketTemp = OddEvenNumberPocketType.EVEN;
			}
			if(bet.getPocket().equals(pocketTemp))
			{
				return new Winnings(new BigDecimal(20));
			} else if(bet.getPocket().equals(pocketTemp))
			{
				return new Winnings(new BigDecimal(10));
			} 
		}
		return new Winnings(new BigDecimal(0));
	}	
}

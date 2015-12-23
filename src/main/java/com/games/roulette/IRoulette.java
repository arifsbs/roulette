package com.games.roulette;

import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Winnings;
import com.games.roulette.exception.RouletteGameException;

/**
 * Interface for Roulette Wheel which allows European and American style
 * implementation of Roulette
 *
 */
public interface IRoulette {
	
	public void initializeWheelWithPockets();
	
	public void placeBet(Bet bet);
	
	public boolean isBetValid() throws RouletteGameException;
	
	public Winnings play() throws RouletteGameException;
	
	//public Winnings doesBetMatch();
}

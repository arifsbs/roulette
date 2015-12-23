package com.games.roulette.impl;

import com.games.roulette.util.NumberPocketType;

/**
 * Implementation of American Roulette
 *
 */
public class AmericanRoulette extends Roulette {

	public AmericanRoulette()
	{
		super();
		initializeWheelWithPockets();
	}
	
	@Override
	public void initializeWheelWithPockets() {
		initializeWithPockets();
		pockets.add(NumberPocketType.DOUBLEZERO);
	}
	
}

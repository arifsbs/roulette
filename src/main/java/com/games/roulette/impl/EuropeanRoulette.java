package com.games.roulette.impl;

/**
 * Implementation of European Roulette
 *
 */
public class EuropeanRoulette extends Roulette {

	public EuropeanRoulette() {
		super();
		initializeWheelWithPockets();
	}

	@Override
	public void initializeWheelWithPockets() {
		initializeWithPockets();
	}
	
}

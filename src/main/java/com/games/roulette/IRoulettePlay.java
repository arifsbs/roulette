package com.games.roulette;


/**
 * Interface for Roulette Play which allows European and American style
 * implementation of Roulette Play
 *
 */
public interface IRoulettePlay {

	public void customerPlayRouletteLosing£10BetPound();

	public void customerPlayRouletteWinning£10BetPound();
	
	public void customerDisallowedToPlayAsBetPlacedIs£0();
	
	public void customerDisallowedToPlayAsBetOnInvalidPocket();
	
	public void customerPlays£10OnOddOrEvenAndBallLandsOnZero();
	
	public void customerPlays£10OnEvenAndBallLandsOnEven();
	
	public void customerPlays£10OnEvenAndBallLandsOnOdd();
	
	public void customerPlays£10OnOddAndBallLandsOnEven();
	
	public void customerPlays£10OnOddAndBallLandsOnOdd();
}
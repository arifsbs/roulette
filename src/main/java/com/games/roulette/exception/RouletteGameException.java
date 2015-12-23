package com.games.roulette.exception;

/**
 * Defines exception while playing Roulette
 *
 */
public class RouletteGameException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -189414152090035157L;

	public RouletteGameException()
	{
	}

	public RouletteGameException(String message)
	{
		super(message);
	}

	public RouletteGameException(Throwable cause)
	{
		super(cause);
	}

	public RouletteGameException(String message, Throwable cause)
	{
		super(message, cause);
	}

}

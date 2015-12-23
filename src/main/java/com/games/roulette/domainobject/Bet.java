package com.games.roulette.domainobject;

import java.math.BigDecimal;
import com.games.roulette.IPocketType;

/**
 * Domain object to represent Bet
 *
 */
public class Bet {
	
	public IPocketType pocket;
	
	public BigDecimal betAmount;
	

	public IPocketType getPocket() {
		return pocket;
	}

	public void setPocket(IPocketType pocket) {
		this.pocket = pocket;
	}

	public BigDecimal getBetAmount() {
		return betAmount;
	}

	public void setBetAmount(BigDecimal betAmount) {
		this.betAmount = betAmount;
	}
		
}

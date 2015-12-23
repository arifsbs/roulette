package com.games.roulette.impl.eu.story.step;

import java.math.BigDecimal;

import static org.junit.Assert.*;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

import com.games.roulette.IPocketType;
import com.games.roulette.domainobject.Bet;
import com.games.roulette.domainobject.Customer;
import com.games.roulette.exception.RouletteGameException;
import com.games.roulette.impl.EuropeanRoulette;
import com.games.roulette.util.NumberPocketType;
import com.games.roulette.util.OddEvenNumberPocketType;

public class EuOddEvenPocketZeroPoundBetBallInZeroPocketSteps {

	Customer customer;
	Bet bet;
	EuropeanRoulette europeanRoulette;
	IPocketType pocket;
	
    @Given("A customer has placed a bet of &pound;10 on odd")
    public void initializeOddBet() {
		customer = new Customer("John", "Smith");
		bet = new Bet();
		europeanRoulette = new EuropeanRoulette();

		pocket = OddEvenNumberPocketType.ODD;
    }	
	
    @Given("A customer has placed a bet of &pound;10 on even")
    public void initializeEvenBet() {
		customer = new Customer("John", "Smith");
		bet = new Bet();
		europeanRoulette = new EuropeanRoulette();

		pocket = OddEvenNumberPocketType.EVEN;
    }
    
    @When("I spin the roulette wheel and the ball lands in pocket 0")
    public void placeBet() {
		
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(pocket);
		customer.setBet(bet);

		europeanRoulette.placeBet(customer.getBet());
    }

	
    @Then("The customer will receive &pound;0 winnings")
    public void play() throws RouletteGameException {
		europeanRoulette.setBallLandingPocket(NumberPocketType.ZERO);
		assertEquals(new BigDecimal(0), europeanRoulette.play().getWinnings());
    }
}
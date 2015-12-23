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
import com.games.roulette.util.InvalidNumberPocketType;

public class EuInvalidPocketBetExceptionSteps {

	Customer customer;
	Bet bet;
	EuropeanRoulette europeanRoulette;
	IPocketType pocket;
	
    @Given("A customer is going to place a bet on an invalid pocket")
    public void initializeBet() {
		customer = new Customer("John", "Smith");
		bet = new Bet();
		europeanRoulette = new EuropeanRoulette();
    }
    
    @When("A customer has selected an invalid pocket")
    public void placeBet() {
    	
		pocket = InvalidNumberPocketType.FORTY;
		bet.setBetAmount(new BigDecimal(0));
		bet.setPocket(pocket);
		customer.setBet(bet);

		europeanRoulette.placeBet(customer.getBet());
    }

    @Then("The application will throw a Invalid Pocket Exception")
    public void play() {
    	
		try {
			europeanRoulette.play();
		} catch (RouletteGameException rge) {
			assertEquals("Bet placed on invalid pocket", rge.getMessage());
		}    	
    }
}
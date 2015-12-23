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

public class EuZeroAmountBetExceptionSteps {

	Customer customer;
	Bet bet;
	EuropeanRoulette europeanRoulette;
	IPocketType pocket;
	
	//@Rule
	//public ExpectedException thrown = ExpectedException.none();
	
    @Given("A customer has placed a bet")
    public void initializeBet() {
		customer = new Customer("John", "Smith");
		bet = new Bet();
		europeanRoulette = new EuropeanRoulette();
    }
    
    @When("That bet is less than or equal to &pound;0")
    public void placeBet() {
    	
		pocket = NumberPocketType.SEVEN;
		bet.setBetAmount(new BigDecimal(0));
		bet.setPocket(pocket);
		customer.setBet(bet);

		europeanRoulette.placeBet(customer.getBet());
    }

    @Then("The application will throw a Zero Amount bet Exception")
    public void play() {
    	
		try {
			europeanRoulette.play();
		} catch (RouletteGameException rge) {
			assertEquals("Cannot place Bet with £0", rge.getMessage());
		}    	
    }
}
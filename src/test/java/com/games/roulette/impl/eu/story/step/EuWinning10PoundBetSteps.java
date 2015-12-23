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

public class EuWinning10PoundBetSteps {

	Customer customer;
	Bet bet;
	EuropeanRoulette europeanRoulette;
	IPocketType pocket;
	
    @Given("A customer places a bet of &pound;10 on a pocket")
    public void initializeBet() {
		customer = new Customer("John", "Smith");
		bet = new Bet();
		europeanRoulette = new EuropeanRoulette();

    }
           
    @When("I spin the roulette wheel and the ball lands in a winning pocket")
    public void placeBet() {
		pocket = NumberPocketType.SEVEN;
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(pocket);
		customer.setBet(bet);

		europeanRoulette.placeBet(customer.getBet());
    }

	
    @Then("The customer will receive &pound;360 winnings")
    public void play() throws RouletteGameException {
		europeanRoulette.setBallLandingPocket(NumberPocketType.SEVEN);
		assertEquals(new BigDecimal(360), europeanRoulette.play().getWinnings());
    }
}
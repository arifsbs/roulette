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

public class EuOddEvenPocket10PoundBetBallLandingInOddEvenPocketSteps {

	Customer customer;
	Bet bet;
	EuropeanRoulette europeanRoulette;
	IPocketType pocket;

    @Given(" customer has placed a bet of &pound;10 on odd")
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
    
    @When("I spin the roulette wheel and the ball lands on an odd pocket")
    public void placeBetBallLandingInOdd() {
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(pocket);
		customer.setBet(bet);

		europeanRoulette.placeBet(customer.getBet());
		
		europeanRoulette.setBallLandingPocket(NumberPocketType.THIRTYTHREE);		
    }
    
    @When("I spin the roulette wheel and the ball lands on an even pocket")
    public void placeBetBallLandingInEven() {
		bet.setBetAmount(new BigDecimal(10));
		bet.setPocket(pocket);
		customer.setBet(bet);

		europeanRoulette.placeBet(customer.getBet());
		
		europeanRoulette.setBallLandingPocket(NumberPocketType.THIRTYFOUR);		
    }    

    @Then("The customer will receive &pound;0 winnings")
    public void playBallInOdd() throws RouletteGameException {
    	System.out.println("Even bet ZERO prize");
    	
		assertEquals(new BigDecimal(0), europeanRoulette.play().getWinnings());
    }
    
    
    @Then("The customer will receive &pound;20 winnings")
    public void playBallInEven() throws RouletteGameException {
    	System.out.println("Even bet 20 prize");
    	
		assertEquals(new BigDecimal(20), europeanRoulette.play().getWinnings());
    }    
        
}
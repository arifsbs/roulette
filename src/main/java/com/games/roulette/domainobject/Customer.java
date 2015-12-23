package com.games.roulette.domainobject;

/**
 * Domain object to represent Customer placing Bet
 *
 */
public class Customer {
	
	public int customerId;	
	public String firstName;
	public String lastName;
	public Bet bet;
	
	public Customer(String firstName, String lastName) {
		
		this.firstName = firstName;
		this.lastName = lastName;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Bet getBet() {
		return bet;
	}
	public void setBet(Bet bet) {
		this.bet = bet;
	}
	
}

package com.bridgelab.deckofcard;

import java.util.Arrays;

public class Player {
	String firstName;
	String lastName;
	int playerTurn;
	Card[] card;
	
	
	public Player() {
		super();
	}
	public Player(String firstName, String lastName) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.playerTurn = 0;
		this.card = new Card[10];
	}
	@Override
	public String toString() {
		return "Player [firstName=" + firstName + ", lastName=" + lastName + ", playerTurn=" + playerTurn + ", card="
				+ Arrays.toString(card) + "]";
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
	public int getPlayerTurn() {
		return playerTurn;
	}
	public void setPlayerTurn(int playerTurn) {
		this.playerTurn = playerTurn;
	}
	public Card[] getCard() {
		return card;
	}
	public void setCard(Card[] card) {
		this.card = card;
	}
	
	

}

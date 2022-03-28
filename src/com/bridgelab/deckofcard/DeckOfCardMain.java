package com.bridgelab.deckofcard;

import java.util.Scanner;

public class DeckOfCardMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of player");
		int numOfPlayers = sc.nextInt();
		DeckOfCard deckOfCard = new DeckOfCard();
		deckOfCard.addPlayer(numOfPlayers);
		deckOfCard.orderPlayerTurn(numOfPlayers);
		//deckOfCard.shuffleDeckOfCards();
		//deckOfCard.distributeCard();

	}

}

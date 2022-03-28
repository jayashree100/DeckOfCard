package com.bridgelab.deckofcard;

public class DeckOfCard {
	private static String[] suit = { "Spades", "Hearts", "Daimond", "Club" };
	private static String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "king" };
	private static String[][] deckOfCards = { suit, rank };
	private static Card[] deck = new Card[52];

	public void setupDeckOfCards() {
		int i = 0;
		for (String s : deckOfCards[0]) {
			for (String value : deckOfCards[1]) {
				deck[i++] = new Card(s, value);
			}
		}

	}
}

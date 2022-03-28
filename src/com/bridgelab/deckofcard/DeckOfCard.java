package com.bridgelab.deckofcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.*;

public class DeckOfCard {
	private static String[] suit = { "Spades", "Hearts", "Daimond", "Club" };
	private static String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "king" };
	private static String[][] deckOfCards = { suit, rank };
	private static Card[] deck = new Card[52];
	private static List<Player> playerList = new ArrayList<Player>();
	private static Scanner sc = new Scanner(System.in);
	Map<String, HashMap<String, Integer>> playerCardInfo = new HashMap<String, HashMap<String, Integer>>();

	public void setupDeckOfCards() {
		int i = 0;
		for (String s : deckOfCards[0]) {
			for (String value : deckOfCards[1]) {
				deck[i++] = new Card(s, value);
			}
		}

	}

	public void addPlayer(int numberOfPlayers) {
		System.out.println("Enter the player Details");
		if (numberOfPlayers >= 4) {
			System.out.println("maximum 4 players allowed");

		} else {
			for (int i = 0; i < numberOfPlayers; i++) {
				System.out.println("Enter the firstName");
				String fn = sc.nextLine();
				System.out.println("Enter the lastdName");
				String ln = sc.nextLine();
				Player player = new Player(fn, ln);
				playerList.add(player);
				for (int j = 0; j < playerList.size(); j++) {
					System.out.println(playerList.get(j));
				}

			}
		}
	}
	
	public void orderPlayerTurn(int numberOfPlayers) {
		System.out.println("Enter the Player order");
		for(int i = 0; i < numberOfPlayers; i++) {
			int turn = sc.nextInt();
			playerList.get(i).setPlayerTurn(turn);
		}
	}
}

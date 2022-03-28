package com.bridgelab.deckofcard;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
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
		for (int i = 0; i < numberOfPlayers; i++) {
			int turn = sc.nextInt();
			playerList.get(i).setPlayerTurn(turn);
		}
	}

	public void shuffleDeckOfCards() {
		Random rand = new Random();
		for (int i = 0; i < deckOfCards.length; i++) {
			String[] tempArray = deckOfCards[i];
			for (int j = 0; j < tempArray.length; j++) {
				int r = j + rand.nextInt(tempArray.length - j);
				// System.out.println(r);
				// System.out.println(tempArray[i]);
				// System.out.println(tempArray[j]);
				String temp = tempArray[r];
				tempArray[r] = tempArray[j];
				tempArray[j] = temp;
			}
			deckOfCards[i] = tempArray;
		}
	}

	public void distributeCard() {
		playerList.stream().sorted(Comparator.comparingInt(Player::getPlayerTurn)).collect(Collectors.toList());
		for (int p = 0; p < playerList.size(); p++) {
			int count = 0;
			int cardIndex = p;
			Card[] cardSet = new Card[9];
			while (count < 9) {
				Card card = deck[cardIndex];
				cardSet[count] = card;
				cardIndex += 5;
				count++;
			}
			playerList.get(p).setCard(cardSet);
		}
	}

}

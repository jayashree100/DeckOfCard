package com.bridgelab.deckofcard;

import java.util.*;
import java.util.stream.Collectors;

public class DeckOfCard {

	private static final String[] suit = { "Spades", "Hearts", "Diamond", "Clubs" };
	private static final String[] rank = { "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
			"King" };
	private static final String[][] deckOfCards = { suit, rank };
	private static final Card[] deck = new Card[52];
	private static final List<Player> playerList = new ArrayList<>();
	private static final Scanner sc = new Scanner(System.in);
	Map<String, HashMap<String, Integer>> playerCardInfo = new HashMap<>();

	public void setupDeckOfCards() {
		int i = 0;
		for (String s : deckOfCards[0]) {
			for (String value : deckOfCards[1]) {
				deck[i++] = new Card(s, value);
			}
		}
	}

	public void addPlayer(int numberOfPlayers) {
		System.out.println("Enter players details");
		if (numberOfPlayers >= 4) {
			System.out.println("Maximum of 4 players is allowed");
		} else {
			for (int i = 0; i < numberOfPlayers; i++) {
				System.out.println("Enter first name");
				String fn = sc.nextLine();
				System.out.println("Enter second name");
				String ln = sc.nextLine();
				Player player = new Player(fn, ln);
				playerList.add(player);
				for (Player value : playerList) {
					System.out.println(value);
				}
			}
		}
	}

	public void shuffleDeckOfCards() {
		Random rand = new Random();
		for (int i = 0; i < deckOfCards.length; i++) {
			String[] tempArray = deckOfCards[i];
			for (int j = 0; j < tempArray.length; j++) {
				// Random for remaining positions.
				int r = j + rand.nextInt(tempArray.length - j);
				// swapping the elements
				String temp = tempArray[r];
				tempArray[r] = tempArray[j];
				tempArray[j] = temp;
			}
			deckOfCards[i] = tempArray;
		}
	}

	public void distributeCards() {
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

	public void orderPlayerTurn(int numberOfPlayers) {
		System.out.println("Enter players order");
		for (int i = 0; i < numberOfPlayers; i++) {
			int turn = sc.nextInt();
			playerList.get(i).setPlayerTurn(turn);
		}
	}

	public void displayPlayerCard() {
		for (Player player : playerList) {
			HashMap<String, Integer> cardInfo = new HashMap<>();
			Card[] cardArray = player.getCard();
			for (Card card : cardArray) {
				if (cardInfo.containsKey(card.getSuit())) {
					Integer value = cardInfo.get(card.getSuit());
					cardInfo.put(card.getSuit(), value + 1);
				} else {
					cardInfo.put(card.getSuit(), 1);
				}
			}
			playerCardInfo.put(player.getFirstName(), cardInfo);
		}
		for (Map.Entry<String, HashMap<String, Integer>> entry : playerCardInfo.entrySet())
			System.out.println("Key = " + entry.getKey() + ", Value = " + entry.getValue());
	}

	public void displayCardSortByRank() {
		for (int i = 0; i < playerList.size(); i++) {
			System.out.println("Player" + (i + 1) + " cards");
			Card[] cardArray = playerList.get(i).getCard();
			Arrays.sort(cardArray, new Sort_by_Suit());
			// Arrays.sort(cardArray, new SortbyRank());
			for (Card card : cardArray) {
				System.out.println(card);
			}
			System.out.println();
		}
	}

}

class Sort_by_Suit implements Comparator<Card> {

	@Override
	public int compare(Card card1, Card card2) {
		if (Objects.equals(card1.getSuit(), card2.getSuit())) {
			return card1.getRank().compareTo(card2.getRank());
		}
		return card1.getSuit().compareTo(card2.getSuit());
	}

}

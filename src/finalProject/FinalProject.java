//main file for the Tien Len (thirteen) card game

package finalProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;



public class FinalProject {
	
	
	private static LinkList deckOfCards = new LinkList();  // make list
	
	//Tien len requires a total of 4 players (! user, 3 computers)
	private static ArrayList<Card> playerCards = new ArrayList<Card>();
	private static ArrayList<Card> NPC1Cards = new ArrayList<Card>();
	private static ArrayList<Card> NPC2Cards = new ArrayList<Card>();
	private static ArrayList<Card> NPC3Cards = new ArrayList<Card>();
	
	public static void main(String[] args) {
		Scanner input = null;
		try {
			input = new Scanner(new File("cards.txt"));
		} catch (FileNotFoundException e) {
			// error
			System.out.println("error");
			e.printStackTrace();
		}

		while(input.hasNext()) {
			String[] fields  = input.nextLine().split(",");
			//	public Card(String cardSuit, String cardName, int cardValue, String cardPicture) {
			Card newCard = new Card(fields[0], fields[1].trim(),
					Integer.parseInt(fields[2].trim()), fields[3]);
			deckOfCards.insertFirst(newCard);	
		}
		
		//shuffling the deck
		shuffle();
		
		
		//dealing the cards
		giveHand(playerCards);
		
		giveHand(NPC1Cards);
		
		giveHand(NPC2Cards);
		
		giveHand(NPC3Cards);
		
		//Displaying the cards
		//Displaying NOCs cards for testing purposes
		System.out.println("players cards");
		printCards(playerCards);
		
		System.out.println("NPC 1 cards");
		printCards(NPC1Cards);
		
		System.out.println("NPC 2 cards");
		printCards(NPC2Cards);
		
		System.out.println("NPC 3 cards");
		printCards(NPC3Cards);
		
		
		//game starts
		System.out.println("Start by making a play");
		System.out.println("Please make you choice by typing the place of the cards");
		System.out.println("EX: '1, 2, 3' or '1' ");
		
		//creating scanner for Iser's input:
		Scanner userPlay = new Scanner(System.in);
		
	}
		

	
	
	public static void createDeck() {
		
	}
	
	public static void giveHand(ArrayList<Card> playerHand) {
		for(int i = 0; i < 13; i++) {
			
			Card currCard = deckOfCards.getFirst();
			
			playerHand.add(currCard);
			
			//So it doesn't delete the last card
			if (deckOfCards.getSize() >= 2) {
				deckOfCards.delete(currCard);
			}
			
			
			}
	}
	
	
	
	//shuffle from linked list assignment
	public static void shuffle() {
		// shuffle
		String[] SUITS = {
				"club", "diamond", "heart", "spade"
		};

		String[] RANKS = {
				"two", "three", "four", "five", "six", "seven", "eight", 
				"nine", "ten","jack", "queen", "king", "ace"};

		//shuffling the cards by deleting and reinserting
		for (int i = 0; i < deckOfCards.getSize(); i++) {
			int indexInsuits = (int) (Math.random() * 3);
			int indexInRanks = (int) (Math.random() * 12);
			String s = SUITS[indexInsuits];
			String r = RANKS[indexInRanks];
			Card c = deckOfCards.delete(new Card(s, r, 10, "no pic")).getCardObject();
			deckOfCards.insertFirst(c);
		}
	}
	
	//Displays player hand
	public static void printCards(ArrayList<Card> playerHand) {
		for(Card c: playerHand)
			System.out.println(c);
		
		System.out.println();
		System.out.println();
		
	}
}

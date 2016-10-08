package pokerBase;

import java.util.ArrayList;
import java.util.Collections;

import pokerEnums.eRank;
import pokerEnums.eSuit;

public class Deck {

	private ArrayList<Card> deckCards = new ArrayList<Card>();
	private int NbrOfJokers;

	public Deck() {
		NbrOfJokers = 0;
		int iCardNbr = 1;
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				// TODO Lab3 - Fix this (how?)
				if ((eSuit != eSuit.JOKER) && (eRank != eRank.JOKER)) {
					deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				}
			}

		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers) {
		this();
		this.NbrOfJokers = NbrOfJokers;
		for (int i = 0; i < NbrOfJokers; i++) {
			deckCards.add(new Card(true, (deckCards.size() + i)));
		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {
		this(NbrOfJokers);
		for (Card a : deckCards) {// for each card in the deck
			for (Card b : Wilds) {
				if ((a.geteRank() == b.geteRank()) && (a.geteSuit() == b.geteSuit())) {// if it is supposed to be wild
					a.setbWild(true);// set as wild
				}
			}
		}
		Collections.shuffle(deckCards);
	}

	public ArrayList<Card> getDeckCards() {
		return deckCards;
	}

	public Card Draw() {
		// TODO Lab 3 - Implement exception handling for overdraw
		return deckCards.remove(0);
	}

	public boolean isDeckEmpty() {
		if (deckCards.size() != 0)
			return true;
		else
			return false;
	}
	
	public int getDeckSize() {
		return deckCards.size();
	}
}

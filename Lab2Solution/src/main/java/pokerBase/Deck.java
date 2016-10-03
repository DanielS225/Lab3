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
				// if (eSuit != eSuit.JOKER) <-- you'll thank me :)
				// {
				deckCards.add(new Card(eSuit, eRank, iCardNbr++));
				// }
			}

		}
		Collections.shuffle(deckCards);
	}

	public Deck(int NbrOfJokers) {

		// TODO Lab3 - Implement joker constructor
		this();
		this.NbrOfJokers = NbrOfJokers;
		int i = 1;
		while (i <= NbrOfJokers) {
			deckCards.add(new Card(true, (deckCards.size() + i)));
		}
	}

	public Deck(int NbrOfJokers, ArrayList<Card> Wilds) {

		// TODO Lab3 - Implement joker and wild constructor

		this(NbrOfJokers);
		for (Card a : deckCards) {// for each card in the deck
			for (Card b : Wilds) {
				if (a.equals(b)) {// if it is supposed to be wild
					a.setbWild(true);// set as wild
				}
			}

			for (Card card : Wilds) {
				card.setbWild(true);
			}
		}
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
}

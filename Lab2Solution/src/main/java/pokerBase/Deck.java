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
				// TODO Lab3 - Fix this
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
		}
	}

	public ArrayList<Card> getDeckCards() {
		return deckCards;
	}

	public Object Draw() {
		// TODO Lab 3 - Implement exception handling for overdraw

		Object r;
		try {
			r = deckCards.remove(0);
		} catch (NullPointerException e) {
			System.out.println("Deck is empty");
			r = new Object();// is this a good handle? (would need to check
								// return type when card is drawn) what happens
								// when a deck is empty
		}
		return r;
	}
}

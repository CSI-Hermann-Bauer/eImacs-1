package com.eimacs.lab08;

import java.util.ArrayList;

/**
 * The Deck class represents a shuffled deck of cards. It provides several
 * operations including initialize, shuffle, deal, and check if empty.
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */

public class Deck {
	private ArrayList<Card> cards;
	private int numUndealt;

	public Deck(String[] ranks, String[] suits, int[] values) {
		cards = new ArrayList<Card>();
		for (int i = 0; i < ranks.length; i++) {
			for (String s : suits) {
				cards.add(new Card(ranks[i], s, values[i]));
			}
		}

		numUndealt = cards.size();
		shuffle();
	}

	public boolean isEmpty() {
		return numUndealt == 0;
	}

	public int getNumUndealt() {
		return numUndealt;
	}

	public Card deal() {
		if (isEmpty()) {
			return null;
		}
		numUndealt--;
		return cards.get(numUndealt);
	}

	public int random(int n) {
		return (int) (n * Math.random());
	}

	public void shuffle() {
		for (int k = cards.size() - 1; k >= 1; k--) {
			int r = random(k);
			Card c = cards.get(r);
			cards.set(r, cards.get(k));
			cards.set(k, c);
		}

		numUndealt = cards.size();

	}

	public String toString() {
		String rtn = "numUndealt = " + numUndealt + "\nUndealt cards: \n";

		for (int k = numUndealt - 1; k >= 0; k--) {
			rtn = rtn + cards.get(k);
			if (k != 0) {
				rtn = rtn + ", ";
			}
			if (k > 0 && (numUndealt - k) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\nDealt cards: \n";
		for (int k = cards.size() - 1; k >= numUndealt; k--) {
			rtn = rtn + cards.get(k);
			if (k != numUndealt) {
				rtn = rtn + ", ";
			}
			if (k > 0 && (k - cards.size()) % 2 == 0) {
				rtn = rtn + "\n";
			}
		}

		rtn = rtn + "\n";
		return rtn;
	}
}
package com.eimacs.lab08;

import java.util.ArrayList;

/**
 * The ElevensBoard class represents the board in a game of Elevens.
 * 
 * @author College Board Developers
 * @version 1.0 May 25, 2012
 */
public class ElevensBoard extends Board {
	/**
	 * The size (number of cards) on the board.
	 */
	private static final int BOARD_SIZE = 9;

	/**
	 * The ranks of the cards for this game to be sent to the deck.
	 */
	private static final String[] RANKS = { "ace", "2", "3", "4", "5", "6",
			"7", "8", "9", "10", "jack", "queen", "king" };

	/**
	 * The suits of the cards for this game to be sent to the deck.
	 */
	private static final String[] SUITS = { "spades", "hearts", "diamonds",
			"clubs" };

	/**
	 * The values of the cards for this game to be sent to the deck.
	 */
	private static final int[] POINT_VALUES = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
			0, 0, 0 };

	/**
	 * Flag used to control debugging print statements.
	 */
	private static final boolean DEBUGGING = false;

	/**
	 * Creates a new <code>ElevensBoard</code> instance.
	 */
	public ElevensBoard() {
		super(BOARD_SIZE, RANKS, SUITS, POINT_VALUES);
	}

	/**
	 * Determines if the selected cards form a valid group for removal. In
	 * Elevens, the legal groups are (1) a pair of non-face cards whose values
	 * add to 11, and (2) a group of three cards consisting of a jack, a queen,
	 * and a king in some order.
	 *
	 * @param selectedCards
	 *            the list of the indexes of the selected cards.
	 * @return true if the selected cards form a valid group for removal; false
	 *         otherwise.
	 */
	public boolean isLegal(ArrayList<Integer> selectedCards) {
		if (selectedCards.size() == 2) {
			return containsPairSum11(selectedCards);
		} else if (selectedCards.size() == 3) {
			return containsJQK(selectedCards);
		} else {
			return false;
		}
	}

	public boolean anotherPlayIsPossible() {
		ArrayList<Integer> cIndexes = getCardIndexes();
		return containsPairSum11(cIndexes) || containsJQK(cIndexes);
	}

	private boolean containsPairSum11(ArrayList<Integer> selectedCards) {
		for (int sk1 = 0; sk1 < selectedCards.size(); sk1++) {
			int k1 = selectedCards.get(sk1).intValue();
			for (int sk2 = sk1 + 1; sk2 < selectedCards.size(); sk2++) {
				int k2 = selectedCards.get(sk2).intValue();
				if (getCardAt(k1).getPointValue()
						+ getCardAt(k2).getPointValue() == 11) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean containsJQK(ArrayList<Integer> selectedCards) {
		boolean foundJack = false;
		boolean foundQueen = false;
		boolean foundKing = false;
		for (Integer kObj : selectedCards) {
			int k = kObj.intValue();
			if (getCardAt(k).getRank().equals("jack")) {
				foundJack = true;
			} else if (getCardAt(k).getRank().equals("queen")) {
				foundQueen = true;
			} else if (getCardAt(k).getRank().equals("king")) {
				foundKing = true;
			}
		}
		return foundJack && foundQueen && foundKing;
	}
}

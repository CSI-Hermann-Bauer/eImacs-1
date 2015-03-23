package com.eimacs.lab08;

/**
 * Card.java
 *
 * <code>Card</code> represents a playing card.
 *
 * @author |Your name|
 * @version 1.0 |Today's date|
 */
public class Card {
	private String suit;
	private String rank;
	private int pointValue;

	public Card(String newRank, String newSuit, int newValue) {
		rank = newRank;
		suit = newSuit;
		pointValue = newValue;
	}

	public String getSuit() {
		return suit;
	}

	public String getRank() {
		return rank;
	}

	public int getPointValue() {
		return pointValue;
	}

	public boolean matches(Card otherCard) {
		if (otherCard == null) {
			return false;
		}
		return rank.equals(otherCard.getRank())
				&& suit.equals(otherCard.getSuit())
				&& pointValue == otherCard.getPointValue();
	}

	public String toString() {
		return rank + " of " + suit + " (point value = " + pointValue + ")";
	}
}
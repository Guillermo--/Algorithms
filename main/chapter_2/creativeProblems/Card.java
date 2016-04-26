package chapter_2.creativeProblems;

import java.security.InvalidParameterException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Card {
	private String suit;
	private int rank;
	private int suitPosition;
	private static final Map<String, Integer> allowedSuits;

	static {
		Map<String, Integer> aMap = new HashMap<String, Integer>();
		aMap.put("Spades", 1);
		aMap.put("Hearts", 2);
		aMap.put("Clubs", 3);
		aMap.put("Diamonds", 4);
		allowedSuits = Collections.unmodifiableMap(aMap);
	}

	public Card(String suit, int rank) {
		if (allowedSuits.containsKey(suit) && rank > 0 && rank <= 13) {
			this.suit = suit;
			this.rank = rank;
			this.suitPosition = allowedSuits.get(suit);
		} else {
			throw new InvalidParameterException("Invalid parameters.");
		}
	}

	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public int getSuitPosition() {
		return suitPosition;
	}
	public void setSuitPosition(int suitPosition) {
		this.suitPosition = suitPosition;
	}
}
package chapter_2.creativeProblems;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DesckSortTest {
	
	Card[] inputDeck = {
		new Card("Hearts", 5),
		new Card("Clubs", 6),
		new Card("Clubs", 1),
		new Card("Diamonds", 3),
		new Card("Hearts", 11),
		new Card("Hearts", 13),
		new Card("Spades", 1),
		new Card("Hearts", 8),
		new Card("Spades", 2),
		new Card("Spades", 3),
		new Card("Diamonds", 4),
		new Card("Diamonds", 5),
		new Card("Hearts", 9),
		new Card("Spades", 10),
		new Card("Spades", 11),
		new Card("Diamonds", 12),
		new Card("Spades", 8),
		new Card("Clubs", 7),
		new Card("Diamonds", 7),
		new Card("Diamonds", 8),
		new Card("Clubs", 9),
		new Card("Clubs", 8),
		new Card("Diamonds", 6),
		new Card("Diamonds", 13),
		new Card("Diamonds", 9),			
		new Card("Hearts", 2),
		new Card("Hearts", 4),
		new Card("Spades", 9),
		new Card("Clubs", 5),
		new Card("Diamonds", 10),
		new Card("Spades", 5),
		new Card("Spades", 7),
		new Card("Clubs", 11),
		new Card("Hearts", 10),
		new Card("Clubs", 12),
		new Card("Clubs", 13),
		new Card("Diamonds", 1),
		new Card("Diamonds", 2),
		new Card("Clubs", 10),
		new Card("Spades", 12),
		new Card("Hearts", 6),
		new Card("Hearts", 7),
		new Card("Hearts", 1),
		new Card("Spades", 6),
		new Card("Spades", 13),
		new Card("Clubs", 3),
		new Card("Clubs", 2),
		new Card("Spades", 4),
		new Card("Hearts", 12),
		new Card("Hearts", 3),
		new Card("Clubs", 4),
		new Card("Diamonds", 11)
	};
	
	DeckSort testObject = new DeckSort();
	
	@Test
	public void sortBySuitTest() {
		Card[] sortedBySuit = testObject.sortBySuit(inputDeck);
		
		assertEquals(52, sortedBySuit.length);
		
		for(int i = 0; i<13; i++) {
			assertEquals("Spades", sortedBySuit[i].getSuit());
		}
		for(int i = 13; i<26; i++) {
			assertEquals("Hearts", sortedBySuit[i].getSuit());
		}
		for(int i = 26; i<39; i++) {
			assertEquals("Clubs", sortedBySuit[i].getSuit());
		}
		for(int i = 39; i<52; i++) {
			assertEquals("Diamonds", sortedBySuit[i].getSuit());
		}
	}
	
	@Test
	public void deckSortTest() {
		Card[] fullySorted = testObject.sort(inputDeck);
		
		assertEquals(52, fullySorted.length);

		for(int i = 1; i< 12; i++) {
			assertTrue(fullySorted[i].getRank() > fullySorted[i-1].getRank());
		}
		for(int i = 14; i< 25; i++) {
			assertTrue(fullySorted[i].getRank() > fullySorted[i-1].getRank());
		}
		for(int i = 27; i< 38; i++) {
			assertTrue(fullySorted[i].getRank() > fullySorted[i-1].getRank());
		}
		for(int i = 40; i< 51; i++) {
			assertTrue(fullySorted[i].getRank() > fullySorted[i-1].getRank());
		}
	}

}

package chapter_2.creativeProblems;

import chapter_1.queues.QueueArrayImpl;

/* Sort by value only.
 * Assuming its a complete suit (i.e. 1 - 13).
 * 
 * Only operations allowed are: 
 * 		Look at values of top two cards
 * 		Exchange top two cards
 * 		Move top card to bottom of the deck
 */

public class DequeueSort {
	
	private static final Integer largest = 13;
	private static final Integer smallest = 1;
	
	public static QueueArrayImpl<Integer> sort(QueueArrayImpl<Integer> deck){
		Integer first = null;
		Integer second = null;
		int cardsMovedToBottom = 0;
		
		while(cardsMovedToBottom < deck.getSize() && deck.peekFirstAtTop() != smallest) {
			first = deck.peekFirstAtTop();
			second = deck.peekSecondAtTop();
			
			if(first == largest) {
				deck.moveTopToBottom();
				cardsMovedToBottom++;
			}
			else {
				if(first > second){
					deck.swapTopTwo();
					cardsMovedToBottom = 0;
				}
				
				deck.moveTopToBottom();
				cardsMovedToBottom++;
			}
		}
		
		return deck;
	}
}

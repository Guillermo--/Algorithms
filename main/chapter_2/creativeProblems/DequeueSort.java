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
	
	private static final Integer smallest = 1;
	private static final Integer largest = 13;
	
	public static QueueArrayImpl<Integer> sort(QueueArrayImpl<Integer> deck){
		Integer first = null;
		Integer second = null;
		
		for(int i = 0; i<deck.getSize(); i++) {
			first = deck.peekFirstAtTop();
			second = deck.peekSecondAtTop();
			
			if(first == smallest || first == largest) {
				deck.moveTopToBottom();
			}
			
			else {
				if(first < second) {
					deck.swapTopTwo();
				} 
				else {
					deck.moveTopToBottom();
				}
			}
		}
		
		
		return deck;
	}
}

package chapter_2.creativeProblems;

/* Can only check two cards at a time, and swap two cards */

public class DeckSort {
	
	public Card[] sort(Card[] inputDeck) {
		inputDeck = sortBySuit(inputDeck);
		inputDeck = sortByRank(inputDeck);
		
		return inputDeck;
	}
	
	public Card[] sortByRank(Card[] inputDeck) {
		inputDeck = sortIndividualSuit(inputDeck, 0, 12);
		inputDeck = sortIndividualSuit(inputDeck, 13, 25);
		inputDeck = sortIndividualSuit(inputDeck, 26, 38);
		inputDeck = sortIndividualSuit(inputDeck, 39, 51);

		return inputDeck;
	}	

	public Card[] sortBySuit(Card[] inputDeck) {
		for(int i = 0; i<inputDeck.length; i = i+2) {
			Card a = inputDeck[i];
			Card b = inputDeck[i+1];
			
			if(i <= 12) {
				inputDeck = groupSpades(inputDeck, i, a, b);
			}
			
			if(i >= 13 && i <= 25) {
				inputDeck = groupHearts(inputDeck, i, a, b);
			}
			
			if(i >= 26 && i <= 38) {
				inputDeck = groupClubs(inputDeck, i, a, b);
			}
		}
		
		return inputDeck;
	}

	private Card[] groupClubs(Card[] inputDeck, int i, Card a, Card b) {
		if(a.getSuitPosition() != 3) {
			int indexOfReplacement = findIndexOfReplacement(inputDeck, 39);
			inputDeck = swap(inputDeck, i, indexOfReplacement);
		}

		if(b.getSuitPosition() != 3) {
			int indexOfReplacement = findIndexOfReplacement(inputDeck, 39);
			inputDeck = swap(inputDeck, i + 1, indexOfReplacement);
		}
		return inputDeck;
	}

	private Card[] groupHearts(Card[] inputDeck, int i, Card a, Card b) {
		if(a.getSuitPosition() != 2) {
			int indexOfReplacement = findIndexOfReplacement(inputDeck, 26);
			inputDeck = swap(inputDeck, i, indexOfReplacement);
		}

		if(b.getSuitPosition() != 2) {
			int indexOfReplacement = findIndexOfReplacement(inputDeck, 26);
			inputDeck = swap(inputDeck, i + 1, indexOfReplacement);
		}
		return inputDeck;
	}

	private Card[] groupSpades(Card[] inputDeck, int i, Card a, Card b) {
		if(a.getSuitPosition() != 1) {
			int indexOfReplacement = findIndexOfReplacement(inputDeck, 13);
			inputDeck = swap(inputDeck, i, indexOfReplacement);
		}
		
		if(i == 12) {
			if(b.getSuitPosition() != 2) {
				int indexOfReplacement = findIndexOfReplacement(inputDeck, 26);
				inputDeck = swap(inputDeck, i + 1, indexOfReplacement);
			}
		} 
		else {
			if(b.getSuitPosition() != 1) {
				int indexOfReplacement = findIndexOfReplacement(inputDeck, 13);
				inputDeck = swap(inputDeck, i + 1, indexOfReplacement);
			}
		}
		return inputDeck;
	}
	
	private int findIndexOfReplacement(Card[] inputDeck, int startingPoint) {
		int targetSuitPosition = 0;
		
		if(startingPoint == 13) {
			targetSuitPosition = 1;
		}
		else if(startingPoint == 26) {
			targetSuitPosition = 2;
		}
		else if( startingPoint == 39) {
			targetSuitPosition = 3;
		}
		
		for(int i = startingPoint; i<inputDeck.length; i++) {
			Card currentCard = inputDeck[i];
			if(currentCard.getSuitPosition() == targetSuitPosition) {
				return i;
			}
		}
		
		return -1;
	}
	
	private Card[] swap(Card[] inputDeck, int indexA, int indexB) {
		if(indexB != -1) {
			Card temp = inputDeck[indexA];
			inputDeck[indexA] = inputDeck[indexB];
			inputDeck[indexB] = temp;
		}
		return inputDeck;
	}
	
	private Card[] sortIndividualSuit(Card[] inputDeck, int start, int end) {		
		for(int i = start; i<end; i++) {
			int indexOfSmallest = i;
			for(int j = i+1; j<=end; j++) {
				Card currentSmallest = inputDeck[indexOfSmallest];
				Card currentCard = inputDeck[j];
				if(currentCard.getRank() < currentSmallest.getRank()) {
					indexOfSmallest = j;
				}
			}
			
			inputDeck = swap(inputDeck, i, indexOfSmallest);
		}
		return inputDeck;
	}


	
	
}

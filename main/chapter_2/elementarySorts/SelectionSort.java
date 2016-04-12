package chapter_2.elementarySorts;

import java.util.List;

public class SelectionSort {

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Comparable> sort(List<Comparable> toSort) {
		for(int i = 0; i<toSort.size(); i++) {
			int smallestIndex = i;
			for(int j = i+1; j<toSort.size(); j++) {
				if(toSort.get(smallestIndex).compareTo(toSort.get(j)) > 0) {
					smallestIndex = j;
				}
			}
			swap(toSort, i, smallestIndex);
		}
		return toSort;
	}

	@SuppressWarnings("rawtypes")
	private static void swap(List<Comparable> toSort, int i, int smallestIndex) {
		Comparable temp = toSort.get(i);
		toSort.set(i, toSort.get(smallestIndex));
		toSort.set(smallestIndex, temp);
	}
}

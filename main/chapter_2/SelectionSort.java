package chapter_2;

import java.util.List;

public class SelectionSort {

	public static List<Integer> sort(List<Integer> toSort) {
		for(int i = 0; i<toSort.size(); i++) {
			int smallestIndex = i;
			for(int j = i+1; j<toSort.size(); j++) {
				if(toSort.get(smallestIndex) > toSort.get(j)) {
					smallestIndex = j;
				}
			}
			swap(toSort, i, smallestIndex);
		}
		return toSort;
	}

	private static void swap(List<Integer> toSort, int i, int smallestIndex) {
		int temp = toSort.get(i);
		toSort.set(i, toSort.get(smallestIndex));
		toSort.set(smallestIndex, temp);
	}
}

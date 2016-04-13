package chapter_2.elementarySorts;

import java.util.List;

/*Compares elements with other elements that are already sorted (left hand side)*/
public class InsertionSort {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public static List<Comparable> sort(List<Comparable> toSort) {
		for(int i = 1; i<toSort.size(); i++) {
			int previousLocation = i;
			Comparable currentItem = toSort.get(i);
			for(int j = i-1; j>=0; j--) {
				if(currentItem.compareTo(toSort.get(j)) < 0) {
					toSort.add(j, toSort.get(previousLocation));
					toSort.remove(previousLocation+1);
					previousLocation = j;
				}
			}
		}
		return toSort;
	}
	
}

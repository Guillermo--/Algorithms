package chapter_2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SelectionSortTest {

	@Test
	public void sortTest() {
		List<Integer> toSort = Arrays.asList(2, 0, 3, 5, 7, 6, 11, 15, 1);
		toSort = SelectionSort.sort(toSort);
		assertEquals(9, toSort.size());
		assertTrue(isSorted(toSort));
	}
	
	public boolean isSorted(List<Integer> list) {
		for(int i = 1; i<list.size(); i++) {
			if(list.get(i).compareTo(list.get(i-1)) < 0) {
				return false;
			}
		}
		return true;
	}

}

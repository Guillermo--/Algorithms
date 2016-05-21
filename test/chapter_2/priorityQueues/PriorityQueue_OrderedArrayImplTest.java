package chapter_2.priorityQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueue_OrderedArrayImplTest {

	PriorityQueue_OrderedArrayImpl<Integer> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new PriorityQueue_OrderedArrayImpl<>();
		
		assertNotNull(testObject);
		assertTrue(testObject.isEmpty());
	}
	
	@Test
	public void insertTest() {
		testObject = new PriorityQueue_OrderedArrayImpl<>();
		
		testObject.insert(2);
		testObject.insert(1);
		testObject.insert(9);
		testObject.insert(5);
		testObject.insert(7);
		
		assertEquals(5, testObject.getSize());
		assertTrue(testObject.isSorted());
	}

}

package chapter_2.priorityQueues;

import static org.junit.Assert.*;

import org.junit.Test;

public class PriorityQueue_UnorderedArrayImplTest {

	PriorityQueue_UnorderedArrayImpl<Integer> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new PriorityQueue_UnorderedArrayImpl<>();
		
		assertTrue(testObject.isEmpty());
		assertNotNull(testObject);
	}
	
	@Test
	public void insertTest_typical() {
		testObject = new PriorityQueue_UnorderedArrayImpl<>();
		
		testObject.insert(1);
		testObject.insert(2);
		testObject.insert(3);
		testObject.insert(4);

		assertEquals(4, testObject.getSize());
	}
	
	@Test
	public void insertTest_needsResize() {
		testObject = new PriorityQueue_UnorderedArrayImpl<>();
		
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);
		testObject.insert(1);

		assertEquals(11, testObject.getSize());
	}

	@Test
	public void removeMaxTest_typical() {
		testObject = new PriorityQueue_UnorderedArrayImpl<>();
		
		testObject.insert(7);
		testObject.insert(12);
		testObject.insert(5);
		testObject.insert(9);
		testObject.insert(3);
		testObject.insert(4);
		
		int removedItem = testObject.removeMax();
		
		assertEquals(5, testObject.getSize());
		assertEquals(12, removedItem);
	}
	
	@Test(expected = NullPointerException.class)
	public void removeMaxTest_emptyQueue() {
		testObject = new PriorityQueue_UnorderedArrayImpl<>();
		
		testObject.removeMax();
	}
}

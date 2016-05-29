package chapter_2.priorityQueues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class PriorityQueue_HeapTest {

	PriorityQueue_Heap<Integer> testObject;
	
	@Before
	public void init() {
		testObject = new PriorityQueue_Heap<>();
	}
	
	@Test
	public void constructorTest() {
		assertNotNull(testObject);
		assertTrue(testObject.isEmpty());
	}
	
	@Test
	public void insertTest() {
		testObject.insert(6);
		testObject.insert(2);
		testObject.insert(4);
		testObject.insert(9);
		testObject.insert(3);
		
		assertEquals(5, testObject.getSize());
		assertTrue(testObject.isSorted());
	}
	
	@Test
	public void deleteMaxTest_singleDelete() {
		testObject.insert(1);
		testObject.insert(7);
		testObject.insert(4);
		testObject.insert(5);
		testObject.insert(3);
		
		int deleted = testObject.deleteMax();
		
		assertEquals(4, testObject.getSize());
		assertEquals(7, deleted);
	}

	@Test
	public void deleteMaxTest_multipleDeletes() {
		testObject.insert(1);
		testObject.insert(7);
		testObject.insert(4);
		testObject.insert(5);
		testObject.insert(3);
		
		testObject.deleteMax();
		testObject.deleteMax();
		int deleted = testObject.deleteMax();
		
		assertEquals(2, testObject.getSize());
		assertEquals(4, deleted);
	}
	
	@Test
	public void deleteMaxTest_oneItemLeft() {
		testObject.insert(7);
		
		int deleted = testObject.deleteMax();
		
		assertTrue(testObject.isEmpty());
		assertEquals(7, deleted);
	}
	
	@Test(expected = NullPointerException.class)
	public void deleteMaxTest_notEnoughItems() {
		testObject.deleteMax();
	}
}

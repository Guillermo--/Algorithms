package chapter_2.creativeProblems;

import static org.junit.Assert.*;

import org.junit.Test;

import chapter_1.queues.QueueArrayImpl;

public class DequeueSortTest {

	QueueArrayImpl<Integer> testObject = new QueueArrayImpl<Integer>();
	
	@Test
	public void SortTest() {
		testObject.enqueue(2);
		testObject.enqueue(1);
		testObject.enqueue(10);
		testObject.enqueue(3);
		testObject.enqueue(7);
		testObject.enqueue(5);
		testObject.enqueue(6);
		testObject.enqueue(13);
		testObject.enqueue(8);
		testObject.enqueue(12);
		testObject.enqueue(4);
		testObject.enqueue(9);
		testObject.enqueue(11);
		
		DequeueSort.sort(testObject);
				
		assertEquals(13, testObject.getSize());
		assertTrue(testObject.isSortedDesc());
	}

}

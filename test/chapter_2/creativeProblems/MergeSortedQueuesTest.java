package chapter_2.creativeProblems;

import static org.junit.Assert.*;

import org.junit.Test;

import chapter_1.queues.QueueArrayImpl;

public class MergeSortedQueuesTest {

	@Test
	public void mergeSortedQueuesTest_typical() {
		QueueArrayImpl<Integer> queueA = new QueueArrayImpl<Integer>();
		QueueArrayImpl<Integer> queueB = new QueueArrayImpl<Integer>();

		queueA.enqueue(3);
		queueA.enqueue(4);
		queueA.enqueue(5);
		queueA.enqueue(9);
		
		queueB.enqueue(1);
		queueB.enqueue(2);
		queueB.enqueue(6);
		queueB.enqueue(13);
		queueB.enqueue(17);
		queueB.enqueue(21);
		
		QueueArrayImpl<Integer> sortedQueue = MergeSortedQueues.mergeSortedQueues(queueA, queueB);
		
		sortedQueue.printQueue();
		
		assertEquals(10, sortedQueue.getSize());
		assertTrue(sortedQueue.isSortedAsc());
		
	}

}

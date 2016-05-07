package chapter_2.creativeProblems;

import chapter_1.queues.QueueArrayImpl;

public class MergeSortedQueues {
	
	public static QueueArrayImpl<Integer> mergeSortedQueues(QueueArrayImpl<Integer> queueA, QueueArrayImpl<Integer> queueB) {
		QueueArrayImpl<Integer> sortedQueue = new QueueArrayImpl<Integer>();
		
		while(!(queueA.isEmpty() && queueB.isEmpty())) {
			Integer a = null;
			Integer b = null;
			
			if(!queueA.isEmpty()) {
				a = queueA.peekFirstAtTop();
			}
			
			if(!queueB.isEmpty()) {
				b = queueB.peekFirstAtTop();
			}

			if(null != a && null != b) {
				if(a > b) {
					sortedQueue.enqueue(b);
					queueB.pop();
				}
				else {
					sortedQueue.enqueue(a);
					queueA.pop();
				}
			}
			else {
				if(null == a) {
					sortedQueue.enqueue(b);
					queueB.pop();
				}
				else if(null == b){
					sortedQueue.enqueue(a);
					queueA.pop();
				}
			}
		}
		
		return sortedQueue;
	}
}

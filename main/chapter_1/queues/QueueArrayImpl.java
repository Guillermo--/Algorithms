package chapter_1.queues;

/* Top = First in array*/
public class QueueArrayImpl<E> {
	
	int actualSize;
	E[] queue;
	
	@SuppressWarnings("unchecked")
	public QueueArrayImpl() {
		actualSize = 0;
		queue = (E[]) new Object[10];
	}
	
	public int getSize() {
		return actualSize;
	}
	
	public void enqueue(E element) {
		if(actualSize > queue.length/2) {
			resize(queue.length * 2);
		}
		
		queue[actualSize++] = element;
	}
	
	private void resize(int newSize) {
		@SuppressWarnings("unchecked")
		E[] newQueue = (E[]) new Object[newSize];
		
		for(int i = 0; i<actualSize; i++) {
			newQueue[i] = queue[i];
		}
		
		queue = newQueue;
	}
	
	public E peekFirstAtTop() {
		if(actualSize > 0) {
			return queue[0];
		}
		
		throw new NullPointerException();
	}
	
	public E peekSecondAtTop() {
		if(actualSize > 1) {
			return queue[1];
		}
		
		throw new NullPointerException();
	}
	
	public void swapTopTwo() {
		if(actualSize > 1) {
			E temp = queue[0];
			queue[0] = queue[1];
			queue[1] = temp;
		}
		else {
			throw new NullPointerException();
		}
	}
	
	public void moveTopToBottom() {
		if(actualSize > 1) {
			queue[actualSize] = queue[0];
			shiftUp();
		}
		else {
			throw new NullPointerException();
		}
	}
	
	private void shiftUp() {
		for(int i = 1; i<actualSize+1; i++) {
			queue[i-1] = queue[i];
		}
	}
	
	public E peekBottom() {
		if(actualSize > 0) {
			return queue[actualSize-1];
		}
		
		throw new NullPointerException();
	}
	
	public void printQueue() {
		if(actualSize > 0) {
			for(int i = 0; i<actualSize; i++) {
				System.out.println(queue[i]);
			}
		}
	}
	
}

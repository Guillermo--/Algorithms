package chapter_2.priorityQueues;

public class PriorityQueue_OrderedArrayImpl<E extends Comparable<E>> {
	private E[] priorityQueue;
	private int size;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue_OrderedArrayImpl() {
		priorityQueue = (E[]) new Comparable[10];
		size = 0;
	}
	
	public int getSize() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insert(E element) {
		if(size > priorityQueue.length/4) {
			resize(size*4);
		}
		
		if(size == 0) {
			priorityQueue[size++] = element;
		}
		else {
			int insertionIndex = size;
			for(int i = size-1; i >= 0; i--) {
				if(element.compareTo(priorityQueue[i]) < 0) {
					priorityQueue[i + 1] = priorityQueue[i];
					insertionIndex = i;
				}
			}
			priorityQueue[insertionIndex] = element;
			size++;
		}
	}	
	
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		E[] newPriorityQueue = (E[]) new Comparable[newSize];
		
		for(int i = 0; i<size; i++) {
			newPriorityQueue[i] = priorityQueue[i];
		}
		
		priorityQueue = newPriorityQueue;
	}
	
	public boolean isSorted() {
		for(int i = 1; i<size; i++) {
			if(priorityQueue[i].compareTo(priorityQueue[i-1]) < 0) {
				return false;
			}
		}
		return true;
	}
}

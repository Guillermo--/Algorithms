package chapter_2.priorityQueues;

public class PriorityQueue_UnorderedArrayImpl<E extends Comparable<E>> {
	
	private E[] priorityQueue;
	private int size;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue_UnorderedArrayImpl() {
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
		
		priorityQueue[size++] = element;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		E[] newPriorityQueue = (E[]) new Comparable[newSize];
		
		for(int i = 0; i<size; i++) {
			newPriorityQueue[i] = priorityQueue[i];
		}
		
		priorityQueue = newPriorityQueue;
	}

	public E removeMax() {
		if(isEmpty()) {
			throw new NullPointerException();
		}
		
		E removedItem = null;
		
		if(size > 1) {
			int indexOfMax = getIndexOfMax();
			swap(indexOfMax, size-1);
		}
		
		removedItem = priorityQueue[size - 1];
		priorityQueue[size - 1] = null;
		size--;
		
		if(size < priorityQueue.length/4) {
			resize(size*4);
		}
		
		return removedItem;
	}
	
	private int getIndexOfMax() {
		int indexOfMax = 0;
		for(int i = 1; i<size; i++) {
			if(priorityQueue[i].compareTo(priorityQueue[indexOfMax]) > 0) {
				indexOfMax = i;
			}
		}
		
		return indexOfMax;
	}
	
	private void swap(int indexA, int indexB) {
		E temp = priorityQueue[indexB];
		priorityQueue[indexB] = priorityQueue[indexA];
		priorityQueue[indexA] = temp;
	}
	
	
}

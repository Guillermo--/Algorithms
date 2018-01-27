package chapter_2.priorityQueues;

public class PriorityQueue_Heap<E extends Comparable<E>> {
	
	private E[] heap;
	private int size;
	
	@SuppressWarnings("unchecked")
	public PriorityQueue_Heap() {
		heap = (E[]) new Comparable[10];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	private void resize(int newSize) {
		E[] temp = (E[]) new Comparable[newSize];
		
		if(newSize > size) {
			for(int i = 0; i<size+1; i++) {
				temp[i] = heap[i];
			}
		}
		else {
			for(int i = 0; i<newSize; i++) {
				temp[i] = heap[i];
			}
		}
		
		heap = temp;
	}
	
	public void insert(E element) {
		if(size > heap.length/4) {
			resize(size*4);
		}
		
		heap[++size] = element;
		swim(size);
	}
	
	private void swim(int index) {
		int parentIndex = index/2;
		
		while(parentIndex >= 1 && heap[index].compareTo(heap[parentIndex]) > 0) {
			E temp = heap[index];
			heap[index] = heap[parentIndex];
			heap[parentIndex] = temp;
			
			index = parentIndex;
			parentIndex = index/2;
		}
	}
	
	public boolean isSorted() {
		for(int i = 1; i<size; i++) {
			E parent = heap[i];
			
			if(2*i <= size) {
				E leftChild = heap[2*i];
				if(parent.compareTo(leftChild) < 0) {
					return false;
				}
			}
			
			if(2*i + 1 <= size) {
				E rightChild = heap[2*i + 1];
				if(parent.compareTo(rightChild) < 0) {
					return false;
				}
			}
		}
		
		return true;
	}

	public E deleteMax() {
		if(!isEmpty()) {
			sink();
			E deleted = heap[size];
			heap[size] = null;
			size--;
			
			if(size < heap.length/4) {
				resize(size*4);
			}
			
			return deleted;
		}
		
		throw new NullPointerException();
	}
	
	private void sink() {
		int indexOfMax = 1;
		E max = heap[indexOfMax];
		E leftChild = null;
		E rightChild = null;
		
		while(indexOfMax*2 + 1 <= size || indexOfMax*2 <= size) {
			if(indexOfMax*2 + 1 <= size) {
				leftChild = heap[indexOfMax * 2];
				rightChild = heap[indexOfMax*2 + 1];
				
				if(leftChild.compareTo(rightChild) > 0) {
					heap[indexOfMax] = leftChild;
					heap[indexOfMax*2] = max;
					
					indexOfMax = indexOfMax*2;
				}
				else {
					heap[indexOfMax] = rightChild;
					heap[indexOfMax*2 + 1] = max;
					
					indexOfMax = indexOfMax*2 + 1;
				}
			}
			else {
				leftChild = heap[indexOfMax*2];
				
				heap[indexOfMax] = leftChild;
				heap[indexOfMax*2] = max;
				
				indexOfMax = indexOfMax*2;
			}
		}
	}
	

	
}

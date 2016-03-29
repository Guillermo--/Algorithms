package stacks;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class StackArrayImpl<E> {

	private E[] stack;
	private int size;
	
	public StackArrayImpl() {
		stack = (E[]) new Object[1];
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int getSize() {
		return size;
	}
	
	private void resize(int newSize) {
		E[] temp = (E[]) new Object[newSize];
		for(int i = 0; i<size; i++) {
			temp[i] = stack[i];
		}
		stack = temp;
	}

	public void push(E element) {
		stack[size++] = element;
		if(size == stack.length) {
			resize(size*2);
		}
	}

	public E pop() {
		E element = null;
		if(!isEmpty()) {
			element = (E) stack[--size];
			if(size > 0 && size < stack.length/4) {
				resize(stack.length/2);
			}
		}
		else {
			throw new NullPointerException("Cannot pop from an empty Stack.");
		}
		return element;
	}
	
	public E peek() {
		E element = null;
		if(!isEmpty()) {
			element = (E) stack[size - 1];
		}
		else {
			throw new NullPointerException("Cannot peek from an empty Stack.");
		}
		
		return element;
	}

	public Iterator<E> iterator() {
		return new StackArrayIterator();
	}
	
	private class StackArrayIterator implements Iterator<E>{
		int currentIndex;
		private StackArrayIterator() {
			currentIndex = size;
		}
		@Override
		public boolean hasNext() {
			return currentIndex > 0;
		}

		@Override
		public E next() {
			return stack[--currentIndex];
		}
		
	}

}

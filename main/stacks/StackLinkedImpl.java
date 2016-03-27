package stacks;

import java.util.Iterator;

public class StackLinkedImpl<E> {

	private Node root;
	private int size;
	
	private class Node {
		private E element = null;
		private Node next = null;
	}
	
	public StackLinkedImpl() {
		root = null;
		size = 0;
	}
	
	public Node getFirst() {
		return root;
	}
	
	public int getSize() {
		return size;
	}

	public void push(E element) {
		Node newNode = new Node();
		newNode.element = element;
		if(size == 0) {
			root = newNode;
		}
		else {
			getTail().next = newNode;
		}
		size++;
	}
	
	public E pop() {
		E element = null;
		if(!isEmpty()) {
			if(size == 1) {
				element = root.element;
				root = null;
			}
			else if(size == 2) {
				element = root.next.element;
				root.next = null;
			}
			else {
				Node runner = root;
				while(null != runner.next.next) {
					runner = runner.next;
				}
				element = runner.next.element;
				runner.next = null;
			}
			size--;
		}
		else {
			try {
				throw new Exception("Cannot pop from an empty Stack.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		return element;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	private Node getTail() {
		Node runner = root;
		while(null != runner.next){
			runner = runner.next;
		}
		return runner;
	}
	
	private Node getElementAtIndex(int index) {
		Node node = null;
		if(!isEmpty()) {
			Node runner = root;
			for(int i = 0; i<index; i++){
				runner = runner.next;
			}
			node = runner;
		}
		return node;
	}

	public Iterator<E> iterator() {
		return new LinkedStackIterator();
	}
	
	private class LinkedStackIterator implements Iterator<E>{
		private int current = size;
		
		@Override
		public boolean hasNext() {
			return current > 0;
		}

		@Override
		public E next() {
			Node node = getElementAtIndex(--current);
			return node.element;
		}
	}
	
	
}

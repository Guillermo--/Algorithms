package linkedLists;

import java.math.BigDecimal;

public class GLinkedList<E> {

	private Node first;
	private int size;
	
	public class Node {
		public E element;
		public Node next;
	}
	
	public GLinkedList() {
		first = null;
		size = 0;
	}
	
	public Node getFirst() {
		return first;
	}
	
	public void setFirst(Node first) {
		this.first = first;
	}
	
	public int getSize() {
		return size;
	}

	public void insert(E element) {
		Node newNode = new Node();
		newNode.element = element;
		newNode.next = null;
		
		if(size == 0) {
			first = newNode;
		}
		else {
			Node runner = first;
			
			while(runner.next != null) {
				runner = runner.next;
			}
			
			runner.next = newNode;
		}
		size++;
	}

	public E removeLast() {
		E removedElement = null;
				
		if(size > 0) {
			if(size == 1) {
				removedElement = first.element;
				first = null;
			}
			else {
				Node runner = first;
				while(runner.next.next != null) {
					runner = runner.next;
				}
				
				removedElement = runner.next.element;
				runner.next = null;
			}
		} 
		else {
			throw new NullPointerException("Cannot remove from an empty LinkedList.");
		}
		
		size--;
		
		return removedElement;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}

	public E removeKthElement(int position) {
		Node runner = first;
		E removedElement;
		
		if(position <= size) {
			for(int i = 1; i<position-1; i++) {
				runner = runner.next;
			}
			
			removedElement = runner.next.element;
			runner.next = runner.next.next;
			size--;
		} 
		else {
			throw new IndexOutOfBoundsException();
		}
		
		return removedElement;
	}

	public boolean find(E string) {
		Node runner = first;
		
		if(isEmpty()) {
			return false;
		}
		
		if(size == 1) {
			if(runner.element.equals(string)) {
				return true;
			}
		}
		
		while(runner.next != null) {
			if(runner.element.equals(string)) {
				return true;
			}
			runner = runner.next;
		}
		return false;
	}

	public E get(int index) {
		Node runner = first;
		E element;
		
		if(size > 0 && index <= size-1) {
			for(int i = 0; i<index; i++) {
				runner  = runner.next;
			}
			element = runner.element;
		}
		else {
			throw new NullPointerException();
		}
		return element;
	}

	public void insertAfter(E toFind, E toInsert) {
		Node runner = first;
		
		if(null != toFind && null != toInsert) {
			while(runner.next != null) {
				if(runner.element.equals(toFind)) {
					Node newNode = new Node();
					newNode.element = toInsert;
					
					Node temp = runner.next;
					runner.next = newNode;
					newNode.next = temp;
					
					size++;
					
					break;
				}
				
				runner = runner.next;
			}
		}
	}

	public void removeAll(E toRemove) {
		Node preRunner = first;
		Node runner = preRunner.next;
		
		if(!isEmpty()) {
			do{
				if(first.element.equals(toRemove)){
					if(size == 1) {
						first = null;
						size--;
						break;
					}
					if(size == 2) {
						first = first.next;
						runner = first;
						preRunner = runner;
					}
					else {
						first = first.next;
						preRunner = first;
						runner = preRunner.next;
					}
					size--;
				}
				
				else if(runner.element.equals(toRemove)) {
					if(size == 2) {
						first.next = null;
						runner = first;
						preRunner = runner;
					}
					else {
						runner = runner.next;
						preRunner.next = runner;
					}
					size--;
				}
				else {
					if(runner.next != null) {
						preRunner = runner;
						runner = runner.next;						
					}
					else {
						break;
					}
				}
			}
			while(runner.next != null || size == 2 || size == 1);
		}
	}

	public BigDecimal getMax() {
		BigDecimal max = new BigDecimal(String.valueOf(first.element));
		Node runner = first;
		
		if(!isEmpty()) {
			while(runner.next != null) {
				BigDecimal cur = new BigDecimal(String.valueOf(runner.element));
				if(cur.compareTo(max) == 1) {
					max =  cur;
				}
				
				runner = runner.next;
			}
		}
		
		return max;
	}
	
	public BigDecimal getMax_recursive(Node currentNode, BigDecimal currentMax){
		if(currentNode.next != null) {
			BigDecimal currentValue = new BigDecimal(String.valueOf(currentNode.element));
			if(currentValue.compareTo(currentMax) == 1) {
				return getMax_recursive(currentNode.next, currentValue);
			}
			else {
				return getMax_recursive(currentNode.next, currentMax);
			}
		}
		return currentMax;
	}

	public Node reverse() {
		Node futureRoot = null;
		
		if(!isEmpty()) {
			Node previous = first;
			
			if(size == 1) {
				return first;
			}
			
			while(previous.next != null) {
				Node runner = previous.next;
				previous.next = futureRoot;
				futureRoot = previous;
				previous = runner;
				runner = runner.next;
			}
			
			previous.next = futureRoot;
			futureRoot = previous;
		}
		
		return futureRoot;
	}
	
	
	
}

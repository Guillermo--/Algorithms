package chapter_1.linkedLists;

public class GDoubleLinkedList<E> {
	
	private Node first;
	private int size;
	
	protected class Node {
		public E element;
		public Node next;
		public Node previous;
	}
	
	public GDoubleLinkedList() {
		first = null;
		size = 0;
	}

	public Node getFirst() {
		return first;
	}

	public int getSize() {
		return size;
	}

	public boolean isEmpty() {
		return size == 0;
	}
	
	public void insertAtBeginning(E element) {
		Node newNode = new Node();
		newNode.element = element;
		if(isEmpty()){
			first = newNode;
		}
		else {
			if(size == 1) {
				first.previous = newNode;
				first.next = newNode;
				
				newNode.next = first;
				newNode.previous = first;
				
				first = newNode;
			}
			else {
				Node beforeFirst = first.previous;
				 
				beforeFirst.next = newNode;
				first.previous = newNode;
				
				newNode.next = first;
				newNode.previous = beforeFirst;
				
				first = newNode;
			}
		}
		
		size++;
	}

	public void removeFromBeginning() {
		if(!isEmpty()) {
			if(size == 1) {
				first = null;
			}
			else {
				Node beforeFirst = first.previous;
				
				beforeFirst.next = first.next;
				first.next.previous = beforeFirst;
				
				first.previous = null;
				first = first.next;
			}
			size--;
		}
		else {
			throw new NullPointerException();
		}
	}

	public void insertAtEnd(E element) {
		Node newNode = new Node();
		newNode.element = element;
		if(isEmpty()) {
			first = newNode;
		}
		else if(size == 1) {
			first.next = newNode;
			first.previous = newNode;
			newNode.next = first;
			newNode.previous = first;
		}
		else {
			newNode.next = first;
			newNode.previous = first.previous;
			
			first.previous.next = newNode;
			first.previous = newNode;
		}
		size++;
	}

	public void removeFromEnd() {
		if(!isEmpty()) {
			if(size == 1) {
				first = null;
			}
			else {
				first.previous.next = null;
				first.previous.previous.next = first;
				first.previous = first.previous.previous;
			}
			size--;
		}
		else {
			throw new NullPointerException();
		}
	}

	/*Assume only one occurrence of node to be found*/
	public void insertBeforeGivenNode(E toFind, E toInsert) {
		if(!isEmpty()) {
			Node runner = first;
			
			while(runner.next != first) {
				if(runner.element.equals(toFind)) {
					Node newNode = new Node();
					newNode.element = toInsert;
					
					runner.previous.next = newNode;
					newNode.previous = runner.previous;
					
					runner.previous = newNode;
					newNode.next = runner;
					
					size++;
				}
				
				runner = runner.next;
			}
		}
	}

	public void insertAfterGivenNode(E toFind, E toInsert) {
		if(!isEmpty()) {
			Node runner = first;
			
			while(runner.next != first) {
				if(runner.element.equals(toFind)){
					Node newNode = new Node();
					newNode.element = toInsert;
					
					runner.next.previous = newNode;
					newNode.next = runner.next;
					
					runner.next = newNode;
					newNode.previous = runner;
					
					size++;
				}
				
				runner = runner.next;
			}
		}
	}

	public void removeNode(E element) {
		if(!isEmpty()){
			Node runner = first;
			
			while(runner.next != first) {
				if(runner.element.equals(element)) {
					runner.previous.next = runner.next;
					runner.next.previous = runner.previous;
					
					size--;
				}
				
				runner = runner.next;
			}
		}
	}


	

}

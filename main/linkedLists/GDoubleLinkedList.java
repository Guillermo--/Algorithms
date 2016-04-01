package linkedLists;

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

	

}

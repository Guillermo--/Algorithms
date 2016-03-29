package linkedLists;

public class GLinkedList<E> {

	private Node first;
	private int size;
	
	private class Node {
		private E element;
		private Node next;
	}
	
	public GLinkedList() {
		first = null;
		size = 0;
	}
	
	public Node getFirst() {
		return first;
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
			try {
				throw new Exception("Cannot remove from an empty LinkedList.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		size--;
		
		return removedElement;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	
}

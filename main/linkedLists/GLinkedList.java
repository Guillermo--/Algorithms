package linkedLists;

public class GLinkedList<E> {

	private Node first;
	private int size;
	
	public class Node {
		public E element;
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
		
		while(runner.next != null) {
			if(runner.element == string) {
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
						break;
					}
					if(size == 2) {
						first = first.next;
						
					}
					else {
						first = first.next;
						preRunner = first;
						runner = preRunner.next;
					}
				}
				
				else if(runner.element.equals(toRemove)) {
					preRunner.next = runner.next;
					preRunner = preRunner.next;
					runner = runner.next;
				}
			}
			while(runner.next != null);
		}
	}
	
	
	
	
}

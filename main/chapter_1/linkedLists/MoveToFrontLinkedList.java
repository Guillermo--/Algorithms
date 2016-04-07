package chapter_1.linkedLists;

/* Items recently accessed are more likely to be accessed again. */
public class MoveToFrontLinkedList<E> {

	private Node first;
	private int size;
	
	public class Node {
		public E element;
		public Node next;
	}
	
	public MoveToFrontLinkedList() {
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

	public void insert(E element) {
		Node newNode = new Node();
		newNode.element = element;
		
		if(!isEmpty()) {
			if(indexOf(element) > -1) {
				deleteAtIndex(indexOf(element));
			}
			
			newNode.next = first;
		}
		
		first = newNode;
		size++;
	}
	
	private int indexOf(E element) {
		if(!isEmpty()) {
			Node runner = first;
			
			if(size == 1) {
				if(runner.element.equals(element)) {
					return 0;
				}
			}
			
			int indexOf = 0;
			while(runner.next != null) {
				if(runner.element.equals(element)) {
					return indexOf;
				}
				runner = runner.next;
				indexOf++;
			}
		}
		
		return -1;
	}
	
	private void deleteAtIndex(int index) {
		Node runner = first;
		while(index > 1 && runner.next != null) {
			runner = runner.next;
			index--;
		}
		
		runner.next = runner.next.next;
		size--;
	}
}

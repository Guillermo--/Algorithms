package steque;

/* Stack-ended queue, supports push, pop, and enqueue */
public class Steque<E> {

	private Node first;
	private int size;
	
	public class Node {
		E element;
		Node next;
	}
	
	public Steque() {
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

	public void push(E element) {
		Node newNode = new Node();
		newNode.element = element;
		if(!isEmpty()) {
			newNode.next = first;
			first = newNode;
		}
		else {
			first = newNode;
		}
		
		size++;
	}

	public Node pop() {
		Node nodeRemoved = new Node();
		if(!isEmpty()) {
			nodeRemoved = first;
			
			if(size == 1) {
				first = null;
			}
			else {
				Node newFirst = first.next;
				first.next = null;
				first = newFirst;
			}
			
			size--;
		} 
		else {
			throw new NullPointerException();
		}
		
		return nodeRemoved;
	}

	public void enqueue(E element) {
		Node nodeToAdd = new Node();
		nodeToAdd.element = element;
		
		if(!isEmpty()){
			Node runner = first;
			while(runner.next != null) {
				runner = runner.next;
			}
			
			runner.next = nodeToAdd;
		}
		else {
			first = nodeToAdd;
		}
		
		size++;
	}
}

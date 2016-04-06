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
		
		if(!isEmpty()){
			Node runner = first;
			while(runner.next != null) {
				runner = runner.next;
			}
			
			runner.next = newNode;
		}
		else {
			first = newNode;
		}
		
		size++;
	}
}

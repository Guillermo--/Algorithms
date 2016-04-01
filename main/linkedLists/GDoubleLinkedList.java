package linkedLists;

public class GDoubleLinkedList<E> {
	
	private Node first;
	private int size;
	
	private class Node {
		private E element;
		private Node next;
		private Node previous;
	}
	
	public GDoubleLinkedList() {
		first = null;
		size = 0;
	}

}

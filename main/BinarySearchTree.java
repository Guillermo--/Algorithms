import java.util.ArrayList;

@SuppressWarnings("rawtypes")
public class BinarySearchTree {
	
	public Node root;
	public int size;
	
	public class Node {
		Node left;
		Node right;
		Comparable element;
		
		public Node(Comparable element) {
			this.element = element;
		}
	}
	
	public Node getRoot() {
		return root;
	}
	
	public int getSize() {
		return size;
	}
	
	@SuppressWarnings("unchecked")
	public void insert(Comparable element) {
		if(null == root) {
			root = new Node(element);
			size++;
			return;
		}
		
		Node runner = root;
		
		while(true) {
			if(runner.element.compareTo(element) < 0) {
				if(null == runner.right) {
					runner.right = new Node(element);
					size++;
					return;
				} else {
					runner = runner.right;					
				}
			} else {
				if(null == runner.left) {
					runner.left = new Node(element);
					size++;
					return;
				} else {
					runner = runner.left;					
				}
			}
		}	
	}

	public boolean isBST() {
		return isBST(root);
	}
	
	@SuppressWarnings("unchecked")
	private boolean isBST(Node node) {
		boolean isBSTLeft = true;
		boolean isBSTRight = true;

		if(null != node.left) {
			if(node.left.element.compareTo(node.element) < 0) {
				isBSTLeft = isBST(node.left);
			} else {
				return false;
			}
		}
		
		if(null != node.right) {
			if(node.right.element.compareTo(node.element) > 0) {
				isBSTRight = isBST(node.right);
			} else {
				return false;
			}
		}
		
		return isBSTLeft && isBSTRight;
	}

	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}

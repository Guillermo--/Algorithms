import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;


public class BinarySearchTreeTest {

	BinarySearchTree tree;
	
/*		 
 		 9
	  /	  	\
	 3     	 15
	/  \     /
   2    4   11

*/
	
	@Test
	public void insertTest() {
		tree = new BinarySearchTree();
		tree.insert(9);
		tree.insert(3);
		tree.insert(2);
		tree.insert(4);
		tree.insert(15);
		tree.insert(11);

		assertEquals(6, tree.getSize());
		assertEquals(9, tree.getRoot().element);
		assertEquals(3, tree.getRoot().left.element);
		assertEquals(2, tree.getRoot().left.left.element);
		assertEquals(4, tree.getRoot().left.right.element);
		assertEquals(15, tree.getRoot().right.element);
		assertEquals(11, tree.getRoot().right.left.element);

	}

	@Test
	public void isBSTTest() {
		tree = new BinarySearchTree();
		tree.insert(9);
		tree.insert(3);
		tree.insert(2);
		tree.insert(4);
		tree.insert(15);
		tree.insert(11);
		
		assertTrue(tree.isBST());
		
		tree = new BinarySearchTree();
		tree.insert(20);
		tree.getRoot().right = tree.new Node(30);
		tree.getRoot().left = tree.new Node(10);
		tree.getRoot().left.right = tree.new Node(25);

		assertFalse(tree.isBST());
	}
}

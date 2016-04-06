package linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GDoubleLinkedListTest {
	
	GDoubleLinkedList<Object> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new GDoubleLinkedList<>();
		
		assertNull(testObject.getFirst());
		assertEquals(0, testObject.getSize());
	}
	
	@Test
	public void insertAtBeginningTest() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtBeginning("Guillermo");
		testObject.insertAtBeginning("Cecilia");
		testObject.insertAtBeginning("Elena");
		testObject.insertAtBeginning("Manuel");

		assertEquals("Manuel", testObject.getFirst().element);
		assertEquals("Guillermo", testObject.getFirst().previous.element);
		assertEquals("Elena", testObject.getFirst().next.element);
		assertEquals(4, testObject.getSize());
	}
	
	@Test
	public void removeFromBeginningTest() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtBeginning("Guillermo");
		testObject.insertAtBeginning("Cecilia");
		testObject.insertAtBeginning("Elena");
		testObject.insertAtBeginning("Manuel");
		
		testObject.removeFromBeginning();

		assertEquals("Elena", testObject.getFirst().element);
		assertEquals("Cecilia", testObject.getFirst().next.element);
		assertEquals("Guillermo", testObject.getFirst().previous.element);
		assertEquals(3, testObject.getSize());
	}
	
	@Test
	public void removeFromBeginningTest_sizeOneList() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtBeginning("Guillermo");
		
		testObject.removeFromBeginning();
		
		assertTrue(testObject.isEmpty());
		assertNull(testObject.getFirst());
	}
	
	@Test
	public void removeFromBeginningTest_sizeTwoList() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtBeginning("Guillermo");
		testObject.insertAtBeginning("Manuel");
		
		testObject.removeFromBeginning();

		assertEquals(1, testObject.getSize());
		assertEquals("Guillermo", testObject.getFirst().element);
	}
	
	@Test(expected = NullPointerException.class)
	public void removeFromBeginningTest_emptyList() {
		testObject = new GDoubleLinkedList<>();
		testObject.removeFromBeginning();
	}
	
	@Test
	public void insertAtEndTest() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtEnd("Guillermo");
		testObject.insertAtEnd("Manuel");
		
		assertEquals(2, testObject.getSize());
		assertEquals("Guillermo", testObject.getFirst().element);
	}
	
	@Test
	public void removeFromEndTest_typical() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtEnd("Guillermo");
		testObject.insertAtEnd("Manuel");
		testObject.insertAtEnd("Cecilia");
		testObject.insertAtEnd("Elena");
		
		testObject.removeFromEnd();
		testObject.removeFromEnd();
		
		assertEquals(2, testObject.getSize());
		assertEquals("Guillermo", testObject.getFirst().element);
		assertEquals("Manuel", testObject.getFirst().next.element);
		assertEquals("Manuel", testObject.getFirst().previous.element);
	}
	
	@Test(expected = NullPointerException.class)
	public void removeFromEndTest_emptyList() {
		testObject = new GDoubleLinkedList<>();
		testObject.removeFromEnd();
	}
	
	@Test
	public void insertBeforeGivenNodeTest() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtEnd("Guillermo");
		testObject.insertAtEnd("Manuel");
		testObject.insertAtEnd("Cecilia");
		testObject.insertAtEnd("Elena");
		
		testObject.insertBeforeGivenNode("Cecilia", "Jas");
		testObject.insertBeforeGivenNode("Guillermo", "Mi");
		
		assertEquals(6, testObject.getSize());
		assertEquals("Jas", testObject.getFirst().next.next.element);
		assertEquals("Mi", testObject.getFirst().previous.element);
	}
	
	@Test
	public void insertAfterGivenNodeTest() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtEnd("Guillermo");
		testObject.insertAtEnd("Manuel");
		testObject.insertAtEnd("Cecilia");
		testObject.insertAtEnd("Elena");
		
		testObject.insertAfterGivenNode("Guillermo", "Jas");
		
		assertEquals(5, testObject.getSize());
		assertEquals("Jas", testObject.getFirst().next.element);
	}
	
	@Test
	public void removeNodeTest() {
		testObject = new GDoubleLinkedList<>();
		testObject.insertAtEnd("Guillermo");
		testObject.insertAtEnd("Manuel");
		testObject.insertAtEnd("Cecilia");
		testObject.insertAtEnd("Elena");
		
		testObject.removeNode("Manuel");
		
		assertEquals(3, testObject.getSize());
		assertEquals("Cecilia", testObject.getFirst().next.element);
	}

}

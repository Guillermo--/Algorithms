package linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;

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
	public void insertAtBeginningTest_insertFirstElement() {
		testObject = new GDoubleLinkedList<>();
		
		testObject.insertAtBeginning("Guillermo");
		
		assertFalse(testObject.isEmpty());
		assertEquals("Guillermo", testObject.getFirst().element);
		assertEquals(1, testObject.getSize());
	}
	
	@Test
	public void insertAtBeginningTest_insertSecondElement() {
		testObject = new GDoubleLinkedList<>();
		
		testObject.insertAtBeginning("Guillermo");
		testObject.insertAtBeginning("Cecilia");
		
		assertEquals("Cecilia", testObject.getFirst().element);
		assertEquals("Guillermo", testObject.getFirst().next.element);
		assertEquals(2, testObject.getSize());
	}
	
	@Test
	public void insertAtBeginningTest_insertMultipleElements() {
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
		
	}

}

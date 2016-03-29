package linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class GLinkedListTest {

	GLinkedList<Object> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new GLinkedList<>();
		assertNotNull(testObject);
		assertNull(testObject.getFirst());
		assertEquals(0, testObject.getSize());
	}
	
	@Test
	public void insertTest() {
		testObject = new GLinkedList<>();
		testObject.insert(new Object());
		testObject.insert(new Object());
		testObject.insert(new Object());
		
		assertEquals(3, testObject.getSize());
	}
	
	@Test
	public void removeLastTest_typical() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		testObject.insert("Cecilia");
		
		String removed = testObject.removeLast();
		
		assertEquals(3, testObject.getSize());
		assertEquals("Cecilia", removed);
	}
	
	@Test
	public void removeLastTest_twoElementsInList() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Manuel");
		
		String removed = testObject.removeLast();
		
		assertEquals("Manuel", removed);
		assertEquals(1, testObject.getSize());
	}
	
	@Test
	public void removeLastTest_oneElementInList() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Cecilia");
		testObject.insert("Manuel");
		
		String removed = testObject.removeLast();
		
		assertEquals("Manuel", removed);
		assertEquals(2, testObject.getSize());
	}
	
	@Test
	public void removeLastTest_removeAllElements() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Cecilia");
		testObject.insert("Manuel");
		
		testObject.removeLast();
		testObject.removeLast();
		testObject.removeLast();
		
		assertTrue(testObject.isEmpty());
		assertNull(testObject.getFirst());
	}
	
	@Test
	public void removeLastTest_removeFromEmptyList() {
		testObject = new GLinkedList<>();
		try {
			testObject.removeLast();
		}
		catch(Exception e) {
			assertEquals("Cannot remove from an empty LinkedList.", e.getMessage());
		}
		
	}

}

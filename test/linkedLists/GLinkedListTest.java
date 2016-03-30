package linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
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
	
	@Test(expected = NullPointerException.class)
	public void removeLastTest_removeFromEmptyList() {
		testObject = new GLinkedList<>();
		testObject.removeLast();
	}
	
	@Test
	public void removeKthElementTest_typical() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		testObject.insert("Cecilia");
		
		String removedElement = testObject.removeKthElement(3);
		
		assertEquals(3, testObject.getSize());
		assertEquals("Elena", removedElement);
	}
	
	@Test(expected = IndexOutOfBoundsException.class)
	public void removeKthElementTest_outOfBounds() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		testObject.insert("Cecilia");
		
		testObject.removeKthElement(6);
	}
	
	@Test
	public void findTest_typical() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		testObject.insert("Cecilia");
		
		assertTrue(testObject.find("Manuel"));
		assertFalse(testObject.find("Jasmine"));
	}
	
	@Test
	public void findTest_emptyList() {
		GLinkedList<String> testObject = new GLinkedList<>();
		assertFalse(testObject.find("Memo"));
	}
	
	@Test
	public void insertAfterTest() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		testObject.insert("Cecilia");
		
		testObject.insertAfter("Manuel", "Chu");
		
		assertEquals(5, testObject.getSize());
		assertEquals("Chu", testObject.get(2));
	}
	
	@Test
	public void getTest_typical(){
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		testObject.insert("Cecilia");
		
		assertEquals("Elena", testObject.get(2));
	}
	
	@Test
	public void getTest_oneElement(){
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("Guillermo");
		
		assertEquals("Guillermo", testObject.get(0));
	}
	
	@Test
	public void removeAllTest_typical() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("a");
		testObject.insert("b");
		testObject.insert("b");
		testObject.insert("c");
		testObject.insert("e");
		testObject.insert("a");
		testObject.insert("w");
		
		testObject.removeAll("b");
		
		assertEquals(5, testObject.getSize());
		assertFalse(testObject.find("b"));
	}
	
	@Test
	public void removeAllTest_removeAllItems() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("a");
		testObject.insert("a");
		testObject.insert("a");
		testObject.insert("a");
		
		testObject.removeAll("a");
		
		assertTrue(testObject.isEmpty());
	}
	

}

package linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

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
		
	}
	
	@Test
	public void removeLastTest_oneElementInList() {
		
	}

}

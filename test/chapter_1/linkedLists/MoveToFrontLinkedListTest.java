package chapter_1.linkedLists;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoveToFrontLinkedListTest {

	MoveToFrontLinkedList<Object> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new MoveToFrontLinkedList<>();
		assertNull(testObject.getFirst());
		assertTrue(testObject.isEmpty());
	}
	
	@Test
	public void insertTest_nonDuplicates() {
		MoveToFrontLinkedList<String> testObject = new MoveToFrontLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Cecilia");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		
		assertEquals("Elena", testObject.getFirst().element);
		assertEquals(4, testObject.getSize());
	}
	
	@Test
	public void insertTest_duplicates() {
		MoveToFrontLinkedList<String> testObject = new MoveToFrontLinkedList<>();
		testObject.insert("Guillermo");
		testObject.insert("Cecilia");
		testObject.insert("Manuel");
		testObject.insert("Elena");
		testObject.insert("Cecilia");
		
		assertEquals(4, testObject.getSize());
		assertEquals("Cecilia", testObject.getFirst().element);
		assertEquals("Guillermo", testObject.getFirst().next.next.next.element);
	}

}

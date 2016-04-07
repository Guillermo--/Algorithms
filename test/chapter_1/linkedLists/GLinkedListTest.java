package chapter_1.linkedLists;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;

import org.junit.Test;

import chapter_1.linkedLists.GLinkedList;

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
	
	@Test
	public void removeAllTest_removeOneFromTwoItemList() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("a");
		testObject.insert("b");
		
		testObject.removeAll("b");
		
		assertEquals(1, testObject.getSize());
		assertTrue(testObject.find("a"));
		assertFalse(testObject.find("b"));
	}
	
	@Test
	public void getMaxTest_iterative() {
		GLinkedList<Integer> testObject = new GLinkedList<>();
		testObject.insert(8);
		testObject.insert(15);
		testObject.insert(6);
		testObject.insert(7);
		testObject.insert(9);
		testObject.insert(10);
		testObject.insert(14);
		
		BigDecimal max = testObject.getMax();
		
		assertEquals(new BigDecimal(15), max);
	}
	
	@Test
	public void getMaxTest_recursive() {
		GLinkedList<Integer> testObject = new GLinkedList<>();
		testObject.insert(8);
		testObject.insert(15);
		testObject.insert(6);
		testObject.insert(7);
		testObject.insert(9);
		testObject.insert(10);
		testObject.insert(14);
		
		BigDecimal max = testObject.getMax_recursive(testObject.getFirst(), new BigDecimal(0));
		
		assertEquals(new BigDecimal(15), max);
	}
	
	@Test
	public void reverseTest() {
		GLinkedList<String> testObject = new GLinkedList<>();
		testObject.insert("a");
		testObject.insert("b");
		testObject.insert("c");
		testObject.insert("d");
		
		GLinkedList<String> reversedList = new GLinkedList<>();
		reversedList.setFirst(testObject.reverse());
		
		assertEquals("d", reversedList.getFirst().element);
		assertEquals("c", reversedList.getFirst().next.element);
		assertEquals("b", reversedList.getFirst().next.next.element);
		assertEquals("a", reversedList.getFirst().next.next.next.element);
	}
	
	

}

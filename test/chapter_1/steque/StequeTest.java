package chapter_1.steque;

import chapter_1.steque.Steque.Node;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class StequeTest {

	Steque<Object> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new Steque<>();
		assertNull(testObject.getFirst());
		assertEquals(0, testObject.getSize());
	}
	
	@Test
	public void pushTest() {
		Steque<String> testObject = new Steque<>();
		testObject.push("Guillermo");
		testObject.push("Cecilia");
		testObject.push("Elena");
		
		assertEquals(3, testObject.getSize());
		assertEquals("Elena", testObject.getFirst().element);
		assertEquals("Cecilia", testObject.getFirst().next.element);
		assertEquals("Guillermo", testObject.getFirst().next.next.element);
	}
	
	@SuppressWarnings("rawtypes")
	@Test
	public void popTest_typical() {
		Steque<String> testObject = new Steque<>();
		testObject.push("Guillermo");
		testObject.push("Cecilia");
		testObject.push("Elena");
		
		Node nodeRemoved = testObject.pop();
		
		assertEquals(2, testObject.getSize());
		assertEquals("Elena", nodeRemoved.element);
	}

	
	@Test
	public void enqueueTest_typical() {
		Steque<String> testObject = new Steque<>();
		testObject.enqueue("Guillermo");
		testObject.enqueue("Elena");
		testObject.enqueue("Manuel");
		
		assertEquals(3, testObject.getSize());
		assertEquals("Guillermo", testObject.getFirst().element);
	}
	
	@Test
	public void multipleOperationsTest() {
		Steque<String> testObject = new Steque<>();
		testObject.push("Guillermo");
		testObject.push("Manuel");
		testObject.enqueue("Cecilia");
		testObject.push("Elena");
		
		assertEquals(4, testObject.getSize());
		assertEquals("Elena", testObject.pop().element);
		assertEquals("Manuel", testObject.pop().element);
		assertEquals("Guillermo", testObject.pop().element);
		assertEquals("Cecilia", testObject.pop().element);
		assertTrue(testObject.isEmpty());
	}

}

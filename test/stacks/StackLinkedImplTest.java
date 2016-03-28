package stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import org.junit.Test;

public class StackLinkedImplTest {

	StackLinkedImpl<Object> testObj;
	
	@Test
	public void constructorTest() {
		testObj = new StackLinkedImpl<>();
		
		assertNotNull(testObj);
		assertNull(testObj.getFirst());
		assertEquals(0, testObj.getSize());
	}
	
	@Test
	public void pushTest() {
		testObj = new StackLinkedImpl<>();
		testObj.push(new Object());
		testObj.push(new Object());
		testObj.push(new Object());

		assertEquals(3, testObj.getSize());
		assertFalse(testObj.isEmpty());
	}
	
	@Test
	public void popTest_typical() {
		StackLinkedImpl<String> linkedStack = new StackLinkedImpl<>();
		linkedStack.push("Elena");
		linkedStack.push("Manuel");
		linkedStack.push("Guillermo");
		
		linkedStack.pop();
		String actualElement = linkedStack.pop();
		
		assertEquals(1, linkedStack.getSize());
		assertEquals("Manuel", actualElement);
	}
	
	@Test
	public void popTest_lastElement() {
		StackLinkedImpl<String> linkedStack = new StackLinkedImpl<>();
		linkedStack.push("Elena");
		
		String actualElement = linkedStack.pop();
		
		assertTrue(linkedStack.isEmpty());
		assertEquals("Elena", actualElement);
	}
	
	@Test
	public void popTest_emptyStack() {
		testObj = new StackLinkedImpl<>();
		try {
			testObj.pop();
		}
		catch(Exception e) {
			assertEquals("Cannot pop from an empty Stack.", e.getMessage());
		}
	}
	
	@Test
	public void iteratorTest() {
		testObj = new StackLinkedImpl<>();
		testObj.push("Elena");
		testObj.push("Manuel");
		testObj.push("Guillermo");
		
		Iterator<Object> iterator = testObj.iterator();
		
		assertTrue(iterator.hasNext());
		assertEquals("Guillermo", iterator.next());
		assertEquals("Manuel", iterator.next());
		assertEquals("Elena", iterator.next());
		assertFalse(iterator.hasNext());
	}
}

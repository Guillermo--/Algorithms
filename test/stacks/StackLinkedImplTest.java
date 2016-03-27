package stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class StackLinkedImplTest {

	StackLinkedImpl<Object> linkedStack;
	
	@Test
	public void constructorTest() {
		linkedStack = new StackLinkedImpl<>();
		
		assertNotNull(linkedStack);
		assertNull(linkedStack.getFirst());
		assertEquals(0, linkedStack.getSize());
	}
	
	@Test
	public void pushTest() {
		linkedStack = new StackLinkedImpl<>();
		linkedStack.push(new Object());
		linkedStack.push(new Object());
		linkedStack.push(new Object());

		assertEquals(3, linkedStack.getSize());
		assertFalse(linkedStack.isEmpty());
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
		StackLinkedImpl<String> linkedStack = new StackLinkedImpl<>();
		try {
			linkedStack.pop();
		}
		catch(Exception e) {
			assertEquals("Cannot pop from an empty Stack.", e.getMessage());
		}
	}
	

}

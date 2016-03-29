package stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.Iterator;
import org.junit.Test;

public class StackArrayImplTest {

	StackArrayImpl<Object> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new StackArrayImpl<>();
		assertNotNull(testObject);
		assertTrue(testObject.isEmpty());
	}
	
	@Test
	public void isEmptyTest() {
		testObject = new StackArrayImpl<>();
		assertTrue(testObject.isEmpty());
		
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());
		
		assertFalse(testObject.isEmpty());
	}
	
	@Test
	public void pushTest_typical() {
		testObject = new StackArrayImpl<>();
		testObject.push(new Object());
		
		assertEquals(1, testObject.getSize());
	}
	
	@Test
	public void pushTest_needResize() {
		testObject = new StackArrayImpl<>();
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());
		
		assertEquals(4, testObject.getSize());
	}
	
	@Test
	public void popTest_sizeAfterSinglePop() {
		testObject = new StackArrayImpl<>();
		testObject.push(new Object());
		Object object = testObject.pop();
		
		assertNotNull(object);
		assertTrue(testObject.isEmpty());
	}
	
	@Test
	public void popTest_sizeAfterMultiplePops() {
		testObject = new StackArrayImpl<>();
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());

		testObject.pop();
		testObject.pop();
		
		assertEquals(3, testObject.getSize());
	}
	
	@Test
	public void popTest_popReturnsCorrectElement() {
		StackArrayImpl<String> testObject = new StackArrayImpl<>();
		testObject.push(new String("Guillermo"));
		testObject.push(new String("Cecilia"));
		testObject.push(new String("Elena"));
		testObject.push(new String("Manuel"));

		testObject.pop();
		String actualString = testObject.pop();
		
		assertEquals("Elena", actualString);
	}
	
	@Test(expected = NullPointerException.class)
	public void popTest_emptyStack() {
		testObject = new StackArrayImpl<>();
		testObject.pop();
	}
	
	@Test
	public void peekTest_typical() {
		StackArrayImpl<String> testObject = new StackArrayImpl<>();
		testObject.push(new String("Guillermo"));
		testObject.push(new String("Cecilia"));
		testObject.push(new String("Elena"));
		testObject.push(new String("Manuel"));
		
		String peekedString = testObject.peek();
		
		assertEquals("Manuel", peekedString);
		assertEquals(4, testObject.getSize());
	}
	
	@Test(expected = NullPointerException.class)
	public void peekTest_emptyStack() {
		testObject = new StackArrayImpl<>();
		testObject.peek();
	}
	
	@Test
	public <E> void iteratorTest_constructor(){
		testObject = new StackArrayImpl<>();
		
		@SuppressWarnings("unchecked")
		Iterator<E> stackIterator = (Iterator<E>) testObject.iterator();
		assertNotNull(stackIterator);
	}
	
	@Test
	public void iteratorTest_hasNext() {
		StackArrayImpl<Object> testObject = new StackArrayImpl<>();
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());
		testObject.push(new Object());
		Iterator<Object> stackIterator = testObject.iterator();
		
		assertTrue(stackIterator.hasNext());
	
		testObject = new StackArrayImpl<>();
		stackIterator = testObject.iterator();
		
		assertFalse(stackIterator.hasNext());
	}
	
	@Test
	public void iteratorTest_next(){
		StackArrayImpl<String> testObject = new StackArrayImpl<>();
		testObject.push(new String("Guillermo"));
		testObject.push(new String("Cecilia"));
		testObject.push(new String("Elena"));
		testObject.push(new String("Manuel"));
		Iterator<String> stackIterator = testObject.iterator();

		assertTrue(stackIterator.hasNext());
		
		assertEquals("Manuel", stackIterator.next());
		assertEquals("Elena", stackIterator.next());
		assertEquals("Cecilia", stackIterator.next());
		assertEquals("Guillermo", stackIterator.next());
		
		assertFalse(stackIterator.hasNext());

	}

}

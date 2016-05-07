package chapter_1.queues;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class QueueArrayImplTest {

	QueueArrayImpl<Object> testObject;
	
	@Test
	public void constructorTest() {
		testObject = new QueueArrayImpl<>();		
		assertTrue(testObject.getSize() == 0);
	}
	
	@Test
	public void enqueueTest_typical() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");
		testObject.enqueue("Elena");
		testObject.enqueue("Jas");
		
		assertEquals(4, testObject.getSize());
	}
	
	@Test
	public void enqueueTest_needsResize() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");
		testObject.enqueue("Elena");
		testObject.enqueue("Jas");
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");
		testObject.enqueue("Elena");
		testObject.enqueue("Jas");
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");

		assertEquals(10, testObject.getSize());
	}
	
	@Test
	public void peekTest_typical() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");
		testObject.enqueue("Elena");
		testObject.enqueue("Jas");
		testObject.enqueue("Manuel");

		assertEquals("Guillermo", testObject.peekFirstAtTop());
		assertEquals("Cecilia", testObject.peekSecondAtTop());
	}
	
	@Test(expected = NullPointerException.class)
	public void peekTest_notEnoughElements() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		
		testObject.peekSecondAtTop();
	}
	
	@Test
	public void swapTwoOnTopTest_typical() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");
		testObject.enqueue("Elena");
		testObject.enqueue("Jas");
		testObject.enqueue("Manuel");
		
		testObject.swapTopTwo();
		
		assertEquals(5, testObject.getSize());
		assertEquals("Cecilia", testObject.peekFirstAtTop());
		assertEquals("Guillermo", testObject.peekSecondAtTop());
	}
	
	@Test(expected = NullPointerException.class) 
	public void swapTwoOnTopTest_notEnoughElements() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		
		testObject.swapTopTwo();
	}
	
	@Test
	public void moveTopToBottomTest_typical() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");
		testObject.enqueue("Elena");
		testObject.enqueue("Jas");
		testObject.enqueue("Manuel");
		
		testObject.moveTopToBottom();
		
		assertEquals(5, testObject.getSize());
		assertEquals("Cecilia", testObject.peekFirstAtTop());
		assertEquals("Guillermo", testObject.peekBottom());
	}
	
	@Test
	public void popTest_typical() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.enqueue("Guillermo");
		testObject.enqueue("Cecilia");
		testObject.enqueue("Elena");
		testObject.enqueue("Jas");
		testObject.enqueue("Manuel");
		
		testObject.pop();
		
		assertEquals(4, testObject.getSize());
		assertEquals("Cecilia", testObject.peekFirstAtTop());
		assertEquals("Manuel", testObject.peekBottom());
	}
	
	@Test(expected = NullPointerException.class)
	public void popTest_notEnoughElements() {
		QueueArrayImpl<String> testObject = new QueueArrayImpl<>();
		testObject.pop();
	}
}

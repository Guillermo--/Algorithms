package steque;

import static org.junit.Assert.*;

import org.junit.Test;

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
		assertEquals("Guillermo", testObject.getFirst().element);
	}

}

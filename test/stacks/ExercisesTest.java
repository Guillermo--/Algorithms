package stacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ExercisesTest {

	Exercises testObject = new Exercises();
	
	@Test
	public void areParenthesisBalancedTest() {
		boolean balanced = testObject.areParenthesisBalanced("[()]{}{[()()]()}");
		boolean notBalanced = testObject.areParenthesisBalanced("[(])");
		assertTrue(balanced);
		assertFalse(notBalanced);
	}

}

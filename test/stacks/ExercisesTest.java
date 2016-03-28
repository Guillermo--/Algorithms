package stacks;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Ignore;
import org.junit.Test;

import stacks.Exercises.CopyStack;

public class ExercisesTest {

	Exercises testObject = new Exercises();
	
	@Test
	public void areParenthesisBalancedTest() {
		boolean balanced = testObject.areParenthesisBalanced("[()]{}{[()()]()}");
		boolean notBalanced = testObject.areParenthesisBalanced("[(])");
		
		assertTrue(balanced);
		assertFalse(notBalanced);
	}
	
	@Ignore
	@Test
	public void insertLeftParenthesis() {
		String input = "1+2)*3-4)*5-6)))";
		String actualOutput = testObject.insertLeftParenthesis(input);
		String expectedOutput = "((1+2)*((3-4)*(5-6)))";
		
		assertEquals(expectedOutput, actualOutput);
	}
	
	@Test
	public void copyStacktest() {
		Stack<String> stack = new Stack<>();
		stack.push("Guillermo");
		stack.push("Manuel");
		stack.push("Elena");
		stack.push("cecilia");
		
		Stack<String> newStack = CopyStack.copy(stack);
		
		assertEquals(stack.size(), newStack.size());
		
		for(int i = 0; i<stack.size(); i++) {
			assertEquals(stack.get(i), newStack.get(i));
		}
	}

}

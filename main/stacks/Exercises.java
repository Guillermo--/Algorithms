package stacks;

import java.util.Stack;

public class Exercises {

	//Assuming parenthesis will only be in the inner most positions. 
	//(i.e. always inside square brackets, which in turn will always be inside curly braces)
	public boolean areParenthesisBalanced(String string) {
		Stack<Character> stack = new Stack<>();
		for(int i = 0; i<string.length(); i++) {
			if(string.charAt(i) != ')') {
				stack.push(string.charAt(i));
			}
			else {
				if(stack.pop() != '(') {
					return false;
				}
			}
		}
		return true;
	}
	
	
}

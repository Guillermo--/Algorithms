package chapter_1.stacks;

import java.util.Stack;


public class Exercises {
	
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

	public String insertLeftParenthesis(String input) {
		return null;
	}
	
	public static class CopyStack {
		
		@SuppressWarnings("unchecked")
		public static <E> Stack<E> copy(Stack<E> stack) {
			Stack<E> newStack = new Stack<>();
			Stack<E> temp = new Stack<>();
			
			for(Object element : stack) {
				temp.push((E) element);
			}
			
			for(Object element : temp) {
				newStack.push((E) element);
			}
			
			temp = null;
			
			return newStack;
		}
	}
	
	
}

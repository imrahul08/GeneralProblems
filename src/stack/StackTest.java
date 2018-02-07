package stack;

import static org.junit.Assert.*;

import org.junit.Test;

public class StackTest {


	@Test
	public void testPush() {
		Stack<Integer> stack = new Stack<>(3);
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertTrue(stack.toString().equals("[3,4,5]"));
	}

	@Test
	public void testPop() {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		stack.push(5);
		assertTrue(stack.pop()==5);
		assertTrue(stack.pop()==4);
		assertTrue(stack.pop()==3);
		
	}

	@Test
	public void testToString() {
		Stack<Integer> stack = new Stack<>();
		stack.push(3);
		stack.push(4);
		assertTrue(stack.toString().equals("[3,4]"));
	}

}

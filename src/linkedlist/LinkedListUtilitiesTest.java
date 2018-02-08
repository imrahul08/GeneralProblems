package linkedlist;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class LinkedListUtilitiesTest {
	
	Node node;

	@Before
	public void setUp() throws Exception {
		node = LinkedListUtilities.createTestList();
	}



	@Test
	public void testLength() {
		assertTrue(LinkedListUtilities.length(node)==5);
	}

	@Test
	public void testCheckIfLoop() {
		assertFalse(LinkedListUtilities.checkIfLoop(node));
		node.next.next.next.next.next = node;
		assertTrue(LinkedListUtilities.checkIfLoop(node));
	}

}

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

	@Test
	public void testCreateList(){
		Node start = LinkedListUtilities.createList(null, 1);
		start = LinkedListUtilities.createList(start, 2);
		start = LinkedListUtilities.createList(start, 3);
		start = LinkedListUtilities.createList(start, 4);
		assertTrue(LinkedListUtilities.length(start)==4);
		LinkedListUtilities.travereList(start);
		System.out.println();
	}
	
	@Test
	public void testCreateListFromArray(){
		int[] arr = {1,2,3,4};
		Node start = LinkedListUtilities.createLinkedList(arr);
		System.out.println();
		LinkedListUtilities.travereList(start);
	}
	
	@Test
	public void multiplyListTest(){
		Node node1 = LinkedListUtilities.createList(null, 1);
		node1 = LinkedListUtilities.createList(node1, 2);
		Node node2 = LinkedListUtilities.createList(null, 1);
		node2 = LinkedListUtilities.createList(node2, 2);
		System.out.println();
		LinkedListUtilities.travereList(node1);
		System.out.println();
		LinkedListUtilities.travereList(node2);
		Node node3 = LinkedListUtilities.multiplyList(node1, node2);
		System.out.println();
		LinkedListUtilities.travereList(node3);
		
	}
}

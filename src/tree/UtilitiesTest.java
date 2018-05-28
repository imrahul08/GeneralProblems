package tree;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class UtilitiesTest {

	Tree root;
	@Before
	public void setUp() throws Exception {
		root = Utilities.createTestTree();
	}

	@After
	public void tearDown() throws Exception {
		root = null;
	}

	@Test
	public void testCheckIfElementExists() {
		Utilities.inorder(root);
		assertTrue(Utilities.checkIfElementExists(root, 8));
		assertTrue(Utilities.checkIfElementExists(root, 12));
		assertTrue(Utilities.checkIfElementExists(root, 1));
		assertFalse(Utilities.checkIfElementExists(root, 6));
		
		
	}
	
	@Test
	public void testPathFromRootToNode() {
		Utilities.levelOrder(root);
		List<Integer> l1 = Utilities.pathFromRootToNode(root, 4, new ArrayList<>());
		System.out.println();
		System.out.println(l1);
		
		List<Integer> l2 = Utilities.pathFromRootToNode(root, 6, new ArrayList<>());
		System.out.println();
		System.out.println(l2);
		
		List<Integer> l3 = Utilities.pathFromRootToNode(root, 9, new ArrayList<>());
		System.out.println();
		System.out.println(l3);
	}

}

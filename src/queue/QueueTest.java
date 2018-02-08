package queue;

import static org.junit.Assert.*;

import org.junit.Test;

public class QueueTest {

	@Test(expected = RuntimeException.class)
	public void testQueue() {
		Queue<Integer> queue = new Queue<>(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
	}

	@Test
	public void testEnqueue() {
		Queue<Integer> queue = new Queue<>(3);
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.dequeue();
		queue.enqueue(1);
		queue.dequeue();
		queue.enqueue(2);
		System.out.println(queue);
		assertTrue("[3,1,2]".equals(queue.toString()));
		
	}

	@Test
	public void testDequeue() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		assertTrue(queue.dequeue()==1);
		assertTrue(queue.dequeue()==2);
		assertTrue(queue.dequeue()==3);
		assertTrue(queue.dequeue()==4);
		
	}

	@Test(expected = RuntimeException.class)
	public void testToString() {
		Queue<Integer> queue = new Queue<>();
		queue.enqueue(1);
		queue.enqueue(2);
		queue.enqueue(3);
		queue.enqueue(4);
		queue.enqueue(5);
		queue.enqueue(6);
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		
		assertTrue("[]".equals(queue.toString()));
		queue.dequeue();
		
	}

}

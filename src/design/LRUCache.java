package design;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {
	private Map<String, Node> map;
	private Node head;
	private Node tail;
	private int size;
	private int counter;
	
	public LRUCache(){
		this(10);
	}
	
	public LRUCache(int size){
		this.size = size;
		this.counter = 0;
		this.map = new HashMap<>(this.size);
	}
	
	public void findData(String s){
		if(counter==0){
			head = new Node(s);
			tail = head;
			map.put(s, head);
			counter++;
			return;
		}
		
		Node node = map.get(s);
		if(node==null){
			if(counter==this.size){
				String str = head.data;
				head = head.next;
				map.remove(str);
			}else{
				counter++;
			}
		}else{
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node = null;
		}
		Node newNode = new Node(s);
		newNode.prev = tail.prev;
		tail = newNode;
		map.put(s, newNode);
		
	}
}

class Node{
	String data;
	Node prev;
	Node next;
	
	public Node(String data){
		this.data = data;
	}
}
package linkedlist;

public class LinkedListUtilities {
	
	public static Node createTestList(){
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		return node;
	}
	
	public static void travereList(Node node){
		if(node == null){
			return;
		}
		System.out.print(node.data+ " ");
		travereList(node.next);
	}
	
	public static Node reverseList(Node node){
		if(node==null){
			return null;
		}
		if(node.next == null){
			return node;
		}
		Node rList = reverseList(node.next);
		rList.next = node;
		node.next = null;
		return node;
	}
	
	public static void main(String[] args){
		Node node = createTestList();
		System.out.println("Traverse List:");
		travereList(node);
		System.out.println("\nReverse List:");
		Node node1 = reverseList(node);
		travereList(node1);
	}
	

}

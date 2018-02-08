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
		node.next.next = node;
		node.next = null;
		return rList;
	}
	
	public static int length(Node node){
		if(node == null){
			return 0;
		}
		return 1+length(node.next);
	}
	
	public static boolean checkIfLoop(Node node){
		if(node == null){
			return false;
		}
		Node temp = node;
		while(true){
			node = node.next;
			temp = temp.next;
			if(temp!=null){
				temp = temp.next;
			}else{
				return false;
			}
			if(node == temp){
				return true;
			}
		}
	}
	
	public static Node appendList(Node node1, Node node2){
		if(node1 == null){
			return node2;
		}
		if(node2 == null){
			return node1;
		}
		
		Node node3 = node1;
		
		while(node1.next!=null){
			node1 = node1.next;
			
		}
		node1.next = node2;
		return node3;
	}
	
	public static void main(String[] args){
		Node node = createTestList();
		System.out.println("Traverse List:");
		travereList(node);
		System.out.println("\nlength : "+length(node));
		System.out.println("Reverse List:");
		Node node1 = reverseList(node);
		travereList(node1);
		System.out.println(checkIfLoop(node));
		
		Node node2 = createTestList();
		node = appendList(node1, node2);
		System.out.println("Traverse List:");
		travereList(node);
		
	}
	
	
	

}

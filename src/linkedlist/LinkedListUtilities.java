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
	
	
	public static Node createTestList2(){
		Node node = new Node(9);
		node.next = new Node(8);
		node.next.next = new Node(7);
		node.next.next.next = new Node(6);
		node.next.next.next.next = new Node(5);
		return node;
	}
	
	public static Node createTestList3(){
		Node node = new Node(9);
		node.next = new Node(8);
		node.next.next = new Node(7);
		node.next.next.next = new Node(6);
		return node;
	}
	
	public static Node createList(Node start, int data){
		if(start==null){
			start = new Node(data);
			return start;
		}
		Node temp = start;
		while(temp.next != null){
			temp = temp.next;
		}
		temp.next = new Node(data);
		return start;
	}
	
	public static Node createLinkedList(int[] arr){
		Node start = null;
		Node node = null;
		for(int i=0; i<arr.length;i++){
			if(start == null){
				start = new Node(arr[i]);
				node = start;
			}else{
				node.next = new Node(arr[i]);
				node = node.next;
			}
		}
		return start;
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
		
		Node node3 = null;
		Node start = null;
		
		while(node1!=null){
			Node temp = new Node(node1.data);
			if(start==null){
				start = temp;
			}else{
				node3.next = temp;
			}
			node3 = temp;
			node1 = node1.next;
		}
		
		while(node2!=null){
			Node temp = new Node(node2.data);
			node3.next = temp;
			node3 = temp;
			node2 = node2.next;
		}
		return start;
	}
	
	
	
	public static Node addLists(Node node1, Node node2){
		node1= reverseList(node1);
		node2= reverseList(node2);
		int carry = 0;
		Node node3 = null;
		Node start = null;
		while(node1!=null && node2!=null){
			int num = node1.data + node2.data + carry;
			Node temp = new Node(num%10);
			if(start==null){
				start = temp;
			}else{
				node3.next = temp;
			}
			node3 = temp;
			carry = num/10;
			node1 = node1.next;
			node2 = node2.next;
		}
		
		if(node1==null){
			while(node2!=null){
				int num = node2.data + carry;
				Node temp = new Node(num%10);
				node3.next = temp;
				node3 = temp;
				carry = num/10;
				node2 = node2.next;
			}
		}else{
			while(node1!=null){
				int num = node1.data + carry;
				Node temp = new Node(num%10);
				node3.next = temp;
				node3 = temp;
				carry = num/10;
				node1 = node1.next;
			}
		}
		if(carry==1){
			node3.next = new Node(carry);
		}
		return reverseList(start);
	}
	
	public static Node addListsUsingRecursion(Node node1, Node node2){
		if(node1.next==null && node2.next ==null){
			int num = node1.data + node2.data;
			return new Node(num);
		}
		Node node = addListsUsingRecursion(node1.next, node2.next);
		int num = node.data;
		node.data = num%10;
		int carry = num/10;
		Node newNode = new Node(node1.data+node2.data+carry);
		newNode.next = node;
		return newNode;
	}
	
	public static Node addListsUsingRecursionUtility(Node node1, Node node2){
		Node node = addListsUsingRecursion(node1, node2);
		if(node!=null){
			int num = node.data;
			node.data = num%10;
			int carry = num/10;
			if(carry>0){
				Node newNode = new Node(carry);
				newNode.next = node;
				return newNode;
			}
		}
		return node;
	}
	
	public static Node addListForDifferentLengthUsingRecursionUtility(Node node1, Node node2){
		int l1 = length(node1);
		int l2 = length(node2);
		
		int diff = l1 - l2;
		
		if(diff==0){
			return addListsUsingRecursionUtility(node1, node2);
		}else if(diff>0){
			return addListForDifferentLengthUsingRecursion(node1, node2, diff);
		}else{
			return addListForDifferentLengthUsingRecursion(node2, node1, diff);
		}
		
	}
	
	public static Node addListForDifferentLengthUsingRecursion(Node node1, Node node2, int diff){
		if(diff==0){
			return addListsUsingRecursion(node1, node2);
		}
		Node node = addListForDifferentLengthUsingRecursion(node1.next, node2, diff-1);
		if(node!=null){
			int num = node.data;
			node.data = num%10;
			int carry = num/10;
			Node newNode = new Node(node1.data+carry);
			newNode.next = node;
			return newNode;
		}
		return node;
	}
	
	public static Node multiplyList(Node node1, Node node2){
		node1 = reverseList(node1);
		node2 = reverseList(node2);
		Node start2 = node2;
		Node start = null;
		Node start1 = null;
		Node node3 = null;
		Node node4 = null;
		while(node1!=null){
			int carry = 0;
			node2 = start2;
			while(node2!=null){
				int num = node1.data * node2.data + carry;
				if(start == null){
					
					start = new Node(num);
					start1 = start;
					node3 = start;
				}else{
					if(node3.next==null && node4==null){
						carry = num/10;
						num = num%10;
						Node temp = new Node(num);
						node3.next = temp;
					}else{
						num += node3.data;
						carry = num/10;
						num = num%10;
						node3.data = num;
					}
					node3 = node3.next;
					if(node4!=null){
						node4 = node4.next;
					}
				}
				
				node2 = node2.next;
			}
			node1 = node1.next;
			if(carry!=0){
				node3.next = new Node(carry);
				carry = 0;
			}
			start1 = start.next;
			node3 = start1;
			node4 = node3;
		}
		return reverseList(start);
		
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
		Node node3 = appendList(node1, node2);
		Node node4 = appendList(node1, node2);
		System.out.println("Appended Traverse List:");
		travereList(node3);
		
		Node node5 = addLists(node4, node3);
		System.out.println("\nAdding Traverse List:");
		travereList(node5);
		
		
		Node node6 = createTestList();
		Node node7 = createTestList2();
		Node node8 = addListsUsingRecursionUtility(node6, node7);
		
		System.out.println("\nAdding Recursion Traverse List:");
		travereList(node8);
		
		
		Node node9 = createTestList();
		Node node10 = createTestList3();
		Node node11 = addListForDifferentLengthUsingRecursionUtility(node9, node10);
		
		System.out.println("\nAdding Different Recursion Traverse List:");
		travereList(node11);
		
	}
	
	
	

}

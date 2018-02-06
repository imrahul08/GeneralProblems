package tree;

public class Utilities {

	public static void main(String[] args) {
		Node node = new Node(4);
		node.left = new Node(2);
		node.left.left = new Node(1);
		node.left.right = new Node(3);
		node.right = new Node(10);
		node.right.left = new Node(8);
		node.right.right = new Node(12);
		node.right.left.left = new Node(9);
		node.right.left.right = new Node(7);
		
		
		System.out.println("inorder traversal");
		inorder(node);
		
		System.out.println("\npreorder traversal");
		preorder(node);
		
		System.out.println("\npostorder traversal");
		postorder(node);
		
		System.out.println("\nHeight of tree: " + height(node));
		
		System.out.println("\nis BST: "+checkIfBST(node));

		
	}
	
	public static void inorder(Node root){
		if(root==null){
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	
	public static void preorder(Node root){
		if(root==null){
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(Node root){
		if(root==null){
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static int height(Node root){
		if(root==null){
			return 0;
		}else{
			return Math.max(height(root.left), height(root.right))+1;
		}
	}
	
	public static boolean checkIfBST(Node root){
		return checkIfBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkIfBSTUtil(Node node, int min, int max){
		if(node == null){
			return true;
		}
		if(node.data>max || node.data<min){
			return false;
		}
		return checkIfBSTUtil(node.left, min, node.data) && checkIfBSTUtil(node.right, node.data, max);
	}
	

}

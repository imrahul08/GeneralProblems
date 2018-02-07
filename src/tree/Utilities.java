package tree;

public class Utilities {

	public static void main(String[] args) {
		
		Tree node = createTestTree();
		
		System.out.println("inorder traversal");
		inorder(node);
		
		System.out.println("\npreorder traversal");
		preorder(node);
		
		System.out.println("\npostorder traversal");
		postorder(node);
		
		System.out.println("\nHeight of tree: " + height(node));
		
		System.out.println("\nis BST: "+checkIfBST(node));

		
	}
	
	public static Tree createTestTree(){
		Tree node = new Tree(4);
		node.left = new Tree(2);
		node.left.left = new Tree(1);
		node.left.right = new Tree(3);
		node.right = new Tree(10);
		node.right.left = new Tree(8);
		node.right.right = new Tree(12);
		node.right.left.left = new Tree(7);
		node.right.left.right = new Tree(9);
		return node;
	}
	public static void inorder(Tree root){
		if(root==null){
			return;
		}
		inorder(root.left);
		System.out.print(root.data + " ");
		inorder(root.right);
	}
	
	
	public static void preorder(Tree root){
		if(root==null){
			return;
		}
		System.out.print(root.data + " ");
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void postorder(Tree root){
		if(root==null){
			return;
		}
		postorder(root.left);
		postorder(root.right);
		System.out.print(root.data + " ");
	}
	
	public static int height(Tree root){
		if(root==null){
			return 0;
		}else{
			return Math.max(height(root.left), height(root.right))+1;
		}
	}
	
	public static boolean checkIfBST(Tree root){
		return checkIfBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	
	public static boolean checkIfBSTUtil(Tree node, int min, int max){
		if(node == null){
			return true;
		}
		if(node.data>max || node.data<min){
			return false;
		}
		return checkIfBSTUtil(node.left, min, node.data) && checkIfBSTUtil(node.right, node.data, max);
	}
	

}

package tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import queue.Queue;

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
	
	public static void levelOrder(Tree root){
		if(root==null){
			return;
		}
		Queue<Tree> queue = new Queue<>();
		queue.enqueue(root);
		System.out.println("Label order traversal:");
		int len = 1;
		while(!queue.isEmpty()){
			int counter = 0;
			for(int i=0;i<len;i++){
				Tree node = queue.dequeue();
				System.out.print(node.data+" ");
				if(node.left!=null){
					queue.enqueue(node.left);
					counter++;
				}
				if(node.right!=null){
					queue.enqueue(node.right);
					counter++;
				}
			}
			System.out.println();
			len = counter;
		}
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
	
	public static boolean checkIfElementExists(Tree node, int data){
		if(node==null){
			return false;
		}
		if(node.data == data){
			return true;
		}
		return checkIfElementExists(node.left, data) || checkIfElementExists(node.right, data);
	}
	
	public static List<Integer> pathFromRootToNode(Tree node, int data, List<Integer> list){
		if(node==null){
			return null;
		}
		if(node.data == data){
			list.add(data);
			return list;
		}
		list = new ArrayList<>(list);
		list.add(node.data);
		List<Integer> list1 = pathFromRootToNode(node.left, data, list);
		List<Integer> list2 = pathFromRootToNode(node.right, data, list);
		if(list1!=null && list1.size()>0 && list1.get((list1.size()-1)) == data){
			return list1;
		}
		if(list2!=null && list2.size()>0 && list2.get((list2.size()-1)) == data){
			return list2;
		}
		return new ArrayList<>();
		
	}
	

}

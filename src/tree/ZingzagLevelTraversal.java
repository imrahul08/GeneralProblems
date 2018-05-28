package tree;

import stack.Stack;

public class ZingzagLevelTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree node = Utilities.createTestTree();
		zigzagTraversal(node);
	}
	
	public static void zigzagTraversal(Tree node){
		if(node == null){
			return;
		}
		Stack<Tree> s1 = new Stack<>();
		Stack<Tree> s2 = new Stack<>();
		s1.push(node);
		while(!(s1.isEmpty() && s2.isEmpty())){
			while(!s1.isEmpty()){
				node = s1.pop();
				System.out.println(node.data);
				if(node.left!=null){
					s2.push(node.left);
				}
				if(node.right!=null){
					s2.push(node.right);
				}
			}
			
			while(!s2.isEmpty()){
				node = s2.pop();
				System.out.println(node.data);
				if(node.right!=null){
					s1.push(node.right);
				}
				if(node.left!=null){
					s1.push(node.left);
				}
			}
				
		}
		
	}

}

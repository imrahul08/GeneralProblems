package tree;

import java.util.Set;
import java.util.TreeMap;

import queue.Queue;


public class TreeViews {
	public static void main(String[] args){
		Tree node = Utilities.createTestTree();
		
		printBottomView(node);
	}
	
	public static void  printBottomView(Tree root){
		Queue<Tree> queue = new Queue<>();
		TreeMap<Integer, Tree> map = new TreeMap<>();
		if(root==null){
			return;
		}
		int hd = 0;
		map.put(hd, root);
		queue.enqueue(root);
		while(!queue.isEmpty()){
			Tree node = queue.dequeue();
			if(node.left!=null)
				map.put(hd-1, node.left);
			if(node.right!=null)
				map.put(hd+1, node.right);
			queue.enqueue(node.left);
			queue.enqueue(node.right);
		}
		Set<Integer> set = map.keySet();
		for(Integer i:set){
			System.out.println(map.get(i).data);
		}
		return;
		
	}
	
}





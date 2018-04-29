package tree;

import java.util.TreeMap;

import queue.Queue;

public class TreeViews {
	public static void main(String[] args){
		Tree node = Utilities.createTestTree();
	}
	
	public static void printBottomView(Tree root){
		Queue<Tree> queue = new Queue<>(10);
		queue.enqueue(root);
		TreeMap<Integer, Tree> map = new TreeMap<>();
		map.put(0, root);
		while(!queue.isEmpty()){
			Tree t = queue.dequeue();
			if(t.left != null){
				//map.put(t.data, value)
			}
		}
		
	}
}





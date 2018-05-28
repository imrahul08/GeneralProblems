package tree;

public class LevelTraversal {

	public static void main(String[] args) {
		Tree node = Utilities.createTestTree();
		int height = Utilities.height(node);
		System.out.println("Label Traversal");
		for(int i=0;i<height;i++){
			levelTraversal(node, i);
		}
	}
	
	public static void levelTraversal(Tree node, int d){
		if(node == null){
			return;
		}
		if(d==0){
			System.out.println(node.data);
		}else{
			levelTraversal(node.left, d-1);
			levelTraversal(node.right, d-1);
			
		}
	}

}

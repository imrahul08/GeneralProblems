package tree;

public class LabelTraversal {

	public static void main(String[] args) {
		Tree node = Utilities.createTestTree();
		int height = Utilities.height(node);
		System.out.println("Label Traversal");
		for(int i=0;i<height;i++){
			labelTraversal(node, i);
		}
	}
	
	public static void labelTraversal(Tree node, int d){
		if(node == null){
			return;
		}
		if(d==0){
			System.out.println(node.data);
		}else{
			labelTraversal(node.left, d-1);
			labelTraversal(node.right, d-1);
			
		}
	}

}

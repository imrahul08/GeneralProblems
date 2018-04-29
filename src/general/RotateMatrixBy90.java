package general;

import crackingcode.Utilities;

public class RotateMatrixBy90 {
	public static void main(String[] args){
		int[][] mat = Utilities.create4By4Matrix();
		Utilities.displayMatrix(mat);
		rotate(mat);
		Utilities.displayMatrix(mat);
	}
	
	public static void rotate(int[][] arr){
		int left = 0;
		int right = arr[0].length - 1;
		int top = 0;
		int bottom = arr.length - 1;
		int k =(int) Math.ceil(arr.length/2.0);
		System.out.println("value of k "+k);
		
		for(int j =0;j<k;j++){
			int i = 0;
		
			for(i=0;i<(right-left);i++){
				int temp = arr[top][left+i];
				arr[top][left+i] = arr[bottom-i][left];
				arr[bottom-i][left] = arr[bottom][right-i];
				arr[bottom][right-i] = arr[top+i][right];
				arr[top+i][right] = temp;
			}
			left++;
			right--;
			top++;
			bottom--;
		}
	}
}

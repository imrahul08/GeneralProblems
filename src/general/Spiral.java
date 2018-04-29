package general;

import crackingcode.Utilities;

public class Spiral {
	public static void main(String[] args){
		int[][] mat = Utilities.create3By3Matrix();
		Utilities.displayMatrix(mat);
		spiral(mat);
	}
	
	public static void spiral(int[][] arr){
		int left = 0;
		int right = arr[0].length - 1;
		int top = 0;
		int bottom = arr.length - 1;
		int k =(int) Math.ceil(arr.length/2.0);
		System.out.println("value of k "+k);
		
		for(int j =0;j<k;j++){
			int i = 0;
			if(left == right){
				System.out.println(arr[top][left]);
				break;
			}
			for(i=left;i<right;i++){
				System.out.println(arr[top][i]);
			}
			for(i=top;i<bottom;i++){
				System.out.println(arr[i][right]);
			}
			for(i=right;i>left;i--){
				System.out.println(arr[bottom][i]);
			}
			for(i=bottom;i>top;i--){
				System.out.println(arr[i][left]);
			}
			left++;
			right--;
			top++;
			bottom--;
			
		}
		
		
	}
}

package crackingcode;

public class Utilities {
	
	public static void displayMatrix(int[][] arr){
		if(arr==null){
			return;
		}
		for(int i=0;i<arr.length;i++){
			for(int j=0;j<arr[0].length;j++){
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static int[][] create4By4Matrix(){
		int[][] arr = {{1,2,3,4},{5,6,7,8},{9,10,11,12},{13,14,15,16}};
		return arr;
	}
	
	public static int[][] create3By3Matrix(){
		int[][] arr = {{1,2,3},{4,5,6},{7,8,9}};
		return arr;
	}
	
	public static int[][] create2By2Matrix(){
		int[][] arr = {{1,2},{3,4}};
		return arr;
	}
	
	public static int max(int a, int b){
		return a>b ?a :b;
	}
	
	public static int maxIndex(int[]arr, int i, int j){
		return arr[i]>=arr[j] ?i :j;
	}
	
	public static int minIndex(int[]arr, int i, int j){
		return arr[i]<=arr[j] ?i :j;
	}

}

package dp;

import crackingcode.Utilities;

public class LCS {
	
	public static void main(String[] args){
		String s1 = "rahul";
		String s2 = "atul";
		int[][] arr = getLCSMatrix(s1, s2);
		Utilities.displayMatrix(arr);
		printLCSString(arr, s1, s2);
	}
	
	public static int[][] getLCSMatrix(String s1, String s2){
		int[][] arr = new int[s1.length()+1][s2.length()+1];
		for(int i=1;i<=s1.length();i++){
			for(int j=1;j<=s2.length();j++){
				if(s1.charAt(i-1)==s2.charAt(j-1)){
					arr[i][j] = arr[i-1][j-1] + 1;
				}else{
					 arr[i][j] = Utilities.max(arr[i-1][j], arr[i][j-1]);
				}
			}
		}
		return arr;
	}
	
	public static void printLCSString(int[][] arr, String s1, String s2){
		int k = 0;
		System.out.println();
		for(int i=1;i<s1.length()+1;i++){
			for(int j=0;j<s2.length()+1;j++)
			if(arr[i][j]-1==k){
				System.out.print(s2.charAt(j-1));
				k++;
				continue;
			}
		}
	}
	
}

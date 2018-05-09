package sort;

public class SortUtiities {
	public static int[] createArray(){
		int[] arr = {4,10,7,9,5,1,6,3,8,2};
		return arr;
	}
	
	public static void display(int[] arr){
		for(int i=0;i<arr.length;i++){
			System.out.print(arr[i]+" ");
		}
		System.out.println();
	}
	
	public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2){
		int[] mergedArray = new int[arr1.length+arr2.length];
		int i=0;
		int j=0;
		int k=0;
		while(i<mergedArray.length){
			while(j<arr1.length && (k==arr2.length ||arr1[j]<arr2[k])){
				mergedArray[i++] = arr1[j++];
			}
			while(k<arr2.length && (j==arr1.length || arr1[j]>arr2[k])){
				mergedArray[i++] = arr2[k++];
			}
		}
		return mergedArray;
	}
	
	public static void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
}

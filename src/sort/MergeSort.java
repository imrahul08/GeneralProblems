package sort;

public class MergeSort {

	public static void main(String[] args){
		int[] arr = SortUtiities.createArray();
		SortUtiities.display(arr);
		mergeSort(arr, 0, arr.length-1);
		//int[] arr1 = {1,3,5,7,9};
		//int[] arr2 = {2,4,6,8,10,11};
		SortUtiities.display(arr);
	}
	
	public static void mergeSort(int[] arr, int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			mergeSort(arr, low, mid);
			mergeSort(arr, mid+1, high);
			mergeArray(arr, low, mid, high);
		}
		
	}
	
	
	public static void mergeArray(int[] arr, int low, int mid, int high){
		int[] arr1 = new int[mid-low+1];
		int[] arr2 = new int[high-mid];
		for(int i=0;i<arr1.length;i++){
			arr1[i] = arr[low+i];
		}
		for(int i=0;i<arr2.length;i++){
			arr2[i] = arr[mid+i+1];
		}
		//int[] mergedArray = new int[arr1.length+arr2.length];
		int i=low;
		int j=0;
		int k=0;
		while(j<arr1.length && k<arr2.length){
			if(arr1[j]<arr2[k]){
				arr[i++] = arr1[j++];
			}
			else{
				arr[i++] = arr2[k++];
			}
		}
		
		if(j==arr1.length){
			while(k<arr2.length){
				arr[i++] = arr2[k++];
			}
		}
		if(k==arr2.length){
			while(j<arr1.length){
				arr[i++] = arr1[j++];
			}
		}
	}
}

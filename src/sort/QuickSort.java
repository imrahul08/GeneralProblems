package sort;

public class QuickSort {

	public static void main(String[] args){
		int[] arr = SortUtiities.createArray();
		SortUtiities.display(arr);
		quickSort(arr, 0, arr.length-1);
		//int[] arr1 = {1,3,5,7,9};
		//int[] arr2 = {2,4,6,8,10,11};
		SortUtiities.display(arr);
	}
	
	public static void quickSort(int[] arr, int low, int high){
		if(low<high){
			int pivot = partition(arr, low, high);
			quickSort(arr, low, pivot-1);
			quickSort(arr, pivot+1, high);
		}
		
	}
	
	
	public static int partition(int[] arr, int low, int high){
		int pivot = arr[high];
		int i = low-1;
		for(int k=low;k<high;k++){
			if(arr[k]<pivot){
				i++;
				SortUtiities.swap(arr, i, k);
			}
		}
		SortUtiities.swap(arr, high, i+1);
		return i+1;
	}
}

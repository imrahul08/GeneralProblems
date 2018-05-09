package sort;

public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = SortUtiities.createArray();
		SortUtiities.display(arr);
		selectionSort(arr);
		SortUtiities.display(arr);
	}
	
	public static void selectionSort(int[] arr){
		for(int i=0;i<arr.length;i++){
			int k = i;
			for(int j=i+1;j<arr.length;j++){
				if(arr[j]<arr[k]){
					k=j;
				}
			}
			if(arr[k]<arr[i]){
				int temp = arr[k];
				arr[k] = arr[i];
				arr[i] = temp;
			}
		}
	}
	

}

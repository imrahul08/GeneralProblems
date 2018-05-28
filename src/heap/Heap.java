package heap;

import crackingcode.Utilities;
import sort.SortUtiities;

public class Heap {
	private int size;
	private int[] arr;
	private int index = -1;
	
	public Heap(){
		this(10);
	}
	
	public Heap(int size){
		this.size = size;
		arr = new int[this.size];
	}
	
	public boolean isEmpty(){
		return index==-1?true:false;
	}
	
	public String toString(){
		StringBuffer sb = new StringBuffer();
		for(int i=0;i<=index; i++){
			sb.append(arr[i] + " ");
		}
		return sb.toString();
	}
	
	public void insert(int data){
		if(index==this.size-1){
			throw new RuntimeException("No enough storage available");
		}
		arr[++index] = data;
		heapify(index);
		
	}
	
	public int remove(){
		if(index==-1){
			throw new RuntimeException("No data available");
		}
		int data = arr[0];
		arr[0] = arr[index];
		arr[index--] = 0;
		heapify();
		return data;
	}
	
	public void heapify(int index){
		int temp = index;
		while(temp!=0){
			int num = temp/2;
			if(temp%2==0){
				num--;
			}
			if(arr[temp] <arr[num]){
				SortUtiities.swap(arr, num,temp);
			}
			temp = num;
		}
	}
	
	
	public void heapify(){
		int temp = 0;
		
		while(temp<index){
			int index1 = 2*temp + 1;
			int index2 = 2*temp + 2;
			if(index<index1){
				break;
			}
			if(index>=index2){
				int minIndex = Utilities.minIndex(arr, index1, index2);
				int min = Utilities.minIndex(arr, temp, minIndex);
				if(min!=temp){
					SortUtiities.swap(arr, min, temp);
				}
				temp = minIndex;
			}
			else if(index>=index1){
				int min = Utilities.minIndex(arr, temp, index1);
				if(min!=temp){
					SortUtiities.swap(arr, min, temp);
				}
				temp = index1;
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = {4,5,3,2,7,6};
		Heap heap = new Heap();
		for(int i=0;i<arr.length;i++){
			heap.insert(arr[i]);
			System.out.println(heap);
		}
		
		for(int i=0;i<arr.length;i++){
			System.out.println(heap.remove());
			System.out.println(heap);
		}
	}
	
}

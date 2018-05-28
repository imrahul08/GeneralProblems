package general;

public class RemovingNumberForNonDecreasing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {2,5,4,4};
		System.out.println(checkForSolutions(arr));

	}
	
	public static int checkForSolutions(int[] arr){
		if(arr==null){
			return 0;
		}
		if( arr.length==1){
			return 1;
		}
		
		int count = 0;
		for(int i=1;i<arr.length;i++){
			if(arr[i]<arr[i-1]){
				count++;
			}
		}
		if(count>1){
			return 0;
		}else{
			return arr.length-count;
		}
		
	}

}

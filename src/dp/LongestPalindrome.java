package dp;

public class LongestPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(longestPalindrome("geeksskeeg"));
		System.out.println(longestPalindrome("nitin"));
	}
	
	public static String longestPalindrome(String str){
		int maxLength = 1;
		int start=0;
		
		//for even length
		for(int i=1;i<str.length();i++){
			int low=i-1;
			int high=i;
			int localMaxLength = 0;
			while(low>=0 && high<=str.length()-1 && str.charAt(low) == str.charAt(high)){
				localMaxLength+=2;
				
				if(localMaxLength>maxLength){
					start = low;
					maxLength = localMaxLength;
				}
				low--;
				high++;
			}
		}
		
		//for odd length
		for(int i=0;i<str.length();i++){
			int centerPoint=i;
			int j=1;
			int localMaxLength = 1;
			while(centerPoint-j>=0 && centerPoint+j<str.length() && str.charAt(centerPoint-j) == str.charAt(centerPoint+j)){
				localMaxLength+=2;
				
				if(localMaxLength>maxLength){
					start = centerPoint-j;
					maxLength = localMaxLength;
				}
				j++;
			}
		}
		return str.substring(start, start+maxLength);
	}

}

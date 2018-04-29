package pattern;

public class PatternSearch {
	public static void main(String[] args){
		naiveApproach("ABCDEFGABABC", "ABC");
	}
	
	public static void naiveApproach(String str, String pattern){
		if(str == null || pattern== null){
			return;
		}
		int strlen = str.length();
		int plen = pattern.length();
		
		if(plen>strlen){
			return;
		}
		
		for(int i=0; i<strlen;i++){
			int j=0;
			for(j=0;j<plen;j++){
				if(str.charAt(i+j)!=pattern.charAt(j)){
					break;
				}
			}
			if(j==plen){
				System.out.println(i);
			}
		}
	}
	
	public static void kmpAlgorithm(){
		
	}
}

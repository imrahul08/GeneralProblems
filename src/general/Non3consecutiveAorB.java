package general;

public class Non3consecutiveAorB {

	public static void main(String[] args) {
		System.out.println(non3consecutiveAorB(3,1));
		System.out.println(non3consecutiveAorB(10,8));
		System.out.println(non3consecutiveAorB(6,8));
		System.out.println(non3consecutiveAorB(8,8));

	}
	
	public static String non3consecutiveAorB(int a, int b){
		if(a/2.0>b+1 || b/2.0>a+1){
			return "";
		}
		String ans = "";
		while(a>0 || b>0){
			if(a>b){
				if(a>2){
					ans+="aa";
					a-=2;
				}else if(a>0){
					ans+="a";
					a--;
				}
				if(b>0){
					ans+="b";
					b--;
				}
			}else if(b>a){
				if(b>2){
					ans+="bb";
					b-=2;
				}else if(b>0){
					ans+="b";
					b--;
				}
				if(a>0){
					ans+="a";
					a--;
				}
			}else{
				if(ans.length()>0){
					if(ans.charAt(ans.length()-1)=='a'){
						ans+="b";
						ans+="a";
					}else{
						ans+="a";
						ans+="b";
					}
				}else{
					ans+="b";
					ans+="a";
				}
				b--;
				a--;
			}
			
		}
		
		return ans;
	}

}

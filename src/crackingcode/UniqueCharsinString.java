package crackingcode;

public class UniqueCharsinString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkIfUnique("rahul"));
		System.out.println(checkIfUnique("rahulmittal"));
		

	}
	
	public static boolean checkIfUnique(String str){
		if(str == null || str.length() <2){
			return true;
		}
		boolean[] flags = new boolean[256];
		for(int i=0;i<str.length();i++){
			if(flags[str.charAt(i)]){
				return false;
			}else{
				flags[str.charAt(i)] = true;
			}
		}
		return true;
	}

}

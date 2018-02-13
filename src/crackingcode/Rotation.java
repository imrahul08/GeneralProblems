package crackingcode;

public class Rotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(checkIfRotation("rahul", "hulra"));
		System.out.println(checkIfRotation("rahul", "hular"));
	}

	public static boolean checkIfRotation(String s1, String s2){
		if(s1==null || s2==null){
			return false;
		}
		if(s1.length() != s2.length()){
			return false;
		}
		String s = s1+s1;
		if(s.contains(s2))
			return true;
		return false;
	}
}

package dictionary;

public class HashMapTest {

	public static void main(String[] args) {
		HashMap<Integer, String> hashMap = new HashMap<>();
		System.out.println(hashMap.put(1, "rahul"));
		System.out.println(hashMap.get(1));
		System.out.println(hashMap.put(2, "rahul1"));
		System.out.println(hashMap.get(2));
		System.out.println(hashMap.put(3, "rahul3"));
		System.out.println(hashMap.get(3));
		System.out.println(hashMap.put(3, "rahul4"));
		System.out.println(hashMap.get(3));
	}

}

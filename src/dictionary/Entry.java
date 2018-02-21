package dictionary;

public class Entry<K, V> {
	private K key;
	private V value;
	protected Entry<K, V> next;
	protected Entry<K, V> previous;
	
	public Entry(K key, V value){
		this.key = key;
		this.value = value;
	}

	public V getValue() {
		return value;
	}

	public Entry<K, V> getNext() {
		return next;
	}

	public void setNext(Entry<K, V> next) {
		this.next = next;
	}

	public Entry<K, V> getPrevious() {
		return previous;
	}

	public void setPrevious(Entry<K, V> previous) {
		this.previous = previous;
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
}

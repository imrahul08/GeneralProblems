package dictionary;

public class LinkedEntry<K, V> extends Entry<K, V> {
	protected LinkedEntry<K, V> nextInsert;
	protected LinkedEntry<K, V> previousInsert;
	
	public LinkedEntry(K key, V value){
		super(key, value);
	}

	public LinkedEntry<K, V> getNextInsert() {
		return nextInsert;
	}

	public void setNextInsert(LinkedEntry<K, V> nextInsert) {
		this.nextInsert = nextInsert;
	}

	public LinkedEntry<K, V> getPreviousInsert() {
		return previousInsert;
	}

	public void setPreviousInsert(LinkedEntry<K, V> previousInsert) {
		this.previousInsert = previousInsert;
	}
	
}

package dictionary;

public class HashMap<K, V> {
	
	private Entry<K, V>[] entries;
	private int size;
	
	private static final int INITIAL_SIZE = 16;
	
	public HashMap(){
		this(INITIAL_SIZE);
	}
	
	public HashMap(int size){
		this.size = size;
		entries = new Entry[size];
	}
	
	public V get(K key){
		if(key != null){
			int hashCode = hashCode(key);
			if(entries[hashCode] != null){
				Entry<K, V> start = entries[hashCode];
				while(start != null){
					if(start.getKey().equals(key)){
						return start.getValue();
					}
					start = start.getNext();
				}	
			}
		}
		return null;
	}
	
	public V put(K key, V value){
		if(key != null){
			int hashCode = hashCode(key);
			Entry<K, V> entry = new Entry<K, V>(key, value);
			if(entries[hashCode]==null){
				entries[hashCode] = entry;
			}else{
				Entry<K, V> start = entries[hashCode];
				while(start.getNext() != null){
					if(start.getKey().equals(key)){
						V val = start.getValue();
						start.setValue(value);
						return val;
					}
					start = start.getNext();
				}
				if(start.getKey().equals(key)){
					V val = start.getValue();
					start.setValue(value);
					return val;
				}
				start.setNext(entry);
				entry.setPrevious(start);
			}
		}
		return null;
	}
	
	public V remove(K key){
		if(key != null){
			int hashCode = hashCode(key);
			if(entries[hashCode] != null){
				Entry<K, V> start = entries[hashCode];
				while(start != null){
					if(start.getKey().equals(key)){
						V val = start.getValue();
						start.getPrevious().setNext(start.getNext());
						start.getNext().setPrevious(start.getPrevious());
						start = null;
						return val;
					}
					start = start.getNext();
				}	
			}
		}
		return null;
	}
	

	private int hashCode(K key){
		return key.hashCode()%size;
	}
	
}

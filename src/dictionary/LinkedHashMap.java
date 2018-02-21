package dictionary;

public class LinkedHashMap<K, V> {
	
	private LinkedEntry<K, V>[] entries;
	private int size;
	private LinkedEntry<K, V> head;
	private LinkedEntry<K, V> end;
	
	private static final int INITIAL_SIZE = 16;
	
	public LinkedHashMap(){
		this(INITIAL_SIZE);
	}
	
	public LinkedHashMap(int size){
		this.size = size;
		entries = new LinkedEntry[size];
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
			LinkedEntry<K, V> entry = new LinkedEntry<K, V>(key, value);
			V val = null;
			if(entries[hashCode]==null){
				entries[hashCode] = entry;
			}else{
				LinkedEntry<K, V> start = entries[hashCode];
				while(start.getNext() != null){
					if(start.getKey().equals(key)){
						val = start.getValue();
						start.setValue(value);
						break;
					}
					start = (LinkedEntry<K, V>)start.getNext();
				}
				if(start.getKey().equals(key)){
					val = start.getValue();
					start.setValue(value);
					return val;
				}
				start.setNext(entry);
				entry.setPrevious(start);
			}
			
			if(head==null){
				head = entry;
				end = entry;
			}else{
				end.setNextInsert(entry);
				entry.setPreviousInsert(end);
				end = entry;
			}
			return val;
		}
		return null;
	}
	
	public void printInsertionOrder(){
		LinkedEntry<K, V> start = head;
		while(start != null){
			System.out.println(start.getKey() + " " + start.getValue());
			start = start.getNextInsert();
		}
	}
	
	public V remove(K key){
		if(key != null){
			int hashCode = hashCode(key);
			if(entries[hashCode] != null){
				LinkedEntry<K, V> start = entries[hashCode];
				while(start != null){
					if(start.getKey().equals(key)){
						V val = start.getValue();
						start.getPrevious().setNext(start.getNext());
						start.getNext().setPrevious(start.getPrevious());
						start.getPreviousInsert().setNextInsert(start.getNextInsert());
						start.getNextInsert().setPreviousInsert(start.getPreviousInsert());
						start = null;
						return val;
					}
					start = (LinkedEntry<K, V>) start.getNext();
				}	
			}
		}
		return null;
	}
	

	private int hashCode(K key){
		return key.hashCode()%size;
	}
	
}

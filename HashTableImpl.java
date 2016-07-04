package assignment4;

public class HashTableImpl<K, V> implements HashTable<K, V> {
	
	private int tableSize = 1009;
	private LinkedList[] table;
	private int hashCode;
	
	public HashTableImpl() {
		table = new LinkedList[tableSize];
	}

	 public void put(K key, V value) {
		 hashCode = (key.hashCode() % tableSize);		 
		 if (hashCode < 0) {
			 hashCode += tableSize;
		 }
		 
		if (table[hashCode] == null)  {
			LinkedList list = new LinkedList();
			list.add(key, value);
			table[hashCode] = list;
		}
		
		else {
			table[hashCode].add(key, value);
		}
	 }
	
	 public V get(K key) {
		 V returnValue;
		 hashCode = (key.hashCode() % tableSize);
		 if (hashCode < 0) {
			 hashCode += tableSize;
		 }
		 
		if (table[hashCode] == null)  {
			LinkedList tempList = table[hashCode];
			returnValue = (V) tempList.get(key);
			return returnValue;
		}
				
		else {
			return (V) table[hashCode].get(key);
		} 
	 }
	 
	 public V remove(K key) {
		 V returnValue;
		 hashCode = (key.hashCode() % tableSize);
		 if (hashCode < 0) {
			 hashCode += tableSize;
		 }
		 
		if (table[hashCode] == null)  {
			LinkedList tempList = table[hashCode];
			returnValue = (V) tempList.delete(key);
			return returnValue;
		}
			
		else {
			return (V) table[hashCode].delete(key);
		} 
		 
		 
	 }
}

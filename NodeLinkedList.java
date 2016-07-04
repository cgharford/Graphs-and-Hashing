package assignment4;

public class NodeLinkedList<K, V> {

	public K key; 
	public V value;
	public NodeLinkedList<K, V> next; 

	public NodeLinkedList(K key, V value, NodeLinkedList<K, V> next) {
		this.key = key;
		this.value = value;
		this.next = next;
	}
	
	public K getKey() {
		return key;
	}
	
	public V getValue() {
		return value;
	}
	
	public NodeLinkedList<K, V> getNext() {
		return next;
	}
	
	public void setNext(NodeLinkedList<K, V> nextNode) {
		next = nextNode;
	}
}

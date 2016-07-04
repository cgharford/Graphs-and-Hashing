package assignment4;

public class LinkedList<K, V> {
	
   private NodeLinkedList<K, V> head;

   public LinkedList() {
      head = null;
   }
 
   public boolean isEmpty() {
      return head == null;
   }
 
   public void add(K key, V value) {
      head = new NodeLinkedList<K, V>(key, value, head);
   }
 
   public V delete(K key) {
	  V tmp;
      if(head == null)
    	  System.out.println("This is empty!");

      if( head.key.equals(key) ){
    	  tmp = head.value;
	      head = head.next;
	      return tmp;
      }

      NodeLinkedList<K, V> current  = head;
      NodeLinkedList<K, V> previous = null;

      while(current != null && !current.key.equals(key)) {
         previous = current;
         current = current.next;
      }

      if(current == null)
         System.out.println("cannot delete; can't find!");

      //delete cur node
      tmp = current.value;
      previous.next = current.next;
      return tmp;
   }
   
   public V get(K key) {
	      if(head == null)
	        // System.out.println("This is empty!");

	      if( head.key.equals(key)) {
	    	 V tmp = head.value;
	         return tmp;
	      }

	      NodeLinkedList<K, V> current  = head;
	      NodeLinkedList<K, V> previous = null;

	      while(current != null && !current.key.equals(key)) {
	         previous = current;
	         current = current.next;
	      }

	      if(current == null) {
	    	  //System.out.println("cannot get; can't find!");
	    	  return null;
	      }
	  

	      //delete cur node
	      return current.value;
	   }
}

package assignment4;

public class MyGraph extends Graph{
	
	private Node[] graph;							// Adjacency list
	private HashTable<String, Integer> table;
	private int currentSize;
	
	public MyGraph(int nodes) {
		table = new HashTableImpl<String, Integer>();
		graph = new Node[nodes];
		currentSize = 0;
	}
	
	 public void addNode(Node node) {
		 ((MyNode) node).setId(currentSize);
		 graph[node.getId()] = node; 
		 currentSize++;
		 table.put(node.getName(), node.getId());
		 ((MyNode) node).next = null;
	 }

	    /**
	     * TODO: Override this method w/ an implementation
	     * Adds an edge between the two provided nodes to the graph.
	     * PRE: The two nodes have already been added to the graph.
	     */
	  
	 	public void addEdge(Node node1, Node node2) {
			MyNode temp1 = (MyNode) graph[node1.getId()];
			MyNode temp2 = new MyNode(node2.getName());
			temp2.setId(node2.getId());
			temp2.setNext(temp1.next);
			temp1.next = (MyNode) temp2;
		}
	

	    /**
	     * TODO: Override this method w/ an implementation
	     * Returns a node based on its unique ID.
	     * This must be O(1) worst case!
	     */
	    public Node lookupNode(int id) {
	    	return graph[id];
	    }

	    /**
	     * TODO: Override this method w/ an implementation
	     * Returns a node based on its unique name.
	     */
	    public Node lookupNode(String name) {
	    	MyNode tempNode = new MyNode(name);
	    	if (table.get(name).equals(null)) {			//If node does not exist, return null
	    		return null;
	    	}
	    	int id = table.get(name);
	    	tempNode.setId(id);
	    	return tempNode;
	    }

	    /**
	     * TODO: Override this method w/ an implementation
	     * Determines if this graph has no cycles.
	     */
	    public boolean isAcyclic() {
	    	boolean isAcyclic = false;			// Initially assume that it's a cycle
	    	
	    	int[] indegrees = new int[currentSize];
	    	for (int k = 0; k < currentSize; k++) {
	    		indegrees[k] = 0;
	    	}
	    	
	    	for (int i = 0; i < currentSize; i++) {
	    		MyNode tmp = (MyNode) graph[i];
	    		while (!((tmp.next) == (null))) {
	    			indegrees[i] += 1;
	    			tmp = tmp.next;
	    		}
	    	}
	    	
	    	for (int k = 0; k < currentSize; k++) {
	    		if (indegrees[k] == 0) {
	    			isAcyclic = true;
	    			break;
	    		}
	    	}
	    	return isAcyclic;
	    }

	    /**
	     * TODO: Override this method w/ an implementation
	     * Performs a topological sort of this graph.
	     * PRE: There are no cycles in the graph.
	     *
	     * @return An array of node IDs, in sorted order
	     */
	    public int[] sort() {
	    	int[] indegrees = new int[currentSize];
	    	int[] sorted = new int[currentSize];
	    	for (int k = 0; k < currentSize; k++) {
	    		indegrees[k] = 0;
	    	}
	    	
	    	for (int i = 0; i < currentSize; i++) {
	    		MyNode tmp = (MyNode) graph[i];
	    		while (!((tmp.next) == (null))) {
	    			int id = tmp.next.getId();
	    			indegrees[id] += 1;
	    			tmp = tmp.next;
	    		}
	    	}
	    	for (int i = 0; i < currentSize; i++) {
		    	for (int k = 0; k < currentSize; k++) {
		    		MyNode tmp = (MyNode) graph[k];
		    		if (indegrees[k] == 0) {
		    			indegrees[k] = -1; //SYMBOLIZES THAT IT'S DONE
		    			sorted[i] = k;
		    			while (!((tmp.next) == (null))) {
		    				int id = tmp.next.getId();
			    			indegrees[id] -= 1;
			    			tmp = tmp.next;
			    		} break;
		    		}
		    	}
	    	}
	    	return sorted;
	    }
}

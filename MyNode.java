package assignment4;

public class MyNode implements Node{
	
	private String name;
	private int id;
	public MyNode next;

	public MyNode(String name) {
		this.name = name;
		next = null;
		id = 0;
	}
	
	public void setId(int ID) {
		id = ID;
	}
	
	 public String getName() {
		 return name;
	 }
	 
	 public int getId() {
	  	return id;
	 }
	 
	 public void setNext(MyNode n) {
		 next = n;
	 }
}

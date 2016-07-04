package assignment4;

public class myTester {
	public static void main(String[] args) {
		HashTable<Integer, String> students = HashTableFactory.create();
		
		students.put(7205, "Christy");
		System.out.println(students.get(7205));
		
		students.put(7304, "David");
		System.out.println(students.get(7304));
		
		students.put(453, "Brooke");
		System.out.println(students.get(453));
		System.out.println(students.get(7304));
		System.out.println(students.get(7304));

		System.out.println();
		
		System.out.println(students.remove(7304));
		//System.out.println(students.get(7304));
		
	}
}

import java.util.*;

public class Demo{

	public static void main(String args[]) {
		// Create an array list
		LinkedList<String> al = new LinkedList<String>();

		// add elements to the array list
		al.add("dog");
		al.add("bird");
		al.add("fish");
		al.add("cat");
		al.add("monkey");
		al.add("lizard");

		System.out.println("\nSolving using augmented for loop: ");

		for(String element:al){
			if(element.equals("cat")){
				break;
			}
			System.out.println(element + " ");
		}
	}
}

/* class Demo2{
	
		public static void main(String args[]) {
			// Create an array list
			LinkedList<String> al = new LinkedList<String>();

			// add elements to the array list
			al.add("dog");
			al.add("bird");
			al.add("fish");
			al.add("cat");
			al.add("monkey");
			al.add("lizard");

			// Use iterator to display contents of al
			System.out.print("Contents of al: ");
			Iterator<String> itr = al.iterator();

			while(itr.hasNext()) {
				String element = itr.next();
				System.out.print(element + " ");
			}
		}
	} */
				

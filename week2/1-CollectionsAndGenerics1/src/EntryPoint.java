import java.util.Arrays;
import java.util.LinkedList;

public class EntryPoint {

	public static void main(String[] args) {
		// PROBLEM 00
		
		
		
		
		// PROBLEM 01
		LinkedList list = new LinkedList(Arrays.asList(-28, 20, -12, 8));  
	      
		P02_ReverseGenericCollection test = new P02_ReverseGenericCollection();
		list = (LinkedList) test.reverseGenericCollection(list);
	  
		System.out.println(list);
	}
}

package preReading;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class CollectionsDemo {
	public static void main(String args[]) {  
	      // create linked list object  	   
	      LinkedList list = new LinkedList();  
	      
	      // populate the list 
	      list.add(-28);  
	      list.add(20);  
	      list.add(-12);  
	      list.add(8);  
	      
	      System.out.println(list); 

	      // reverse the list
	      Collections.reverse(list);  
			  
	      System.out.println(list);      
	   }
}

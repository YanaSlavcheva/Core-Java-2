import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class P02_ReverseGenericCollection {

	public <T> Collection<T> reverseGenericCollection(Collection<T> collection) {
		System.out.println(collection); 

	      // reverse the list
	      Collections.reverse((List<?>) collection);
			  
	      System.out.println(collection);
		
		return collection;
		
	}
}

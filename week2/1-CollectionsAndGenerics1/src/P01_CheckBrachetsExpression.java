import java.util.Scanner;

public class P01_CheckBrachetsExpression {
	public static void main(String[] args){
		final String INVALID_INPUT_MESSAGE = "The input string is invalid!";
		final String NOT_CORRECT_EXPRESSION_MESSAGE = "The expression is not correct!";
		
		// read input from Console
//		Scanner input = new Scanner(System.in);
//	    String bracketsString = input.nextLine();
	    
	    // hard coded input
		// I get the input as a string
		// because (according to multiple articles in SO)
		// iteration over str.charAt(i); is faster than
		// str.toCharArray();
	    String input = "()()())))((())()";
	    
	    int counter = 0;
	    
	    // initial fast checks
	    // if the brackets are even number
	    if	(input.length() % 2 == 0) {
	    	// initial fast checks
		    // if the last bracket is of correct type
	    	String lastChar = (input.substring(input.length() - 1));
    		
    		// if initial checks are o.k. then we iterate
	    	iterateCharArray(INVALID_INPUT_MESSAGE,
					NOT_CORRECT_EXPRESSION_MESSAGE, input, counter, lastChar);

	    } else {
	    	System.out.println(NOT_CORRECT_EXPRESSION_MESSAGE);
	    }    
	}

	private static void iterateCharArray(final String INVALID_INPUT_MESSAGE,
			final String NOT_CORRECT_EXPRESSION_MESSAGE, String input,
			int counter, String lastChar) {
		if (lastChar.equals(")")) {
			for (int i = 0, n = input.length(); i < n; i++) {
		        char c = input.charAt(i);
		        if (c == '(') {
		        	counter++;
		        } else if (c == ')') {
		        	counter--;
		        	if (counter < 0) {
			        	System.out.println(NOT_CORRECT_EXPRESSION_MESSAGE);
			        	break;
			        }
		        } else {
		        	System.out.println(INVALID_INPUT_MESSAGE);
		        	break;
		        }			      
		    }
			
		} else {
			System.out.println(NOT_CORRECT_EXPRESSION_MESSAGE);
		}
	}
}

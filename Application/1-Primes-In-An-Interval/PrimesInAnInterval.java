import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimesInAnInterval {
    public static void main(String[] args) {
        System.out.println("This program finds primes in given interval.");
        System.out.println("Enter value \"from\" and \"to\" on separate lines:");

        FindAndPrintPrimeNumbersFromInputInterval();
    }

    private static void FindAndPrintPrimeNumbersFromInputInterval() {
        try{
            List<Integer> result = ReadInputAndPutPrimesInList();
            System.out.println(result);
        } catch (NumberFormatException e) {
            System.out.println(e);
            System.out.println("You must enter integer numbers. Enter new values.");
            FindAndPrintPrimeNumbersFromInputInterval();
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            FindAndPrintPrimeNumbersFromInputInterval();
        }
    }

    private static List<Integer> ReadInputAndPutPrimesInList() {
        Scanner input = new Scanner(System.in);
        String fromString = input.nextLine();
        String toString = input.nextLine();

        int from = Integer.parseInt(fromString);
        int to = Integer.parseInt(toString);

        if (from >= to){
            throw new IllegalArgumentException("\"from\" must be smaller than \"to\". Enter new values.");
        }

        if (from < 0 || to < 0){
            throw new IllegalArgumentException("\"from\" and \"to\" must be positive numbers. Enter new values.");
        }

        List<Integer> allPrimes = new ArrayList<Integer>();
        for (int i = from; i <= to; i++) {
             if (isPrime(i)){
                allPrimes.add(i);
            }
        }

        return allPrimes;
    }

    public static boolean isPrime(int i){
            if (i <= 3) {
                return i > 1;
            } else if (i % 2 == 0 || i % 3 == 0) {
                return false;
            } else {
                double sqrtFromN = Math.floor(Math.sqrt(i));
                for (int j = 5; j <= sqrtFromN; j += 6) {
                    if (i % j == 0 || i % (j + 2) == 0) {
                        return false;
                    }
                }

                return true;
            }
        }
}
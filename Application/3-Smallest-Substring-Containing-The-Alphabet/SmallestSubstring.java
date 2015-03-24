import java.util.Scanner;

public class SmallestSubstring {

    public static void main(String[] args) {
        System.out.println("Enter string on the next line:");
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
////        String input = "aaaaaabcdefghijklMNOpqrstuvwxyyz";
//        String input = "abcdefghijklmn124345678!@#$%^&*opqrstuvwxyz!*abcdefghijklmn";

        String goal = "abcdefghijklmnopqrstuvwxyz";
        String inputToLower = input.toLowerCase();
        Integer maxLength = goal.length();

        String smallestString = findSmallestSubstringFromStartingIndex(goal, inputToLower, input, 0, maxLength);

        for (int startIndex = 1; startIndex < inputToLower.length() - goal.length(); startIndex++) {
            String tempResult = findSmallestSubstringFromStartingIndex(goal, inputToLower, input, startIndex, maxLength);

            if ((tempResult.length() < smallestString.length()) && (tempResult.length() >= maxLength)) {
                smallestString = tempResult;
            }
        }

        System.out.println(smallestString);
    }

    private static String findSmallestSubstringFromStartingIndex(String goal, String inputToLower, String input, Integer startPoint, Integer maxLength) {
        Integer startIndex = 0;
        Integer endIndex = 0;

        for (int i = startPoint; i < inputToLower.length(); i++) {
            char tempChar = inputToLower.charAt(i);
            if ((goal.indexOf(tempChar) != -1) && (goal.length() == maxLength)) {
                startIndex = i;
                goal = goal.replace(String.valueOf(tempChar), "");
            } else if ((goal.indexOf(tempChar) != -1) && (goal.length() == 1)){
                endIndex = i;
                goal = goal.replace(String.valueOf(tempChar), "");
            } else if ((inputToLower.charAt(i) == inputToLower.charAt(i - 1)) && (goal.length() == maxLength - 1)) {
                startIndex = i;
            } else if (goal.indexOf(tempChar) != -1) {
                goal = goal.replace(String.valueOf(tempChar), "");
            }
        }

        if (endIndex != 0){
            String smallestSubstring = input.substring(startIndex, (endIndex + 1));
            return smallestSubstring;
        } else {
            return "";
        }
    }
}

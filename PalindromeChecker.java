import java.util.Scanner;

public class PalindromeChecker {

    static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;

        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }

    static boolean isPalindromeRecursive(String text) {
        return recursiveCheck(text, 0, text.length() - 1);
    }

    static boolean recursiveCheck(String text, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (text.charAt(left) != text.charAt(right)) {
            return false;
        }

        return recursiveCheck(text, left + 1, right - 1);
    }

    static boolean isPalindromeArrayReversal(String text) {
        char[] originalArray = text.toCharArray();
        char[] reversedArray = new char[originalArray.length];

        for (int i = 0; i < originalArray.length; i++) {
            reversedArray[i] = originalArray[originalArray.length - 1 - i];
        }

        String reversedText = new String(reversedArray);

        return text.equals(reversedText);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter a word or phrase: ");
        String text = scanner.nextLine();

        text = text.replaceAll("\\s+", "").toLowerCase();

        boolean iterativeResult = isPalindromeIterative(text);
        boolean recursiveResult = isPalindromeRecursive(text);
        boolean arrayResult = isPalindromeArrayReversal(text);

        System.out.println("\nResults:");

        System.out.println("Iterative: " +
                (iterativeResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Recursive: " +
                (recursiveResult ? "Palindrome" : "Not Palindrome"));

        System.out.println("Array Reversal: " +
                (arrayResult ? "Palindrome" : "Not Palindrome"));

        if (iterativeResult == recursiveResult &&
            recursiveResult == arrayResult) {
            System.out.println("\nAll three approaches agree.");
        } else {
            System.out.println("\nThe approaches do not agree.");
        }

        scanner.close();
    }
}
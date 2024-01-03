package Level1;
import java.util.Scanner;

public class PalindromeChecker {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word or phrase: ");
        String input = sc.nextLine();

        boolean isPalindrome = isPalindrome(input);

        if (isPalindrome) {
            System.out.println("The given word or phrase is a palindrome.");
        } else {
            System.out.println("The given word or phrase is not a palindrome.");
        }
    }

    private static boolean isPalindrome(String input) {
        input = input.replaceAll("\\W", "").toLowerCase();
        int length = input.length();

        for (int i = 0; i < length / 2; i++) {
            if (input.charAt(i) != input.charAt(length - 1 - i)) {
                return false;
            }
        }

        return true;
    }
}
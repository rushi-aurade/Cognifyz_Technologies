package Level2;

import java.util.Scanner;

public class PasswordStrengthChecker {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a password: ");
        String password = scanner.nextLine();
        checkPasswordStrength(password);
    }

    public static void checkPasswordStrength(String password) {
        int passwordLength = password.length();
        int uppercaseCount = 0;
        int lowercaseCount = 0;
        int numberCount = 0;
        int specialCharCount = 0;

        for (int i = 0; i < passwordLength; i++) {
            char ch = password.charAt(i);

            if (Character.isUpperCase(ch)) {
                uppercaseCount++;
            } else if (Character.isLowerCase(ch)) {
                lowercaseCount++;
            } else if (Character.isDigit(ch)) {
                numberCount++;
            } else {
                specialCharCount++;
            }
        }

        boolean hasUppercase = uppercaseCount > 0;
        boolean hasLowercase = lowercaseCount > 0;
        boolean hasNumber = numberCount > 0;
        boolean hasSpecialChar = specialCharCount > 0;

        if (passwordLength >= 8 && hasUppercase && hasLowercase && hasNumber && hasSpecialChar) {
            System.out.println("Strong password.");
        } else if (passwordLength >= 8 && hasUppercase && hasLowercase && hasNumber) {
            System.out.println("Medium password. Add at least one special character.");
        } else if (passwordLength >= 8 && hasUppercase && hasLowercase && hasSpecialChar) {
            System.out.println("Medium password. Add at least one number.");
        } else if (passwordLength >= 8 && hasUppercase && hasNumber && hasSpecialChar) {
            System.out.println("Medium password. Add at least one lowercase letter.");
        } else if (passwordLength >= 8 && hasLowercase && hasNumber && hasSpecialChar) {
            System.out.println("Medium password. Add at least one uppercase letter.");
        } else if (passwordLength >= 8 && (hasUppercase || hasLowercase || hasNumber || hasSpecialChar)) {
            System.out.println("Medium password. Add more character types.");
        } else {
            System.out.println("Weak password. Password should be at least 8 characters long and include at least one uppercase letter, one lowercase letter, one number, and one special character.");
        }
    }
}
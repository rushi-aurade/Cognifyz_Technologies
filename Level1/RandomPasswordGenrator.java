package Level1;

import java.util.Random;
import java.util.Scanner;

public class RandomPasswordGenrator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the desired password length: ");
        int passwordLength = scanner.nextInt();

        System.out.println("Include numbers? (yes/no): ");
        boolean includeNumbers = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Include lowercase letters? (yes/no): ");
        boolean includeLowercase = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Include uppercase letters? (yes/no): ");
        boolean includeUppercase = scanner.next().equalsIgnoreCase("yes");

        System.out.println("Include special characters? (yes/no): ");
        boolean includeSpecial = scanner.next().equalsIgnoreCase("yes");

        String password = generatePassword(passwordLength, includeNumbers, includeLowercase, includeUppercase, includeSpecial);
        System.out.println("Generated password: " + password);
        
        scanner.close();
    }

    public static String generatePassword(int length, boolean includeNumbers, boolean includeLowercase, boolean includeUppercase, boolean includeSpecial) {
        String characters = "";
        if (includeNumbers) characters += "0123456789";
        if (includeLowercase) characters += "abcdefghijklmnopqrstuvwxyz";
        if (includeUppercase) characters += "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        if (includeSpecial) characters += "!@#$%^&*()-_=+[]{}|;:',.<>?/`~";

        Random random = new Random();
        StringBuilder password = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            password.append(characters.charAt(random.nextInt(characters.length())));
        }

        return password.toString();
    }
}
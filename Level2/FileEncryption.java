package Level2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileEncryption {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Choose between encryption (1) or decryption (2): ");
        int choice = scanner.nextInt();

        System.out.println("Enter the file name or path: ");
        String fileName = scanner.next();

        System.out.println("Enter the encryption/decryption key: ");
        int key = scanner.nextInt();

        String outputFileName = "encrypted_" + fileName;
        if (choice == 2) {
            outputFileName = "decrypted_" + fileName;
        }

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFileName));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String newLine = encryptOrDecrypt(line, choice, key);
                bufferedWriter.write(newLine);
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

            System.out.println("File encrypted/decrypted successfully. Output file name: " + outputFileName);

        } catch (IOException e) {
            System.out.println("An error occurred while encrypting/decrypting the file: " + e.getMessage());
        }
    }

    private static String encryptOrDecrypt(String input, int choice, int key) {
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < input.length(); i++) {
            char character = input.charAt(i);

            if (choice == 1) {
                character = (char) (((int) character + key - 32) % 95 + 32);
            } else if (choice == 2) {
                character = (char) (((int) character - key - 32) % 95 + 32);
            }

            output.append(character);
        }

        return output.toString();
    }
}
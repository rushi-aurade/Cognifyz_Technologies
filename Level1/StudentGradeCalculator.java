package Level1;

import java.util.Scanner;

public class StudentGradeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of grades: ");
        int numGrades = sc.nextInt();
        double[] grades = new double[numGrades];
        double total = 0;
       

        for (int i = 0; i < numGrades; i++) {
            System.out.println("Enter grade " + (i + 1) + ": ");
            grades[i] = sc.nextDouble();
            total += grades[i];
        }

        double average = total / numGrades;
        System.out.println("The average grade is: " + average);
    }
}
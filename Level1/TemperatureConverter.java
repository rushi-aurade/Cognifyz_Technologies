package Level1;

import java.util.Scanner;

public class TemperatureConverter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Temperature Converter");
        System.out.println("=====================");
        System.out.println("Enter the temperature value: ");
        double temp = sc.nextDouble();

        System.out.println("Enter the unit of measurement (C for Celsius or F for Fahrenheit): ");
        String unit = sc.next();

        if (unit.equalsIgnoreCase("C")) {
            double fahrenheit = convertCelsiusToFahrenheit(temp);
            System.out.println("The converted temperature is: " + fahrenheit + " degrees Fahrenheit.");
        } else if (unit.equalsIgnoreCase("F")) {
            double celsius = convertFahrenheitToCelsius(temp);
            System.out.println("The converted temperature is: " + celsius + " degrees Celsius.");
        } else {
            System.out.println("Invalid unit. Please enter 'C' for Celsius or 'F' for Fahrenheit.");
        }
    }

    private static double convertCelsiusToFahrenheit(double celsius) {
        return celsius * 9 / 5 + 32;
    }

    private static double convertFahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5 / 9;
    }
}
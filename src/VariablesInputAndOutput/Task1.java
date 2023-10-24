package VariablesInputAndOutput;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Please enter Fahrenheit: ");
        double fahrenheit = scanner.nextDouble();
        double celsius = (fahrenheit - 32) * 5.0 / 9.0;
        System.out.println(fahrenheit + " Fahrenheit is " + String.format("%.1f", celsius) + " Celsius");
        scanner.close();
    }
}

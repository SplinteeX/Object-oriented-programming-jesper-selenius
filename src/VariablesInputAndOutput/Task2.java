package VariablesInputAndOutput;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter first triangle side");
        double a = scanner.nextDouble();
        System.out.println("Please enter second triangle side");
        double b = scanner.nextDouble();
        double c = Math.sqrt(a*a + b*b);
        System.out.println("The hypotenuse of " + a + " and " + b + " is " + c);
        scanner.close();
    }
}

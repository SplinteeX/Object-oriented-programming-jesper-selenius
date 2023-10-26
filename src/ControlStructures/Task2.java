package ControlStructures;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        int decimal = 0;
        int length = binary.length();
        for (int i = 0; i < length; i++) {
            char bit = binary.charAt(i);
            if (bit == '1') {
                decimal += Math.pow(2, length - 1 - i);
            }
        }
        System.out.println("Binary number: " + binary);
        System.out.println("Decimal equivalent: " + decimal);
    }
    }

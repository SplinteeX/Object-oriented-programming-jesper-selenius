package Arrays;

import java.util.Scanner;

public class Task3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the size of an array: ");
        int size = scanner.nextInt();
        int[] numbers = new int[size];

        for (int i = 0; i < size; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }

        int[] nonDuplicates = new int[size];
        int count = 0;

        for (int i = 0; i < size; i++) {
            boolean isDuplicate = false;
            for (int j = 0; j < count; j++) {
                if (numbers[i] == nonDuplicates[j]) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                nonDuplicates[count] = numbers[i];
                count++;
            }
        }
        System.out.println("Array without duplicates:");

        for (int i = 0; i < count; i++) {
            System.out.print(nonDuplicates[i]);
            System.out.print(" ");
        }
    }
}

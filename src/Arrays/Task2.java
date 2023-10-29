package Arrays;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the size of the array: ");
        int arraySize = scanner.nextInt();
        int[] numbers = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            System.out.print("Enter integer " + (i + 1) + ": ");
            int arrayNumber = scanner.nextInt();
            numbers[i] = arrayNumber;
        }

        int maxSum = Integer.MIN_VALUE;
        int startIndex = 0;
        int endIndex = 0;

        for (int i = 0; i < arraySize; i++) {
            int currentSum = 0;
            for (int j = i; j < arraySize; j++) {
                currentSum += numbers[j];

                if (currentSum > maxSum) {
                    maxSum = currentSum;
                    startIndex = i;
                    endIndex = j;
                }
            }
        }

        System.out.println("Maximum sum: " + maxSum);
        System.out.println("Integers: " + (startIndex + 1) + "-" + (endIndex + 1));
    }
}

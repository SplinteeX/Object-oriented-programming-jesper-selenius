package ControlStructures;
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a starting number: ");
        int start = scanner.nextInt();
        System.out.print("Enter a ending number: ");
        int end = scanner.nextInt();
        while (start <= end) {
            boolean isPrime = true;
            if (start <= 1) {
                isPrime = false;
            } else {
                for(int i=2;i <= Math.sqrt(start); i++ ){
                    if(start%i == 0) {
                        isPrime = false;
                        break;
                    }
                }
            }
            if(isPrime) {
                System.out.println(start + " Is a prime number.");
            }
            start++;

        }

    }
}

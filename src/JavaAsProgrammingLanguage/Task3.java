package JavaAsProgrammingLanguage;
import java.util.Scanner;
public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Give the first number:");
        int first = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the second number:");
        int second = Integer.parseInt(scanner.nextLine());

        System.out.println("Give the third number:");
        int third = Integer.parseInt(scanner.nextLine());

        System.out.println("The sum of the numbers is " + (first + second + third));
        System.out.println("The product of the numbers is " + (first * second * third));
        System.out.println("The average of the numbers is " + ((first + second + third) / 3.0));

        /* Explanation of this program: The user gives three values within the terminal. After that the
        program sums the number, products them and finally gets the average of them. On first with the average
        i tried to use number without decimals "3", but i had to use 3.0 (decimals) to get decimals as
        answer
         */
    }
}

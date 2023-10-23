package JavaAsProgrammingLanguage;
import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Please enter your name: ");
        String userName = scanner.nextLine();

        String greeting = "Hello, " + userName;
        System.out.println(greeting);

        scanner.close();
    }
}

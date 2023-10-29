package Arrays;
import java.util.Scanner;
import java.util.Random;

public class Task1 {
    public static void main(String[] args) {
        String[] finnishFirstNamesList = {"Aino", "Mikko", "Anna", "Pekka", "Ella", "Antti", "Sofia", "Juhani", "Emilia", "Olavi"};
        String[] finnishLastNamesList = {"Korhonen", "Virtanen", "Mäkinen", "Nieminen", "Hämäläinen", "Laine", "Koivisto", "Kallio", "Turunen", "Lehtonen"};

        Scanner scanner = new Scanner(System.in);
        System.out.print("How many generated random names? : ");
        int max = scanner.nextInt();
        Random random = new Random();

        for (int i = 0; i < max; i++) {
            int randomNumber1 = random.nextInt(9);
            int randomNumber2 = random.nextInt(9);
            System.out.println("Generated name: " + finnishFirstNamesList[randomNumber1] + " " + finnishLastNamesList[randomNumber2]);
        }
    }
}

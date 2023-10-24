package VariablesInputAndOutput;
import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Weight (g)");
        double weight = scanner.nextDouble();
        double luoti;
        double naula = 0;
        double leiviska = 0;

        if (weight >= 13.28) {
            luoti = weight / 13.28;
                while (luoti > 32) {
                    naula = naula + 1;
                    luoti = luoti - 32;
                }
                while (naula > 20) {
                    leiviska = leiviska + 1;
                    naula = naula - 20;
                }
            System.out.println(weight + " grams is " + leiviska + " Leiviskä, " + naula + " naula, " + String.format("%.2f", luoti) + " luoti.");

        }
        else {
            System.out.println("Grams should be over 13.28");
        }
    }
}

package ControlStructures;

import java.util.Scanner;
import java.util.Random;

public class Task4 {
    public static void main(String[] args) {
        Random random = new Random();
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is a multiplication table exam!");
        int score = 0;

        while (score < 10) {
            int first = random.nextInt(11);
            int second = random.nextInt(11);
            System.out.print("What is " + first + " times " + second + ": ");
            int input = scanner.nextInt();

            if (first * second == input) {
                score++;
                System.out.println("That's correct! Score: " + score);
            } else {
                System.out.println("Oh no, it was wrong. Game has been reset.");
                score = 0;
            }
        }

        System.out.println("Congratulations, you won!");
        scanner.close();
    }
}

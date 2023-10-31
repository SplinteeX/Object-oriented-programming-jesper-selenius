package Class;

import java.util.Scanner;

public class Task3 {
    public static void main(String[] args) {
        CoffeeMaker myCoffeeMaker = new CoffeeMaker("", 0);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            myCoffeeMaker.isCoffeeMakerOn(true);
            System.out.print("Choose coffee type Normal / Espresso: ");
            String input = scanner.next();

            if (input.equalsIgnoreCase("normal") || input.equalsIgnoreCase("espresso")) {
                System.out.print("Choose the coffee amount (0 - 80ml): ");
                int amount = scanner.nextInt();

                if (amount > 0 && amount <= 80) {
                    myCoffeeMaker.coffeeAmount = amount;
                    myCoffeeMaker.coffeeType = input;
                    System.out.println("Here is your coffee: " + myCoffeeMaker.coffeeType + " " + myCoffeeMaker.coffeeAmount + " ml");
                    myCoffeeMaker.isCoffeeMakerOn(false);

                    break;
                } else {
                    System.out.println("False amount of coffee");
                }
            }
        }



    }
}

class CoffeeMaker {
    public String coffeeType;
    public int coffeeAmount;
    public boolean isOn = false;

    public CoffeeMaker(String coffeeType, int coffeeAmount) {
        this.coffeeType = coffeeType;
        this.coffeeAmount = coffeeAmount;
    }
    public void isCoffeeMakerOn(boolean isOn) {
        this.isOn = isOn;
        if (isOn) {
            System.out.println("Coffee maker is on!");
        } else {
            System.out.println("Coffee maker is off!");
        }
    }
}

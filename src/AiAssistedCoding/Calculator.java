package AiAssistedCoding;

public class Calculator {
    private int currentValue;

    public Calculator() {
        this.currentValue = 0;
    }

    // Method to reset the calculator to zero
    public void reset() {
        this.currentValue = 0;
    }

    // Method to add an integer to the calculator. Throws an exception if the integer is negative
    public void add(int num) throws Exception {
        if (num < 0) {
            throw new Exception("Cannot add negative integers");
        }
        this.currentValue += num;
    }

    // Method to return the current value of the calculator
    public int getCurrentValue() {
        return this.currentValue;
    }

    // Method to calculate the sum of integers in an array using a while loop
    public int sum(int[] numbers) {
        int total = 0;
        for (int i = 0; i < numbers.length; i++) {
            total += numbers[i];
        }
        return total;
    }
    // Create a temporary main for this class to test the methods
    public static void main(String[] args) {
        Calculator calc = new Calculator();
        try {
            calc.add(5);
            calc.add(10);
            calc.add(-5);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Current Value: " + calc.getCurrentValue());

        int[] numbers = {5, 10, 5};
        int sumResult = calc.sum(numbers);
        System.out.println("Sum of Array: " + sumResult);
    }
}
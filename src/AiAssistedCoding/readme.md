## Calculator
The idea of the program is to be a calculator. You can add numbers by using add Method, you can reset the calulator by using Reset method and you can get current value with method GetCurrentValue. Also there is sum method that gets numbers from arraylist and sums them one by one.
```
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
```
## Explain how the code works
The code works by creating a class called Calculator. In this class there are methods that can be used to calculate numbers. There is also a main method that can be used to test the methods. The methods are add, reset, getCurrentValue and sum. Add method adds numbers to the calculator. Reset method resets the calculator to zero. GetCurrentvalue method gets the current value of the calculator. Sum method sums numbers from arraylist one by one.


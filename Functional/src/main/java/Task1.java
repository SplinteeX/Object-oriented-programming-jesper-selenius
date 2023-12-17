import java.util.Arrays;

public class Task1 {
    public static void main(String[] args) {
        double[] numbers = {1.2, 2.5, 3.7, 4.1, 5.6};

        double mean = Arrays.stream(numbers).average().orElse(Double.NaN);

        System.out.println("Mean of the array: " + mean);
    }
}

package DataStreamsAndExceptions;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Task2 {
    public static void main(String[] args) throws IOException {
        long[] fibonacciSequence = generateFibonacci(100);
        String filename = "fibonacci_sequence.csv";
        try (PrintWriter writer = new PrintWriter(new FileWriter(filename))) {
            writer.println("Fibonacci sequence");
            for (long number : fibonacciSequence) {
                writer.println(number);
            }
            System.out.println("Fibonacci sequence successfully written to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static long[] generateFibonacci(int n) {
        long[] sequence = new long[n];
        sequence[0] = 0;
        sequence[1] = 1;
        for (int i = 2; i < n; i++) {
            sequence[i] = sequence[i - 1] + sequence[i - 2];
        }
        return sequence;
    }
}

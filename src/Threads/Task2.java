package Threads;
import java.util.concurrent.*;

public class Task2 {
    private static final int NUM_THREADS = 4;
    private static final int ARRAY_SIZE = 1000;
    private static int[] numbers = new int[ARRAY_SIZE];
    public static void main(String[] args) {
        for (int i = 0; i < ARRAY_SIZE; i++) {
            numbers[i] = i + 1;
        }
        ExecutorService executor = Executors.newFixedThreadPool(NUM_THREADS);

        int portionSize = ARRAY_SIZE / NUM_THREADS;
        int startIndex = 0;
        int endIndex = portionSize;

        Future<Integer>[] results = new Future[NUM_THREADS];
        for (int i = 0; i < NUM_THREADS; i++) {
            if (i == NUM_THREADS - 1) {
                endIndex = ARRAY_SIZE;
            }
            Callable<Integer> task = new SummationTask(startIndex, endIndex);
            results[i] = executor.submit(task);

            startIndex = endIndex;
            endIndex = Math.min(endIndex + portionSize, ARRAY_SIZE);
        }
        int totalSum = 0;
        for (Future<Integer> result : results) {
            try {
                totalSum += result.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        executor.shutdown();

        System.out.println("Total Sum: " + totalSum);
    }
    static class SummationTask implements Callable<Integer> {
        private final int startIndex;
        private final int endIndex;

        public SummationTask(int startIndex, int endIndex) {
            this.startIndex = startIndex;
            this.endIndex = endIndex;
        }
        @Override
        public Integer call() {
            int sum = 0;
            for (int i = startIndex; i < endIndex; i++) {
                sum += numbers[i];
            }
            return sum;
        }
    }
}

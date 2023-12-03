package Threads;

class Task1 implements Runnable {
    private static volatile int number = 1;
    private int max;
    private boolean isEvenThread;

    public Task1(int max, boolean isEvenThread) {
        this.max = max;
        this.isEvenThread = isEvenThread;
    }

    public void run() {
        while (true) {
            synchronized (Task1.class) {
                if (isEvenThread && number % 2 == 0) {
                    System.out.println("Even Thread: " + number);
                    number++;
                    if (number > max) {
                        break;
                    }
                } else if (!isEvenThread && number % 2 != 0) {
                    System.out.println("Odd Thread: " + number);
                    number++;
                    if (number > max) {
                        break;
                    }
                } else {
                    try {
                        Task1.class.notify();
                        Task1.class.wait();
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        int maxNumber = 20;

        Thread evenThread = new Thread(new Task1(maxNumber, true));
        Thread oddThread = new Thread(new Task1(maxNumber, false));

        evenThread.start();
        oddThread.start();

        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        System.out.println("Printing complete.");
    }
}

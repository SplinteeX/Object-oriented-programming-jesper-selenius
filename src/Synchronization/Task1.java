package Synchronization;
import java.util.concurrent.locks.*;

class Task1 {
    private int totalSeats;
    private int availableSeats;
    private final ReentrantLock lock = new ReentrantLock();

    public Task1(int totalSeats) {
        this.totalSeats = totalSeats;
        this.availableSeats = totalSeats;
    }

    public boolean bookSeats(int seats, int customerNumber) {
        lock.lock();
        try {
            if (seats <= availableSeats) {
                availableSeats -= seats;
                System.out.println("Customer " + customerNumber + " reserved " + seats + " tickets.");
                return true;
            } else {
                System.out.println("Customer " + customerNumber + " couldn't reserve " + seats + " tickets.");
                return false;
            }
        } finally {
            lock.unlock();
        }
    }
}

class Customer extends Thread {
    private Task1 theater;
    private int seatsNeeded;
    private int customerNumber;

    public Customer(Task1 theater, int seatsNeeded, int customerNumber) {
        this.theater = theater;
        this.seatsNeeded = seatsNeeded;
        this.customerNumber = customerNumber;
    }

    public void run() {
        theater.bookSeats(seatsNeeded, customerNumber);
    }
    public static void main(String[] args) {
        int totalSeats = 10;
        Task1 theater = new Task1(totalSeats);

        Customer[] customers = new Customer[15];
        for (int i = 0; i < customers.length; i++) {
            int seatsNeeded = (int) (Math.random() * 5) + 1;
            customers[i] = new Customer(theater, seatsNeeded, i + 1);
            customers[i].start();
        }
    }
}



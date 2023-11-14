package Inheritance;

public class Task2 {
    public static void main(String[] args) {
        Bus myBus = new Bus("Mercedes", 120, 60.0, 30);

        System.out.println("Bus Type: " + myBus.getTypeName());
        System.out.println("Tank Capacity: " + myBus.getTankCapacity());
        System.out.println("Top Speed: " + myBus.getSpeed() + " km/h");
        System.out.println("Max Passengers: " + myBus.getMaxPassengers());

        for (int i = 0; i < 35; i++) {
            myBus.passengerEnter();
        }
        myBus.passengerEnter();

        System.out.println("Current Passengers: " + myBus.getPassengers());

        for (int i = 0; i < 20; i++) {
            myBus.passengerExit();
            System.out.println();
        }
        System.out.println("Updated Passengers: " + myBus.getPassengers());
    }
}

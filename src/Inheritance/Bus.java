package Inheritance;

public class Bus extends Car {
    private int passengers;
    private int maxPassengers;

    public Bus(String typeName, int topSpeed, double tankCapacity, int maxPassengers) {
        super(typeName, topSpeed, tankCapacity);
        this.passengers = 0;
        this.maxPassengers = maxPassengers;
    }

    public void passengerEnter() {
        if (passengers < maxPassengers) {
            this.passengers += 1;
            System.out.println("1 passenger entered to the buss! Current passengers: " + passengers);
        } else {
            System.out.println("Bus is full!");
        }
    }

    public void passengerExit() {
        if (passengers > 0) {
            this.passengers -= 1;
            System.out.println("1 passenger left! Current passengers: " + passengers);
        } else {
            System.out.println("Bus is already empty!");
        }
    }

    public int getPassengers() {
        return passengers;
    }

    public int getMaxPassengers() {
        return maxPassengers;
    }

    public void setMaxPassengers(int maxPassengers) {
        this.maxPassengers = maxPassengers;
    }
}

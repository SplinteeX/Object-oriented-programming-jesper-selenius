package Interface;

import java.util.ArrayList;
import java.util.List;

public class Task2 {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        List<AbstractVehicle> vehicles = new ArrayList<>();
        Task2 task2 = new Task2();

        vehicles.add(task2.new Car());
        vehicles.add(task2.new Motorcycle());
        vehicles.add(task2.new Bus());

        for (AbstractVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.honk();
            System.out.println(vehicle.getInfo() + "\n");
        }
    }

    abstract class AbstractVehicle implements Vehicle {
        @Override
        public abstract void start();

        @Override
        public abstract void stop();

        @Override
        public abstract String getInfo();

        public abstract void honk();
    }

    class Car extends AbstractVehicle {
        @Override
        public void start() {
            System.out.println("Car is starting");
        }

        @Override
        public void stop() {
            System.out.println("Car is stopping");
        }

        @Override
        public String getInfo() {
            return "Type: Car\nFuel: Diesel\nColor: Yellow";
        }

        @Override
        public void honk() {
            System.out.println("Tööt");
        }
    }

    class Motorcycle extends AbstractVehicle {
        @Override
        public void start() {
            System.out.println("Motorcycle is starting");
        }

        @Override
        public void stop() {
            System.out.println("Motorcycle is stopping");
        }

        @Override
        public String getInfo() {
            return "Type: Motorcycle\nFuel: Petrol\nColor: Red";
        }

        @Override
        public void honk() {
            System.out.println("Tuut");
        }
    }

    class Bus extends AbstractVehicle {
        @Override
        public void start() {
            System.out.println("Bus is starting...");
        }

        @Override
        public void stop() {
            System.out.println("Bus is stopping...");
        }

        @Override
        public String getInfo() {
            return "Type: Bus\nFuel: Diesel\nCapacity: 65 passengers";
        }

        @Override
        public void honk() {
            System.out.println("TöötTööt");
        }
    }
}

package Interface;

import java.util.ArrayList;
import java.util.List;

public class Task3 {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        List<AbstractVehicle> vehicles = new ArrayList<>();

        vehicles.add(new ElectricCar());
        vehicles.add(new ElectricMotorcycle());
        vehicles.add(new ElectricBus());

        for (AbstractVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.honk();
            vehicle.charge();
            System.out.println(vehicle.getInfo() + "\n");
        }
    }

    interface ElectricVehicle {
        void charge();
    }

    abstract static class AbstractVehicle implements Vehicle, ElectricVehicle {
        @Override
        public abstract void start();

        @Override
        public abstract void stop();

        @Override
        public abstract String getInfo();

        @Override
        public void charge() {
            System.out.println("No possible way to charge.");
        }

        public abstract void honk();
    }

    static class ElectricCar extends AbstractVehicle {
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
            return "Type: Car\nFuel: Electric\nColor: Yellow";
        }

        @Override
        public void honk() {
            System.out.println("Tööt");
        }

        @Override
        public void charge() {
            System.out.println("Charging the electric car.");
        }
    }

    static class ElectricMotorcycle extends AbstractVehicle {
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
            return "Type: Motorcycle\nFuel: Electric\nColor: Red";
        }

        @Override
        public void honk() {
            System.out.println("Tuut");
        }

        @Override
        public void charge() {
            System.out.println("Charging the electric motorcycle.");
        }
    }

    static class ElectricBus extends AbstractVehicle {
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
            return "Type: Bus\nFuel: Electric\nCapacity: 65 passengers";
        }

        @Override
        public void honk() {
            System.out.println("TöötTööt");
        }

        @Override
        public void charge() {
            System.out.println("Charging the electric bus.");
        }
    }

}

package Interface;

import java.util.ArrayList;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        List<Task4.AbstractVehicle> vehicles = new ArrayList<>();

        vehicles.add(new Task4.ElectricCar());
        vehicles.add(new Task4.ElectricMotorcycle());
        vehicles.add(new Task4.ElectricBus());
        vehicles.add(new Task4.DieselCar());

        for (Task4.AbstractVehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            vehicle.honk();
            vehicle.charge();
            vehicle.calculateFuelEfficiency();
            System.out.println(vehicle.getInfo() + "\n");
        }
    }

    interface Vehicle {
        void start();

        void stop();

        String getInfo();

        double calculateFuelEfficiency();
    }

    interface ElectricVehicle {
        void charge();

        double calculateFuelEfficiency();
    }

    abstract static class AbstractVehicle implements Task4.Vehicle, Task4.ElectricVehicle {
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
        protected double batteryCapacity = 60;
        protected double range = 350;

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

        @Override
        public double calculateFuelEfficiency() {
            System.out.println("The fuel efficiency is " + batteryCapacity / range + " kwh");
            return batteryCapacity / range;
        }
    }

    static class ElectricMotorcycle extends AbstractVehicle {
        protected double batteryCapacity = 40;
        protected double range = 80;

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

        @Override
        public double calculateFuelEfficiency() {
            System.out.println("The fuel efficiency is " + batteryCapacity / range + " kwh");
            return batteryCapacity / range;
        }
    }

    static class ElectricBus extends Task4.AbstractVehicle {
        private double batteryCapacity = 50;
        private double range = 150;

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

        @Override
        public double calculateFuelEfficiency() {
            System.out.println("The fuel efficiency is " + batteryCapacity / range + " kwh");
            return batteryCapacity / range;
        }
    }

    static class DieselCar extends Task4.AbstractVehicle {
        protected double fuelTankCapacity = 60;
        protected double distanceCovered = 600;

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
            return "Type: Car\nFuel: Diesel\nColor: Orange";
        }

        @Override
        public void honk() {
            System.out.println("Tööt");
        }

        @Override
        public double calculateFuelEfficiency() {
            System.out.println("The fuel efficiency is " + distanceCovered / fuelTankCapacity + " km/l");
            return distanceCovered / fuelTankCapacity;
        }

    }
}

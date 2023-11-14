package Interface;

import java.util.ArrayList;
import java.util.List;

interface Vehicle {
    void start();

    void stop();

    String getInfo();
}

class Car implements Vehicle {
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
}

class Motorcycle implements Vehicle {
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
}

class Bus implements Vehicle {
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
}

class VehicleDemo {
    public static void main(String[] args) {
        System.out.println("Vehicle Demonstration\n");

        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new Motorcycle());
        vehicles.add(new Bus());

        for (Vehicle vehicle : vehicles) {
            vehicle.start();
            vehicle.stop();
            System.out.println(vehicle.getInfo() + "\n");
        }
    }
}

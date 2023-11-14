package Inheritance;

public class Task1 {
    public static void main(String[] args) {
        Car myCar = new Car("Toyota", 165, 40.0);
        myCar.fillTank();
        System.out.println("Car Type: " + myCar.getTypeName());
        System.out.println("Tank capacity: " + myCar.getTankCapacity());
        System.out.println("Top Speed: " + myCar.getTopSpeed() + " km/h");

        for (int i = 0; i < 60; i++) {
            myCar.accelerate();
            System.out.println("Car Speed: " + myCar.getSpeed() + " km/h");
            System.out.println("Car Gasoline Level: " + myCar.getGasolineLevel() + " liters");
        }

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(10);
            System.out.println("Car Speed: " + myCar.getSpeed() + " km/h");
            System.out.println("Car Gasoline Level: " + myCar.getGasolineLevel() + " liters");
        }

        System.out.println(" ");

        SportsCar mySportsCar = new SportsCar("Ferrari", 300, 60.0);
        mySportsCar.fillTank();
        System.out.println("Sports Car Type: " + mySportsCar.getTypeName());
        System.out.println("Tank capacity: " + mySportsCar.getTankCapacity());
        System.out.println("Top Speed: " + mySportsCar.getTopSpeed() + " km/h");

        for (int i = 0; i < 60; i++) {
            mySportsCar.accelerate();
            System.out.println("Sports Car Speed: " + mySportsCar.getSpeed() + " km/h");
            System.out.println("Sports Car Gasoline Level: " + mySportsCar.getGasolineLevel() + " liters");
        }

        while (mySportsCar.getSpeed() > 0) {
            mySportsCar.decelerate(15);
            System.out.println("Sports Car Speed: " + mySportsCar.getSpeed() + " km/h");
            System.out.println("Sports Car Gasoline Level: " + mySportsCar.getGasolineLevel() + " liters");
        }
    }
}

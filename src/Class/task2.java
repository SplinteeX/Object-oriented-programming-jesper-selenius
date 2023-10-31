package Class;

import java.util.Random;

public class task2 {
    public static void main(String[] args) {
        Car myCar = new Car("toyota", 165, 40.0);
        myCar.fillTank();
        System.out.println("Car Type: " + myCar.typeName);
        System.out.println("Tank capavity: " + myCar.tankCapacity);
        System.out.println("Top Speed: " + myCar.topSpeed + " km/h");

        for (int i = 0; i < 60; i++) {
            myCar.accelerate();
        }

        while (myCar.getSpeed() > 0)
            myCar.decelerate(10);
    }

}
class Car {
    public float speed;
    public float gasolineLevel;
    public String typeName;
    public int topSpeed;
    public double tankCapacity;

    public Car(String typeName, int topSpeed, double tankCapacity) {
        speed = 0; gasolineLevel = 0;
        this.typeName = typeName;
        this.topSpeed = topSpeed;
        this.tankCapacity = tankCapacity;

    }
    public void accelerate() {
        if (gasolineLevel > 0) {
            if (speed < this.topSpeed) {
                speed += 10;
                if (speed >  this.topSpeed) {
                    speed = this.topSpeed;
                }
            }
        } else {
            speed = 0;
        }
    }
    void decelerate(int amount) {
        if (gasolineLevel > 0) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else
            speed = 0;
    }
    float getSpeed() {
        return speed;
    }
    String getTypeName() {
        return typeName;
    }
    void fillTank() {
        gasolineLevel = 100;
    }
    float getGasolineLevel() {
        return (float) ((gasolineLevel * tankCapacity) / 100);
    }
}

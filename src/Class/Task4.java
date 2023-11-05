package Class;

public class Task4 {
    public static void main(String[] args) {
        Car_2 myCar = new Car_2("Toyota Corolla", 165, 40.0); // Use Car_2 constructor
        myCar.fillTank();
        System.out.println("Car Type: " + myCar.getTypeName());
        System.out.println("Tank capacity: " + myCar.getTankCapacity() + " liters");
        System.out.println("Top Speed: " + myCar.getTopSpeed() + " km/h");

        int targetSpeed = 100;
        boolean cruiseControlActivated = myCar.turnOnCruiseControl(targetSpeed);

        if (cruiseControlActivated) {
            System.out.println("Cruise control turned on. Target speed: " + myCar.getCurrentTargetSpeed() + " km/h");
        } else {
            System.out.println("Failed to activate cruise control. Invalid target speed.");
        }

        for (int i = 0; i < 30; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.turnOffCruiseControl();

        for (int i = 0; i < 20; i++) {
            myCar.accelerate();
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }

        myCar.decelerate(20);

        while (myCar.getSpeed() > 0) {
            myCar.decelerate(10);
            System.out.println(myCar.getTypeName() + ": speed is " + myCar.getSpeed() + " km/h");
        }
    }
}

class Car_2 {
    private float speed;
    private float gasolineLevel; // Made private
    private String typeName;
    private int topSpeed;
    private double tankCapacity;

    private boolean cruiseControlOn = false;
    private int minCruiseSpeed;
    private int maxCruiseSpeed;
    private int targetSpeed;

    public Car_2(String typeName, int topSpeed, double tankCapacity) {
        speed = 0;
        gasolineLevel = 0;
        this.typeName = typeName;
        this.topSpeed = topSpeed;
        this.tankCapacity = tankCapacity;

        minCruiseSpeed = 40;
        maxCruiseSpeed = 120;
        targetSpeed = 0;
    }

    public boolean turnOnCruiseControl(int targetSpeed) {
        if (targetSpeed >= minCruiseSpeed && targetSpeed <= maxCruiseSpeed) {
            this.targetSpeed = targetSpeed;
            cruiseControlOn = true;
            return true;
        } else {
            cruiseControlOn = false;
            return false;
        }
    }

    public void turnOffCruiseControl() {
        cruiseControlOn = false;
        System.out.println("Cruise control has been turned off!");
    }

    public boolean isCruiseControlOn() {
        return cruiseControlOn;
    }

    public int getCurrentTargetSpeed() {
        return targetSpeed;
    }

    public void accelerate() {
        if (isCruiseControlOn()) {
            if (speed < targetSpeed) {
                speed += 10;
                if (speed > targetSpeed) {
                    speed = targetSpeed;
                }
            }
        } else {
            if (gasolineLevel > 0) {
                if (speed < topSpeed) {
                    speed += 10;
                    if (speed > topSpeed) {
                        speed = topSpeed;
                    }
                }
            } else {
                speed = 0;
            }
        }
    }

    public void decelerate(int amount) {
        if (isCruiseControlOn()) {
            if (amount > 0)
                speed = Math.max(0, speed - amount);
        } else {
            if (gasolineLevel > 0) {
                if (amount > 0)
                    speed = Math.max(0, speed - amount);
            } else
                speed = 0;
        }
    }

    public float getSpeed() {
        return speed;
    }

    public String getTypeName() {
        return typeName;
    }

    public void fillTank() {
        gasolineLevel = 100;
    }

    public float getGasolineLevel() {
        return (float) ((gasolineLevel * tankCapacity) / 100);
    }

    public double getTankCapacity() {
        return tankCapacity;
    }

    public int getTopSpeed() {
        return topSpeed;
    }
}

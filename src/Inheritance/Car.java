package Inheritance;

class Car {

    private float speed;
    private float gasolineLevel;
    private String typeName;
    private int topSpeed;
    private double tankCapacity;

    private boolean cruiseControlOn = false;
    private int minCruiseSpeed;
    private int maxCruiseSpeed;
    private int targetSpeed;


    public Car(String typeName, int topSpeed, double tankCapacity) {
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
                    decreaseGasoline(1);
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
                decreaseGasoline(1);
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

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setGasolineLevel(double gasoline) {
        gasolineLevel = (float) gasoline;
    }

    public void decreaseGasoline(double gasoline) {
        gasolineLevel = (float) (gasolineLevel - gasoline);
        if (gasolineLevel <= 0) {
            gasolineLevel = 0;
        }
    }

}

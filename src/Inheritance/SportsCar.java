package Inheritance;

public class SportsCar extends Car {

    public SportsCar(String typeName, int topSpeed, double tankCapacity) {
        super(typeName, topSpeed, tankCapacity);
    }

    @Override
    public void accelerate() {
        if (isCruiseControlOn()) {
            if (getSpeed() < getCurrentTargetSpeed()) {
                setSpeed(getSpeed() + 30);
                if (getSpeed() > getCurrentTargetSpeed()) {
                    setSpeed(getTopSpeed());
                }
            }
        } else {
            if (getGasolineLevel() > 0) {
                if (getSpeed() < getTopSpeed()) {
                    setSpeed(getSpeed() + 30);
                    if (getSpeed() > getTopSpeed()) {
                        setSpeed(getTopSpeed());
                    }
                    decreaseGasoline(2);
                }
            } else {
                setSpeed(0);
            }
        }
    }

    @Override
    public void decelerate(int amount) {
        if (isCruiseControlOn()) {
            if (amount > 0)
                setSpeed(Math.max(0, getSpeed() - amount));
        } else {
            if (getGasolineLevel() > 0) {
                if (amount > 0)
                    setSpeed(Math.max(0, getSpeed() - amount));
                decreaseGasoline(2);
            } else
                setSpeed(0);
        }
    }
}

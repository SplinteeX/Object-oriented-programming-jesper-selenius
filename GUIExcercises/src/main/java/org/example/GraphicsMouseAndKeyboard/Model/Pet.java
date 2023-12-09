package org.example.GraphicsMouseAndKeyboard.Model;

public class Pet {
    private double x;
    private double y;

    public Pet(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void updatePosition(double targetX, double targetY) {
        double distance = Math.sqrt(Math.pow((targetX - x), 2) + Math.pow((targetY - y), 2));

        double speed = 0.6;
        if (distance > speed) {
            double ratio = speed / distance;
            double moveX = (targetX - x) * ratio;
            double moveY = (targetY - y) * ratio;
            x += moveX;
            y += moveY;
        } else {
            x = targetX;
            y = targetY;
        }
    }
    public double getX() {
        return x;
    }
    public double getY() {
        return y;
    }
}

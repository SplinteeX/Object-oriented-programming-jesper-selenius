package Inheritance;

public class Shape {
    String color;

    Shape(String color) {
        this.color = color;
    }

    double calculateArea() {
        return 0;
    }
}

class Circle extends Shape {
    double radius;

    Circle(double radius, String color) {
        super(color);
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }
}

class Rectangle extends Shape {
    double width;
    double height;

    Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return width * height;
    }
}

class Triangle extends Shape {
    double base;
    double height;

    Triangle(double base, double height, String color) {
        super(color);
        this.base = base;
        this.height = height;
    }

    @Override
    double calculateArea() {
        return 0.5 * base * height;
    }
}

class ShapeCalculator {
    public static void main(String[] args) {
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(3.0, "Yellow");
        shapes[1] = new Rectangle(2.5, 4.0, "Orange");
        shapes[2] = new Triangle(2.5, 5.5, "Violet");

        System.out.println("Shape Calculator\n");
        for (Shape shape : shapes) {
            System.out.println("Area of " + shape.color + " " + shape.getClass().getSimpleName() + ": " + shape.calculateArea());
        }
    }
}
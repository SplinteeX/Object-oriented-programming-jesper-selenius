package UnitTesting;

public class Pen {
    private Color color;
    private boolean cap;

    public enum Color {
        RED("red"), GREEN("green"), BLUE("blue");
        private final String color;

        Color(String color) {
            this.color = color;
        }

        @Override
        public String toString() {
            return color;
        }
    }

    public Pen() {
        this.color = Color.RED;
        this.cap = true;
    }

    public Pen(Color color) {
        this.color = color;
        this.cap = true;
    }

    public String draw() {
        if (!cap) {
            return "Drawing " + color.toString();
        }
        return "";
    }

    public void capOff() {
        cap = false;
    }

    public void capOn() {
        cap = true;
    }

    public void changeColor(Color newColor) {
        if (cap) {
            color = newColor; // Update color only if cap is off
        }
    }
}

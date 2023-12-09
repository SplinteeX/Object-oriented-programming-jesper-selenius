package GraphicsMouseAndKeyboard;

import javax.swing.*;

public class PetController {
    public PetController(PetView petView) {
        JFrame frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        frame.add(petView);
        frame.setVisible(true);
    }
}

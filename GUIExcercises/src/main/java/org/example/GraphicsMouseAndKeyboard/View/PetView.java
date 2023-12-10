package org.example.GraphicsMouseAndKeyboard.View;

import org.example.GraphicsMouseAndKeyboard.Model.Pet;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PetView extends JPanel {
    private Pet pet;
    private Image petImage;

    public PetView(Pet pet) {
        this.pet = pet;
        this.petImage = Toolkit.getDefaultToolkit().getImage("GUIExcercises/src/main/java/org/example/GraphicsMouseAndKeyboard/mouse.png");

        MediaTracker tracker = new MediaTracker(this);
        tracker.addImage(petImage, 0);
        try {
            tracker.waitForAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        addMouseMotionListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                pet.updatePosition(e.getX(), e.getY());
                repaint();
            }
        });
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(petImage, (int) pet.getX(), (int) pet.getY(), 20, 20, this);
    }
    public static void main(String[] args) {
        Pet pet = new Pet(250, 250);
        PetView petView = new PetView(pet);

        JFrame frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.add(petView);
        frame.setVisible(true);
    }
}


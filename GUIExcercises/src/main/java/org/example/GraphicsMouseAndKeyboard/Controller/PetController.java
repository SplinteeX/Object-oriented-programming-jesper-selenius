package org.example.GraphicsMouseAndKeyboard.Controller;

import org.example.GraphicsMouseAndKeyboard.Model.Pet;
import org.example.GraphicsMouseAndKeyboard.View.PetView;

import javax.swing.*;

public class PetController {
    public PetController() {
        Pet pet = new Pet(250, 250);
        PetView petView = new PetView(pet);

        JFrame frame = new JFrame("Virtual Pet");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);

        frame.add(petView);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new PetController();
    }
}

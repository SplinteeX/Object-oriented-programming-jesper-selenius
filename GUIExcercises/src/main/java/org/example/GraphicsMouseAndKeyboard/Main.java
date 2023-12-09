package org.example.GraphicsMouseAndKeyboard;

import org.example.GraphicsMouseAndKeyboard.Controller.PetController;
import org.example.GraphicsMouseAndKeyboard.Model.Pet;
import org.example.GraphicsMouseAndKeyboard.View.PetView;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet(250, 250);
        PetView petView = new PetView(pet);
        new PetController(petView);
    }
}



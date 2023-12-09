package GraphicsMouseAndKeyboard;

public class Main {
    public static void main(String[] args) {
        Pet pet = new Pet(250, 250);
        PetView petView = new PetView(pet);
        new PetController(petView);
    }
}



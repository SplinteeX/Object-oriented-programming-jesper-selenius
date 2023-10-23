package JavaAsProgrammingLanguage;

public class Task4 {
    private String name;

    public Task4(String name) {
        this.name = name;
    }

    public void meow() {
        System.out.println("The cat named " + name + " says: Meow!");
    }

    public static void main(String[] args) {
        // Create an instance of the Cat class with a name
        Task4 whiskers = new Task4("Whiskers");
        Task4 rex = new Task4("Rex");

        // Call the meow method on the cat instance
        whiskers.meow();
        whiskers.meow();
        rex.meow();
        whiskers.meow();
    }
}

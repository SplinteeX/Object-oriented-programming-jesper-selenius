package Collections;

import java.util.ArrayList;

public class Task1 {
    public static void main(String[] args) {
        GroceryListManager list = new GroceryListManager();
        System.out.println("Grocery list:");
        list.addItem("Apple");
        list.addItem("Tape");
        list.addItem("Chocolate");
        list.addItem("RedBull");
        list.displayList("Grocery");

        System.out.println("Is Apple in the list? " + list.checkItem("Apple"));

        list.removeItem("Apple");
        list.displayList("Updated");
    }
}

class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        if (!groceryList.contains(item)) {
            groceryList.add(item);
            System.out.println(item + " added to the list.");
        } else {
            System.out.println(item + " is already in the list.");
        }
    }

    public void removeItem(String item) {
        if (groceryList.contains(item)) {
            System.out.println("Removing item " + item + " from the list...");
            groceryList.remove(item);
        } else {
            System.out.println(item + " is not in the list.");
        }
    }

    public void displayList(String displayType) {
        System.out.println(displayType + " List:");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public boolean checkItem(String itemToCheck) {
        return groceryList.contains(itemToCheck);
    }
}

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
        list.displayList();
        list.checkItem("Apple");
        list.removeItem("Apple");
        System.out.println("Updated list: ");
        list.displayList();
    }
}

class GroceryListManager {
    private ArrayList<String> groceryList = new ArrayList<>();

    public void addItem(String item) {
        groceryList.add(item);
    }

    public void removeItem(String item) {
        System.out.println("Removing item " + item + " from the list...");
        groceryList.remove(item);
    }

    public void displayList() {
        int i = 0;
        for (String item : groceryList) {
            i++;
            System.out.println(i + ". " + item);
        }
    }

    public boolean checkItem(String listItem) {
        System.out.print("Is " + listItem + " in the list?: ");
        boolean check = groceryList.contains(listItem);
        System.out.println(check);
        return check;
    }

}


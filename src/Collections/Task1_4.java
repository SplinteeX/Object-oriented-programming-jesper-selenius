package Collections;

import java.util.HashMap;

public class Task1_4 {
    public static void main(String[] args) {
        GroceryListManager list = new GroceryListManager();
        System.out.println("Grocery list:");
        list.addItem("Apple", 2.99);
        list.addItem("Tape", 5.00);
        list.addItem("Chocolate", 2.49);
        list.addItemWithCategory("RedBull", 3.50, "Beverages");
        list.displayList("Grocery");

        System.out.println("Is Apple in the list? " + list.checkItem("Apple"));

        list.removeItem("Apple");
        list.displayList("Updated");
        System.out.println("Total cost: " + list.calculateTotalCost());
        list.displayByCategory("Beverages");
        System.out.println("-- Quantity changes --");
        list.addItemWithQuantity("Chocolate Muffin", 5, 5.0);
        list.displayAvailableItems();
        list.updateQuantity("Chocolate Muffin", 10);
    }
}
class GroceryListManager {
    private HashMap<String, ItemDetails> groceryList = new HashMap<>();

    public void addItem(String item, double cost) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, new ItemDetails(0, cost, ""));
            System.out.println(item + " added to the list.");
        } else {
            System.out.println(item + " is already in the list.");
        }
    }

    public void addItemWithCategory(String item, double cost, String category) {
        if (!groceryList.containsKey(item)) {
            groceryList.put(item, new ItemDetails(0, cost, category));
            System.out.println(item + " added to the list under the category: " + category);
        } else {
            System.out.println("Item " + item + " is already in the list!");
        }
    }

    public void addItemWithQuantity(String item, int quantity, double cost) {
        if (quantity <= 0) {
            System.out.println("Quantity must be higher than 0");
            return;
        }

        if (!groceryList.containsKey(item)) {
            groceryList.put(item, new ItemDetails(quantity, cost, ""));
            groceryList.get(item).setQuantity(quantity);
            System.out.println(item + " added to the list with a quantity of " + quantity);
        } else {
            System.out.println(item + " is already in the list.");
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (newQuantity <= 0) {
            System.out.println("Quantity must be higher than 0");
            return;
        }

        if (groceryList.containsKey(item)) {
            groceryList.get(item).setQuantity(newQuantity);
            System.out.println(item + " quantity has been updated successfully - " + item + " " + newQuantity + " pieces.");
        } else {
            System.out.println(item + " is not in the list.");
        }
    }
    public void displayAvailableItems() {
        System.out.println("Available items with quantitites:");
        int i = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            if (details.getQuantity() > 0) {
                System.out.println(i + ". " + item + " - quantity: " + details.getQuantity() + ", cost: " + details.getCost() + "€");
            }
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in the " + category + " category:");
        int i = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            if (details.getCategory().equalsIgnoreCase(category)) {
                System.out.println(i + ". " + item + " - " + details.getCost() + "€");
                i++;
            }
        }
    }

    public void removeItem(String item) {
        if (groceryList.containsKey(item)) {
            System.out.println("Removing item " + item + " from the list...");
            groceryList.remove(item);
        } else {
            System.out.println(item + " is not in the list.");
        }
    }

    public void displayList(String displayType) {
        System.out.println(displayType + " List:");
        int i = 1;
        for (String item : groceryList.keySet()) {
            ItemDetails details = groceryList.get(item);
            System.out.println(i + ". " + item + " - " + details.getCost() + "€");
            i++;
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (ItemDetails details : groceryList.values()) {
            totalCost += details.getCost();
        }
        return totalCost;
    }

    public boolean checkItem(String itemToCheck) {
        return groceryList.containsKey(itemToCheck);
    }

    private static class ItemDetails {
        private int quantity;
        private double cost;
        private String category;


        public ItemDetails(int quantity, double cost, String category) {
            this.quantity = quantity;
            this.cost = cost;
            this.category = category;
        }

        public double getCost() {
            return cost;
        }

        public String getCategory() {
            return category;
        }
        public int getQuantity() {
            return quantity;
        }
        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }
    }
}

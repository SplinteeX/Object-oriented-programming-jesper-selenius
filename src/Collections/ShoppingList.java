package Collections;

import java.util.HashMap;


public class ShoppingList {
    private HashMap<String, ItemDetails> shoppingList = new HashMap<>();

    public void addItem(String item, double cost) {
        if (!shoppingList.containsKey(item)) {
            shoppingList.put(item, new ItemDetails(0, cost, ""));
            System.out.println(item + " added to the shopping list.");
        } else {
            System.out.println(item + " is already in the shopping list.");
        }
    }

    public void addItemWithCategory(String item, double cost, String category) {
        if (!shoppingList.containsKey(item)) {
            shoppingList.put(item, new ItemDetails(0, cost, category));
            System.out.println(item + " added to the shopping list under the category: " + category);
        } else {
            System.out.println("Item " + item + " is already in the shopping list!");
        }
    }

    public void addItemWithQuantity(String item, int quantity, double cost) {
        if (quantity <= 0) {
            System.out.println("Quantity must be higher than 0");
            return;
        }

        if (!shoppingList.containsKey(item)) {
            shoppingList.put(item, new ItemDetails(quantity, cost, ""));
            shoppingList.get(item).setQuantity(quantity);
            System.out.println(item + " added to the shopping list with a quantity of " + quantity);
        } else {
            System.out.println(item + " is already in the shopping list.");
        }
    }

    public void updateQuantity(String item, int newQuantity) {
        if (newQuantity <= 0) {
            System.out.println("Quantity must be higher than 0");
            return;
        }

        if (shoppingList.containsKey(item)) {
            shoppingList.get(item).setQuantity(newQuantity);
            System.out.println(item + " quantity has been updated successfully - " + item + " " + newQuantity + " pieces.");
        } else {
            System.out.println(item + " is not in the shopping list.");
        }
    }

    public void displayAvailableItems() {
        System.out.println("Available items with quantities:");
        int i = 1;
        for (String item : shoppingList.keySet()) {
            ItemDetails details = shoppingList.get(item);
            if (details.getQuantity() > 0) {
                System.out.println(i + ". " + item + " - quantity: " + details.getQuantity() + ", cost: " + details.getCost() + "€");
                i++;
            }
        }
    }

    public void displayByCategory(String category) {
        System.out.println("Items in the " + category + " category:");
        int i = 1;
        for (String item : shoppingList.keySet()) {
            ItemDetails details = shoppingList.get(item);
            if (details.getCategory().equalsIgnoreCase(category)) {
                System.out.println(i + ". " + item + " - " + details.getCost() + "€");
                i++;
            }
        }
    }

    public void removeItem(String item) {
        if (shoppingList.containsKey(item)) {
            System.out.println("Removing item " + item + " from the shopping list...");
            shoppingList.remove(item);
        } else {
            System.out.println(item + " is not in the shopping list.");
        }
    }

    public void displayList(String displayType) {
        System.out.println(displayType + " List:");
        int i = 1;
        for (String item : shoppingList.keySet()) {
            ItemDetails details = shoppingList.get(item);
            System.out.println(i + ". " + item + " - " + details.getCost() + "€");
            i++;
        }
    }

    public double calculateTotalCost() {
        double totalCost = 0;
        for (ItemDetails details : shoppingList.values()) {
            totalCost += details.getCost();
        }
        return totalCost;
    }

    public boolean checkItem(String itemToCheck) {
        return shoppingList.containsKey(itemToCheck);
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


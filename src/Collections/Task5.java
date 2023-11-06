package Collections;

import Collections.ShoppingList;

import java.util.HashMap;
import java.util.Map;


public class Task5 {
    public static void main(String[] args) {
        Map<String, ShoppingList> shoppingLists = new HashMap<>();

        ShoppingList list1 = new ShoppingList();
        ShoppingList list2 = new ShoppingList();

        list1.addItem("Milk", 2.99);
        list1.addItemWithCategory("Apples", 1.49, "Fruits");
        list1.addItemWithQuantity("Eggs", 12, 2.49);

        list2.addItem("Bread", 1.99);
        list2.addItemWithCategory("Bananas", 0.99, "Fruits");

        list1.displayAvailableItems();
        list1.displayList("List 1");

        list2.displayAvailableItems();
        list2.displayList("List 2");

        shoppingLists.put("List 1", list1);
        shoppingLists.put("List 2", list2);

        ShoppingList selectedList = shoppingLists.get("List 1");
        selectedList.updateQuantity("Milk", 3);

        double totalCostList1 = list1.calculateTotalCost();
        double totalCostList2 = list2.calculateTotalCost();
        System.out.println("Total cost of List 1: " + totalCostList1 + "€");
        System.out.println("Total cost of List 2: " + totalCostList2 + "€");

        // Check if an item exists in a specific shopping list
        boolean itemExistsInList1 = list1.checkItem("Bread");
        boolean itemExistsInList2 = list2.checkItem("Apples");
        System.out.println("Is Bread in List 1? " + (itemExistsInList1 ? "Yes" : "No"));
        System.out.println("Are Apples in List 2? " + (itemExistsInList2 ? "Yes" : "No"));
    }
}

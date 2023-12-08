package TDD;

import java.util.HashMap;

public class ShoppingCart {
    private HashMap<String, Double> itemList = new HashMap<>();

    public void addItem(String item, double price) {
        itemList.put(item, price);
    }

    public void removeItem(String item) {
        if (itemList.containsKey(item)) {
            itemList.remove(item);
        }
    }

    public int getItemCount() {
        return itemList.size();
    }

    public double calculateTotal() {
        double total = 0;
        for (double price : itemList.values()) {
            total += price;
        }
        return total;
    }
}

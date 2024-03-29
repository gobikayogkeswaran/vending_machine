import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private Map<String, Integer> items;

    public Inventory() {
        items = new HashMap<>();
    }

    public void addItem(String item, int quantity) {
        items.put(item, quantity);
    }

    public boolean hasItem(String item) {
        return items.containsKey(item) && items.get(item) > 0;
    }

    public void dispenseItem(String item) {
        if (hasItem(item)) {
            items.put(item, items.get(item) - 1);
        }
    }

    public void restockItem(String item, int quantity) {
        if (items.containsKey(item)) {
            items.put(item, items.get(item) + quantity);
        } else {
            addItem(item, quantity);
        }
    }
}
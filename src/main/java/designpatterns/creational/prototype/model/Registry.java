package designpatterns.creational.prototype.model;

import java.util.HashMap;
import java.util.Map;

public class Registry {
    private Map<String, Item> items = new HashMap<>();

    public Registry() {
        loadItems();
    }

    public Item createItem(String id) {
        Item item = null;
        try {
            item = (Item) (items.get(id)).clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return item;
    }

    private void loadItems() {
        // Add a book to items class.
        Book book = Book.builder().author("Sharma-PS").pageCount(450).rating(40).build();
        book.setItemCost(351.5);
        book.setItemName("Prototype-pattern");
        book.setItemId("Book1");
        items.put(book.getItemId(), book);

        // Add a utensil to items class.
        Utensil utensil = Utensil.builder().modelType(Utensil.makeType.GOLD.toString()).weight(5.5).build();
        utensil.setItemCost(5666.50);
        utensil.setItemName("Dishes");
        utensil.setItemId("Dish1");
        items.put(utensil.getItemId(), utensil);
    }
}

package Basket;

import Discounts.IDiscount;

import java.util.ArrayList;

public class ShoppingBasket {
    ArrayList<Item> items;
    ArrayList<IDiscount> discounts;

    public ShoppingBasket() {
        this.items = new ArrayList<>();
        this.discounts = new ArrayList<>();
    }

    public double total() {
        double totalValue = 0;
        for(int i = 0; i < items.size(); i++) {
            totalValue += items.get(i).getPrice();
        }
        return totalValue;
    }

    public void scan(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        if (items.contains(item)) {
            items.remove(item);
        }
    }

    public void addDiscount(IDiscount discount) {
        discounts.add(discount);
    }

    public void removeDiscount(IDiscount discount) {
        discounts.remove(discount);
    }

    public int count() {
        return this.items.size();
    }

}

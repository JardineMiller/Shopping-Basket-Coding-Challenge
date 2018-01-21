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
        for(Item each : items) {
            totalValue += each.getPrice();
        }
        return totalValue;
    }

    public void empty() {
        this.items = new ArrayList<>();
    }

    public void scan(Item item) {
        items.add(item);
    }

    public void remove(Item item) {
        if (items.contains(item) && this.discounts.size() > 0) {
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

    public int discountSize() {
        return this.discounts.size();
    }

    public double applyDiscounts() {
        double discounted = this.total();
        for(IDiscount each : discounts) {
            discounted = each.applyDiscount(discounted);
        }
        return discounted;
    }



}

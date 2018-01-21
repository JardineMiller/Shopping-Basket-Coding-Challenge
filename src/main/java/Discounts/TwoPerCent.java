package Discounts;

import Basket.Item;

import java.util.ArrayList;

public class TwoPerCent implements IDiscount {
    public double applyDiscount(ArrayList<Item> items, double total) {
            return total * 0.98;
    }
}

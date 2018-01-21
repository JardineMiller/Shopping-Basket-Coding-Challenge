package Discounts;

import Basket.Item;

import java.util.ArrayList;

public class TenPerCent implements IDiscount {
    public double applyDiscount(ArrayList<Item> items, double total) {
        if(total >= 20.00) {
            return total * 0.9;
        }
        return total;
    }
}

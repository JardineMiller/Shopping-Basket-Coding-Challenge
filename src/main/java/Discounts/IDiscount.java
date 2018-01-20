package Discounts;

import Basket.Item;

import java.util.ArrayList;

public interface IDiscount {
    double applyDiscount(ArrayList<Item> items, double total);
}

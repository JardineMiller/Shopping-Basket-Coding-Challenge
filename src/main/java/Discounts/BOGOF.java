package Discounts;

import Basket.Item;

import java.util.ArrayList;

public class BOGOF implements IDiscount {
    public double applyDiscount(ArrayList<Item> items, double total){
        ArrayList<String> uniqueItems = new ArrayList<>();
        for(Item item : items) {
            if(!uniqueItems.contains(item.getName())) {
                uniqueItems.add((item.getName()));
            }
        }

        int i = 0;
        double discountedTotal = 0;
        for(String uniqueItem : uniqueItems) {
            for(Item item : items) {
                if(uniqueItem.equals(item.getName())) {
                    discountedTotal += item.getPrice();
                    i++;
                }
                if(i == 2){
                    discountedTotal -= item.getPrice();
                    i = 0;
                }
            }
        }
        return discountedTotal;
    }
}

package Discounts;

import Basket.Item;

import java.util.ArrayList;

public class BOGOF implements IDiscount {

    private ArrayList<String> getUniqueItems(ArrayList<Item> items) {
        ArrayList<String> uniqueItems = new ArrayList<>();
        for(Item item : items) {
            if(item.isBogof() && !uniqueItems.contains(item.getName())) {
                uniqueItems.add((item.getName()));
            }
        }
        return uniqueItems;
    }

    public double applyDiscount(ArrayList<Item> items, double total){
        ArrayList<String> uniqueItems = getUniqueItems(items);

        if(uniqueItems.size() > 0) {
            int i = 0;
            double discountedTotal = 0;
            for (String uniqueItem : uniqueItems) {
                for (Item item : items) {
                    if (uniqueItem.equals(item.getName())) {
                        discountedTotal += item.getPrice();
                        i++;
                    }
                    if (i == 2) {
                        discountedTotal -= item.getPrice();
                        i = 0;
                    }
                }
            }
            return discountedTotal;
        } else {
            return total;
        }
    }
}

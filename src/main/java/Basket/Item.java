package Basket;

public class Item {
    private double price;
    private String name;
    private boolean bogof;

    public Item(String name, double price) {
        this.price = price;
        this.name = name;
        this.bogof = false;
    }

    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

    public boolean isBogof() {
        return bogof;
    }

    public void setBogof(boolean status) {
        this.bogof = status;
    }
}

package Discounts;

public class TwoPerCent implements IDiscount {
    public double applyDiscount(double total) {
            return total * 0.98;
    }
}

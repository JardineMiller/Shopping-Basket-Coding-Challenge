import Basket.Item;
import Basket.ShoppingBasket;
import Discounts.BOGOF;
import Discounts.TenPerCent;
import Discounts.TwoPerCent;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class TestDiscount {
    ShoppingBasket basket;
    TenPerCent tenPc;
    TwoPerCent twoPc;
    BOGOF bogof;
    Item item;
    Item item2;

    @Before
    public void before() {
        basket = new ShoppingBasket();
        tenPc = new TenPerCent();
        twoPc = new TwoPerCent();
        bogof = new BOGOF();
        item = new Item("pizza", 50.00);
        item2 = new Item("pizza", 50.00);
        basket.scan(item);
        basket.scan(item2);
    }

    @Test
    public void bogofWorks() {
        basket.addDiscount(bogof);
        assertEquals(50.00, basket.applyDiscounts(), 0.01);
    }

    @Test
    public void tenPerCentWorks() {
        basket.addDiscount(tenPc);
        assertEquals(90.00, basket.applyDiscounts(),0.01);
    }

    @Test
    public void twoPerCentWorks() {
        basket.addDiscount(twoPc);
        assertEquals(98.00, basket.applyDiscounts(),0.01);
    }

    @Test
    public void allDiscountsWork() {
        basket.addDiscount(bogof);
        basket.addDiscount(tenPc);
        basket.addDiscount(twoPc);
        assertEquals(44.10, basket.applyDiscounts(),0.01);
    }
}

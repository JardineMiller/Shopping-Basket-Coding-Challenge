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
        basket.addDiscount(bogof);
    }

    @Test
    public void bogofWorks() {
        assertEquals(50.00, basket.applyDiscounts(), 0.01);
    }
}

import Basket.Item;
import Basket.ShoppingBasket;
import Discounts.BOGOF;
import Discounts.TenPerCent;
import Discounts.TwoPerCent;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {
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
        item = new Item("pizza", 50.00, false);
        item2 = new Item("apple", 25.00, false);
        basket.scan(item);
        basket.scan(item2);
        basket.addDiscount(tenPc);
    }

    @Test
    public void basketHasItems() {
        assertEquals(2, basket.count());
    }

    @Test
    public void canRemoveItems() {
        basket.remove(item2);
        assertEquals(1, basket.count());
    }

    @Test
    public void canEmptyBasket() {
        basket.empty();
        assertEquals(0, basket.count());
    }

    @Test
    public void cantRemoveWhenEmpty() {
        basket.remove(item);
        basket.remove(item2);
        basket.remove(item);
        assertEquals(0, basket.count());
    }

    @Test
    public void canGetBasketValue() {
        assertEquals(75.00, basket.total(), 0.01);
    }

    @Test
    public void canAddDiscount() {
        assertEquals(1, basket.discountSize());
    }

    @Test
    public void canRemoveDiscount() {
        basket.removeDiscount(tenPc);
        assertEquals(0, basket.discountSize());
    }

    @Test
    public void canApplyDiscounts() {
        assertEquals(67.50, basket.applyDiscounts(), 0.01);
    }

    @Test
    public void canApplyMultipleDiscounts() {
        basket.addDiscount(twoPc);
        assertEquals(66.15, basket.applyDiscounts(), 0.01);
    }

}

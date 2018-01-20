import Basket.Item;
import Basket.ShoppingBasket;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestShoppingBasket {
    ShoppingBasket basket;
    Item item;
    Item item2;

    @Before
    public void before() {
        basket = new ShoppingBasket();
        item = new Item("pizza", 50.00);
        item2 = new Item("apple", 25.00);
        basket.scan(item);
        basket.scan(item2);
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
    public void canGetBasketValue() {
        assertEquals(75.00, basket.total(), 0.01);
    }
}

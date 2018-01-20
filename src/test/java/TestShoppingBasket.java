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
        item = new Item("pizza", 50);
        item2 = new Item("apple", 25);
        basket.scan(item);
        basket.scan(item2);
    }

    @Test
    public void basketHasItems() {
        assertEquals(2, basket.count());
    }
}

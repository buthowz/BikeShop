

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrderTest.
 *
 * @author  Sujit Neupane
 * @version 04/21/2017
 */
public class OrderTest
{
    /**
     * Default constructor for test class OrderTest
     */
    public OrderTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }
    
    @Test
    public void test_GetOrderNumber() {
        Order myOrder = new Order(5, 0);
        assertEquals(5, myOrder.getOrderNumber());
    }
    
    @Test
    public void test_GetOrderNumberOne() {
        Order myOrder = new Order();
        assertEquals(0, myOrder.getOrderNumber());
    }
    
    @Test
    public void test_GetDicountPercentage() {
        Order myOrder = new Order(5, 5);
        assertEquals(5, myOrder.getDiscountPercentage(), 0.01);
    }
    
    @Test
    public void test_GetOrderedItems() {
        Order myOrder = new Order(5, 5);
        OrderedItems myItems = new OrderedItems(1, "gh", "break", 30);
        myOrder.getListOfOrderedItems().add(myItems);
        assertEquals(myItems, myOrder.getOrderedItems(0));
    }
    
    @Test
    public void test_addOrderedItems() {
        Order myOrder = new Order(5, 5);
        OrderedItems myItems = new OrderedItems(1, "gh", "break", 30);
        myOrder.addOrderedItems(myItems);
        assertEquals(myItems, myOrder.getOrderedItems(0));
    }
    
    @Test
    public void test_GetTotalOrderPrice() {
        Order myOrder = new Order(5, 5);
        OrderedItems myItems = new OrderedItems(2, "gh", "break", 30);
        OrderedItems myItems_1 = new OrderedItems(1, "gh", "break", 10);
        myOrder.addOrderedItems(myItems);
        myOrder.addOrderedItems(myItems_1);
        assertEquals(70, myOrder.getTotalOrderPrice(), 0.01);
    }
    
    @Test
    public void test_GetPriceAfterDiscount() {
        Order myOrder = new Order(5, 5);
        OrderedItems myItems = new OrderedItems(4, "gh", "break", 50);
        myOrder.addOrderedItems(myItems);
        assertEquals(190, myOrder.getPriceAfterDiscount(), 0.01);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_DiscountPercentage() {
        Order myOrder = new Order(4, 96);
        assertEquals(96, myOrder.getDiscountPercentage(), 0.01);
    }
}

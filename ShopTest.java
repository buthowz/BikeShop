

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class ShopTest.
 *
 * @author  Sujit Neupane
 * @version 04/21/2017
 */
public class ShopTest
{
    /**
     * Default constructor for test class ShopTest
     */
    public ShopTest()
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
    public void test_ShopGetOrder() {
        Shop myShop = new Shop();
        Order myOrder = new Order(23, 0);
        Order myOrder2 = new Order(2, 3);
        myShop.getListOfOrders().add(myOrder);
        myShop.getListOfOrders().add(myOrder2);
        assertEquals(myOrder2, myShop.getOrder(1));
    }
    
    @Test
    public void test_ShopGetPart() {
        Shop myShop = new Shop();
        Part myPart = new Part("EDR45", "Gear", 60.0);
        myShop.getListOfParts().add(myPart);
        assertEquals(myPart, myShop.getPart(0));
    }
    
    @Test
    public void test_ShopAddOrder() {
        Order myOrder = new Order(6, 10);
        Shop myShop = new Shop();
        myShop.addOrder(myOrder);
        assertEquals(myOrder, myShop.getOrder(0));
    }
    
    @Test
    public void test_ShopAddPart() {
        Shop myShop = new Shop();
        Part myPart = new Part("EDR45", "Gear", 60.0);
        myShop.addPart(myPart);
        assertEquals(myPart, myShop.getPart(0));
    }
}

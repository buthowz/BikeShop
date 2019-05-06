

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class OrderedItemsTest.
 *
 * @author  Sujit Neupane
 * @version 04/21/2017
 */
public class OrderedItemsTest
{
    /**
     * Default constructor for test class OrderedItemsTest
     */
    public OrderedItemsTest()
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
    public void test_getQuantity() {
        OrderedItems myItem = new OrderedItems(3, "re", "handle", 100.0);
        assertEquals(3, myItem.getQuantity());
    }
    
    @Test
    public void test_getQuantityPrice() {
        OrderedItems myItem = new OrderedItems(3, "re", "handle", 100.0);
        assertEquals(300.0, myItem.getQuantityPrice(), 0.01);
    }
    
    @Test
    public void test_GetPart() {
        OrderedItems myItem = new OrderedItems(3, "re", "handle", 100.0);
        Part myPart = new Part("re", "handle", 100.0);
        assertEquals(myPart.toString(), myItem.getPart().toString());
    }
}

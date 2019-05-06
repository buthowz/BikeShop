

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class PartTest.
 *
 * @author  Sujit Neupane
 * @version 04/21/2107
 */
public class PartTest
{
    /**
     * Default constructor for test class PartTest
     */
    public PartTest()
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
    public void test_GetPartNumber() {
        Part myPart = new Part("3e4", "saddle", 40.0);
        assertEquals("3e4", myPart.getPartNumber());
    }
    
    @Test
    public void test_GetPartName() {
        Part myPart = new Part("3e4", "saddle", 40.0);
        assertEquals("saddle", myPart.getPartName());
    }
    
    @Test
    public void test_GetPartRetailPrice() {
        Part myPart = new Part("3e4", "saddle", 40.0);
        assertEquals(40.0, myPart.getPartRetailPrice(), 0.01);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_ZeroRetailPrice() {
        Part myPart = new Part("3e4", "saddle", 0.0);
        assertEquals(0.00, myPart.getPartRetailPrice(), 0.01);
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_NullPartName() {
        Part myPart = new Part("23", null, 30);
        assertEquals(null, myPart.getPartName());
    }
    
    @Test (expected = IllegalArgumentException.class)
    public void test_NullPartNumber() {
        Part myPart = new Part(null, "handle", 30);
        assertEquals(null, myPart.getPartNumber());
    }
}

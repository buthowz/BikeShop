
/**
 * Contains information regarding an ordered part.
 * 
 * @author Sujit Neupane
 * @version 04/21/2017
 */

public class OrderedItems {
    
    private int quantity;
    private Part part;

    /**
     * Constructor for objects of class OrderedItems
     */
    public OrderedItems(int quantity, String partNumber, String partName, double partRetailPrice) {
        this.quantity = quantity;
        part = new Part(partNumber, partName, partRetailPrice);
    }
    
    /**
     * Gets us the quantity of the ordered part 
     * @return  quantity of the ordered part
     */
    public int getQuantity() {
        return this.quantity;
    }
    
    /**
     * Gets us a Part object which is ordered
     * @return  part which is ordered
     */
    public Part getPart() {
        return part;
    } 
    
    /**
     * Calculates the price of total part including quantity
     * @return  price of the parts including quantity
     */
    public double getQuantityPrice() {
        double price = part.getPartRetailPrice();
        return price * quantity;
    }
    
    /**
     * String representation of this class
     * @return  Part information and its quantity
     */
    public String toString() {
        return ("Quantity: " + quantity + "\t" + part.toString());
    }
    
}


/**
 * Contains information regarding an order of Bixby's Bike Shop.
 * 
 * @author Sujit Neupane
 * @version 04/21/2017
 */
import java.util.Iterator;
public class Order {
    public static final double DISCOUNT_LIMIT = 95;
    private int orderNumber;
    private double discountPercentage;
    private MyArrayList<OrderedItems> listOfOrderedItems;
    /**
     * Constructor for objects of class Order
     */
    public Order() {
        this(0, 0);
        
    }
    
    /**
     * Constructor for objects of class Order
     * param    orderNumber Order number of the order
     * @param   discountPercentage Discount percentage of the order
     */
    public Order(int orderNumber, double discountPercentage) {
        this.orderNumber = orderNumber;
        this.discountPercentage = discountPercentage;
        if (discountPercentage >= DISCOUNT_LIMIT) {
            throw new IllegalArgumentException("Discount too big!");
        }
        listOfOrderedItems = new MyArrayList<OrderedItems>();
    }
    
    /**
     * Gets us order number of this Order
     * @return  Order number
     */
    public int getOrderNumber() {
        return this.orderNumber;
    }
    
    /**
     * Gets us the discount percentage included in this order
     * @return  discount percentage applied in this order
     */
    public double getDiscountPercentage() {
        return this.discountPercentage;
    }
    
    /**
     * Gets us a list of OrderedItems objects
     * @return  an arraylist of OrderedItems objects
     */
    public MyArrayList<OrderedItems> getListOfOrderedItems() {
        return listOfOrderedItems;
    }
    
    /**
     * Gets us an OrderedItems object
     * @param   index Index number of the OrderedItems in the list
     * @return  OrderedItems object
     */
    public OrderedItems getOrderedItems(int index) {
        return listOfOrderedItems.getElement(index);
    }
    
    /**
     * Adds up OrderedItems object in the arraylist of ordered items
     * @param   item OrderedItems object only
     */
    public void addOrderedItems(OrderedItems item) {
        listOfOrderedItems.add(item);
    }
   
    /**
     * Gets total price of the order without discount
     * @return  Total price of the order without discount
     */
    public double getTotalOrderPrice() {
        Iterator<OrderedItems> myOrderIterator = listOfOrderedItems.iterator();
        double totalPrice = 0;
        while (myOrderIterator.hasNext()) {
            OrderedItems myItems = myOrderIterator.next();
            totalPrice += myItems.getQuantityPrice();
        }
        return totalPrice;
    }

    /**
     * Gets total price of the order with discount
     * @return  Total price of the order after discount 
     */
    public double getPriceAfterDiscount() {
        double priceAfterDiscount = getTotalOrderPrice() - (discountPercentage/100) * getTotalOrderPrice();
        return priceAfterDiscount;
    }
    
    /**
     * String representation of this class
     * @return String representation of the instances of this class
     */
    public String toString() {
        String result = "Order number: " + orderNumber + "\t\tDiscount percentage: " + discountPercentage;
        result +=  "\nList of Ordered Items: \n" + listOfOrderedItems.toString();
        result += "\n\nTotal Price without discount: " +  String.format("%.2f", getTotalOrderPrice()) +
        "\nTotal Price (Discount Included): " + String.format("%.2f", getPriceAfterDiscount());
        return result;
    }
}

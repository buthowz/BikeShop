
/**
 * Contains information regarding Bixby's Bike Shop's Order and Parts
 * 
 * @author Sujit Neupane     
 * @version 04/21/2017
 */
public class Shop {
    
    private MyArrayList<Part> listOfParts;
    private MyArrayList<Order> listOfOrders;
    
    /**
     * Constructor for objects of class Shop
     */
    public Shop() {
        listOfParts = new MyArrayList<Part>();
        listOfOrders = new MyArrayList<Order>();
    }
    
    /**
     * Gets us a list of Order objects
     * @return  a list of Order objects
     */
    public MyArrayList<Order> getListOfOrders() {
        return listOfOrders;
    }
    
    /**
     * Gets us a list of Part objects
     * @return  a list of a Part objects
     */
    public MyArrayList<Part> getListOfParts() {
        return listOfParts;
    }
    
    /**
     * Gets us a specific Part object on providing a index number of the object in the arraylist
     * @param   partIndex Index number of the Part object in the arraylist
     * @return  returns a specific Part object from the arraylist
     */
    public Part getPart(int partIndex) {
        return listOfParts.getElement(partIndex);
    }
    
    /**
     * Gets us a specific Order object on providing a index number of the object in the arraylist
     * @param   orderIndex Index number of the Order object in the arraylist
     * @return  returns a specific Order object from the arraylist
     */
    public Order getOrder(int orderIndex) {
        return listOfOrders.getElement(orderIndex);
    }
    
    /**
     * Adds new order to the arraylist of orders
     * @param myNewOrder New order which needs to be added in the arraylist of orders
     */
    public void addOrder(Order myNewOrder) {
        listOfOrders.add(myNewOrder);
    }
    
    /**
     * Adds new part to the arraylist of parts
     * @param part Part object which need to be added in the arraylist
     */
    public void addPart(Part part) {
        listOfParts.add(part);
    }
    
    /**
     * String representation of the Shop object
     * @return  String representaion of a list of Order objects and a list of Part objects
     */
    public String toString() {
        return ("List Of Orders:\n " + listOfOrders.toString() + "\n\nList of Parts:\n " + listOfParts.toString());
    }
    
    /**
     * Main method to show the printed Shop object
     * @param   args Array of String object as arguments
     */
    public static void main(String[] args) {
        Shop myShop = new Shop();
        Part myParts = new Part("44", "Handle", 89.0);
        Part myPartOne = new Part("44", "Handle", 32.0);
        myShop.addPart(myPartOne);
        myShop.addPart(myParts);
        Order myOrder = new Order(2, 5);
        myShop.addOrder(myOrder);
        Order myOrderOne = new Order(2, 5);
        myShop.addOrder(myOrderOne);
        System.out.println(myShop);
    }
}

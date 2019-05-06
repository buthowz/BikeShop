
/**
 * Interacts with client and allow to make sample orders.
 * 
 * @author Sujit Neupane
 * @version 04/23/2017
 */
import java.util.Scanner;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
@SuppressWarnings("unchecked")
public class ClientApp {
    /**
     * Constructor for objects of class ClientApp
     */
    public ClientApp() {

    }

    public static void main(String[] args) {
        Scanner orderNumberInput = new Scanner(System.in);
        System.out.print("Enter order number(Only Integer Numbers): ");        
        while (!orderNumberInput.hasNextInt()) {
            System.out.println("Order number must be integer number only!");
            System.out.print("Enter order number(Only Integer Numbers): ");
            orderNumberInput = new Scanner(System.in);
        }
        int orderNumber = orderNumberInput.nextInt();
        Scanner discountInput = new Scanner(System.in);
        System.out.print("Enter discount percentage(Numbers below 95): ");
        while (!discountInput.hasNextDouble()) {
            System.out.println("Discount percentage must be numbers below 95 only");
            System.out.print("Enter discount percentage(Numbers only): ");
            discountInput = new Scanner(System.in);
        }
        double discountPercentage = discountInput.nextDouble();
        
        Shop myShop = new Shop();
        Order myOrder = new Order(orderNumber, discountPercentage);
        myShop.addOrder(myOrder);
        MyArrayList<Part> parts = myShop.getListOfParts();
        
        // reading serailized part file        
        try {
            FileInputStream partFile = new FileInputStream("newPart.ser");
            ObjectInputStream in = new ObjectInputStream(partFile);
            parts = (MyArrayList<Part>)in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
        System.out.println();
        System.out.println(parts.toString());
        System.out.print("\nPress: 1 for 1st part, 2 for 2nd part, 3 for 3rd part, 4 for 4th part, 5 for 5th part \nand any other key to finish order\n\nEnter your choice: ");
        Scanner addItemInOrder = new Scanner(System.in);
        String finishOrder = addItemInOrder.next();
       
        while (finishOrder.matches("[1-5]")) {
                        
            if (finishOrder.matches("[1]")) {
                System.out.print("Enter Quantity: ");
                Scanner quantityInput = new Scanner(System.in);
                int quantity = quantityInput.nextInt();
                OrderedItems itemOne = new OrderedItems(quantity, parts.getElement(0).getPartNumber(), parts.getElement(0).getPartName(), parts.getElement(0).getPartRetailPrice());
                myOrder.addOrderedItems(itemOne);
            }
            if (finishOrder.matches("[2]")) {
                System.out.print("Enter Quantity: ");
                Scanner quantityInput = new Scanner(System.in);
                int quantity = quantityInput.nextInt();
                OrderedItems itemTwo = new OrderedItems(quantity, parts.getElement(1).getPartNumber(), parts.getElement(1).getPartName(), parts.getElement(1).getPartRetailPrice());
                myOrder.addOrderedItems(itemTwo);
            }
            if (finishOrder.matches("[3]")) {
                System.out.print("Enter Quantity: ");
                Scanner quantityInput = new Scanner(System.in);
                int quantity = quantityInput.nextInt();
                OrderedItems itemThree = new OrderedItems(quantity, parts.getElement(2).getPartNumber(), parts.getElement(2).getPartName(), parts.getElement(2).getPartRetailPrice());
                myOrder.addOrderedItems(itemThree);
            }
            if (finishOrder.matches("[4]")) {
                System.out.print("Enter Quantity: ");
                Scanner quantityInput = new Scanner(System.in);
                int quantity = quantityInput.nextInt();
                OrderedItems itemFour = new OrderedItems(quantity, parts.getElement(3).getPartNumber(), parts.getElement(3).getPartName(), parts.getElement(3).getPartRetailPrice());
                myOrder.addOrderedItems(itemFour);
            }
            if (finishOrder.matches("[5]")) {
                System.out.print("Enter Quantity: ");
                Scanner quantityInput = new Scanner(System.in);
                int quantity = quantityInput.nextInt();
                OrderedItems itemFive = new OrderedItems(quantity, parts.getElement(4).getPartNumber(), parts.getElement(4).getPartName(), parts.getElement(4).getPartRetailPrice());
                myOrder.addOrderedItems(itemFive);
            }
            System.out.print("Enter your choice: ");
            addItemInOrder = new Scanner(System.in);
            finishOrder = addItemInOrder.next();
        }
        System.out.println();
        System.out.println(myOrder.toString());        
    }
    
}

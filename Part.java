
/**
 * Contains information regarding a part of Bixby's Bikes .
 * 
 * @author Sujit Neupane 
 * @version 04/21/2017
 */
import java.io.Serializable;
public class Part implements Serializable {
   
    private String partNumber;
    private String partName;
    private double partRetailPrice;
    
    /**
     * Constructor for objects of class Part
     */
    public Part(String partNumber, String partName, double partRetailPrice) {
        if (partRetailPrice <= 0) {
            throw new IllegalArgumentException("Price error!");
        }
        if (partName == null) {
            throw new IllegalArgumentException("Empty Part Name!");
        }
        if (partNumber == null) {
            throw new IllegalArgumentException("Empty Part Number!");
        }
        this.partNumber = partNumber;
        this.partName = partName;
        this.partRetailPrice = partRetailPrice;
    }
    
    /**
     * Gets us a part number of the part
     * @return part number of the part
     */
    public String getPartNumber() {
        return partNumber;
    }
    
    /**
     * Gets us a part name of the part
     * @return part name of the part
     */
    public String getPartName() {
        return partName;
    }
    
    /**
     * Gets us a retail price of the part
     * @return retail price of the part
     */
    public double getPartRetailPrice() {
        return partRetailPrice;
    }
    
    /**
     * String represenation of this class
     * @return String representation of the instances of this class
     */
    public String toString() {
        return ("Part Number: " + partNumber + "\tPart Retail Price: " + partRetailPrice + "\tPart Name: " + partName);
    }    
}

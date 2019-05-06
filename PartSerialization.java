
/**
 * Serailizing a text file containing parts and its description.
 * 
 * @author Sujit Neupane     
 * @version 04/23/2017
 */
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;
@SuppressWarnings("unchecked")
public class PartSerialization {
    private MyArrayList<Part> parts;
    /**
     * Constructor for objects of class PartSerialization
     * @param   fileName file which needs to be serialized
     */
    
    public PartSerialization(String fileName) {
        parts = new MyArrayList<Part>();
        
        Part partOne = new Part("FRMSS01", "Frame, stainless steel", 1993.25);
        Part partTwo = new Part("RIMBLK23", "Rim set, black", 89.95);
        Part partThree = new Part("BRKMNT23", "Cantilever brake mounts", 39.95);
        Part partFour = new Part("WTRBTLRE01", "Water bottle reinforcements", 10.00);
        Part partFive = new Part("FRKBLDSS03", "Fork blades, stainless steel", 169.95);
        //adding five parts in the arraylist of Part
        parts.add(partOne);
        parts.add(partTwo);
        parts.add(partThree);
        parts.add(partFour);
        parts.add(partFive);
        partSerialization(fileName);
        //partDeserialization(fileName);
    }
    
    /**
     * Serialize the provided file
     * @param    fileName file to be serialized
     */
    
    public void partSerialization(String fileName) {
        //serialization started
        try {
            FileOutputStream partFileOut = new FileOutputStream(fileName);
            ObjectOutputStream out = new ObjectOutputStream(partFileOut);
            out.writeObject(parts);
        } catch (IOException e) {
            System.out.println("File not found");
        }
    }
    
    /**
     * Deserialize the provided file
     * @param    fileName file which needs to be deserialize
     */
    public void partDeserialization(String fileName) {
        try {
            FileInputStream partFile = new FileInputStream(fileName);
            ObjectInputStream in = new ObjectInputStream(partFile);
            parts = (MyArrayList<Part>)in.readObject();
        } catch (FileNotFoundException e) {
            System.out.println("File does not exist");
        } catch (IOException e) {
            System.out.println("File not found");
        } catch (ClassNotFoundException e) {
            System.out.println("Class not found");
        }
    }
    
    public static void main(String[] args) {
        PartSerialization ps = new PartSerialization("newPart.ser");
    } 
}

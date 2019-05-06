
/**
 * My interface for arraylist of objects to use in project 3, Bixby's Bike
 * 
 * @author Sujit Neupane 
 * @version 04/19/2017
 */
public interface MyArrayListInterface<E>
{
    /**
     * Adds an element into the generic arraylist 
     * @param  element   element to be added to the arraylist
     * @return true if the element is added successfully
     */    
    public abstract boolean add(E element); 
    
    /**
     * Displays size of the arraylist
     * @return size of the arraylist
     */
    public int size();
    
    /**
     * Removes element from the arraylist which is specified by the index number
     * @param index Index number of the element which needs to be removed from the arraylist
     * @return reduced size of the arraylist, as an element has been removed from arraylist
     */
    public E remove(int index);
    
    /**
     * Checks if the specified element exists in the arraylist
     * @param element The element to be checked if it exists in the arraylist
     * @return true if the element is present in the arraylist
     */
    public boolean contains(E element);
    
    /**
     * Gets us specified element in the arraylist
     * @param index number of the element which is to be retrieved from the arraylist
     * @return An element from the arraylist and is specified by the index number 
     */
    public E getElement(int index);
    
    /**
     * Checks whether the arraylist is empty or not
     * @return true if the arraylist is empt
     */
    public boolean isEmpty();
	
	/**
	* Clears the whole arraylist
	*/
	public void clear();   
}
